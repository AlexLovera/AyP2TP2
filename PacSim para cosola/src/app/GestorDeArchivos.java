import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
public class GestorDeArchivos {

	private final static String RUTA_CONFIGURACION = "C://Users//Alexa//Desktop//AyP2TP2Local//src//Configuracion";
	private Tablero tablero;
	// Este hashmap es solo auxiliar para resolver las referencias en el archivo de configuracion
	private HashMap<String, ArrayList<String>> mapaDeProvisiones = new HashMap<String, ArrayList<String>>();
	// Auxiliar para chequear si hay que reemplazar Mina por ProvisionYMina
	private ArrayList<Integer> listaDeMinas = new ArrayList<Integer>();
	

	public Tablero getTablero() throws IOException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		crearTablero();
		return tablero;
	}

	public void crearTablero() throws IOException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		int posicion = 0;
		tablero = Tablero.getTableroSingleton();
				
		try {
			FileReader archivo = new FileReader(RUTA_CONFIGURACION);
			BufferedReader lector = new BufferedReader(archivo);
			String seccion = "";
			String unaLinea;
							
			while ((unaLinea = lector.readLine()) != null) {
				posicion++;
				if (unaLinea.contentEquals("[TABLERO]")) {
					seccion = "tablero";
				} else if (unaLinea.contentEquals("[MINAS]")) {
					seccion = "minas";
				} else if (unaLinea.contentEquals("[PROVISIONES]")) {
					seccion = "provisiones";
				} else if (unaLinea.contentEquals("[UBICACION_PROVISIONES]")) {
					seccion = "ubicacion_provisiones";
				}
				
				if (seccion.equals("tablero")) {
					procesarLineaDeTablero(unaLinea);
				} else if (seccion.contentEquals("minas")) {
					procesarLineaDeMinas(unaLinea);
				} else if (seccion.contentEquals("provisiones")) {
					procesarLineaDeProvisiones(unaLinea);
				} else if (seccion.contentEquals("ubicacion_provisiones")) {
					procesarLineaDeUbicacionProvisiones(unaLinea);
				} 
			}
			
			archivo.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo de configuracion");	
		} catch (NoSuchElementException e) {
			System.out.println("Linea mal formada en posicion: " + posicion);	
		} catch (IOException e) {
			System.out.println("No se pudo interpretar la linea: " + posicion);
		}

	}

	private void procesarLineaDeUbicacionProvisiones(String unaLinea) throws NumberFormatException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		
		if (!unaLinea.contentEquals("[UBICACION_PROVISIONES]")) {
			String[] variable = unaLinea.split("=");
			
			String[] datos = variable[1].split(",");
			
			for (int i = 0; i < datos.length; i++) {
				Integer posicion = Integer.parseInt(datos[i]);
				ArrayList<String> listaDeProvisiones = this.mapaDeProvisiones.get(variable[0]);
				ComboDeProvisiones combo = new ComboDeProvisiones();
				
				for (String provision: listaDeProvisiones) {
					if (provision.equals("E")) {
						combo.agregarProvisiones(new EscudoDeFuerza());
					} else if (provision.equals("V")) {
						combo.agregarProvisiones(new CajaDeVitaminas());
					}
				}
				
				// Si la posicion tiene mina se reemplaza por ProvisionYMina
				if (this.listaDeMinas.contains(posicion)) {
					ProvisionYMina provisionYMina = new ProvisionYMina(combo, new Mina());
					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicion, provisionYMina);
				} else {
					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicion, combo);
				}
			}
		}
		
	}

	private void procesarLineaDeProvisiones(String unaLinea) {

		if (!unaLinea.contentEquals("[PROVISIONES]")) {
			String[] variable = unaLinea.split("=");
			
			String[] datos = variable[1].split(",");
			
			for (int i = 0; i < datos.length; i++) {
				if (!this.mapaDeProvisiones.containsKey(variable[0])) {
					this.mapaDeProvisiones.put(variable[0], new ArrayList<String>());
				}
	 			if (datos[i].equals("E")) {
					this.mapaDeProvisiones.get(variable[0]).add("E");
				} else if (datos[i].equals("V")) {
					this.mapaDeProvisiones.get(variable[0]).add("V");
				} else {
					ArrayList<String> referencia = this.mapaDeProvisiones.get(datos[i]);
					for (String provision: referencia) {
						this.mapaDeProvisiones.get(variable[0]).add(provision);
					}
				}
			}
		}
		
	}

	private void procesarLineaDeMinas(String unaLinea) throws NumberFormatException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {

		if (!unaLinea.contentEquals("[MINAS]")) {
			String[] variable = unaLinea.split("=");
			if (variable[0].equals("B")) {
				String[] arregloDeMinas = variable[1].split(",");
				
				// Lo mantenemos en un atributo para ver luego en provisiones si hay mina
				for (int i = 0; i < arregloDeMinas.length; i++) {
					this.listaDeMinas.add(Integer.parseInt(arregloDeMinas[i]));
				}

				for (Integer posicion: this.listaDeMinas) {
					Mina mina = new Mina();
					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicion, mina);
				}
			}
		}
		
	}

	private void procesarLineaDeTablero(String unaLinea) throws NumberFormatException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		
		if (!unaLinea.contentEquals("[TABLERO]")) {
			String[] variable = unaLinea.split("=");
			
			switch (variable[0]) {
			case "N":
				Tablero.getTableroSingleton().setNumeroDeFilas(Integer.parseInt(variable[1]));
				break;
			case "M":
				Tablero.getTableroSingleton().setNumeroDeColumnas(Integer.parseInt(variable[1]));
				break;
			case "E":
				Pac.getPac().setPosicionDeEntrada(Integer.parseInt(variable[1]));
				break;
			case "S":
				Tablero.getTableroSingleton().setSalida(Integer.parseInt(variable[1]));
				break;
			case "L":
				// Solo necesitamos una instancia de Pared
				Pared pared = new Pared();
				Tablero tablero = Tablero.getTableroSingleton();
				
				for (int i = 0; i < tablero.getNumeroDeCasilleros(); i++) {
					boolean hayParedEnCasillero = variable[1].charAt(i) == '1';
					if (hayParedEnCasillero) {
						Tablero.getTableroSingleton().agregarObjetoAlCasillero(i, pared);
					}
				}
				break;
			default:
				break;
			}
		}
	}


	
}