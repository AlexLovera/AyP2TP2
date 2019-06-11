package appV2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import appV2.Mina;

public class GestorDeArchivos {

	private final static String RUTA_CONFIGURACION = "src//Configuracion";
	private int posicionEntrada;
	private int posicionSalida;
	private Tablero tablero;
	private ArrayList<Provisiones> provisiones;

	public Tablero getTablero() throws IOException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		crearTablero();
		return tablero;
	}

	public void crearTablero() throws IOException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		FileReader s = new FileReader(RUTA_CONFIGURACION);
		Scanner scanner = new Scanner(s);
		tablero = Tablero.getTableroSingleton();
		leerApartadoTablero(scanner);
		leerApartadoMinas(scanner);
		leerApartadoProvisiones(scanner);
		Tablero.getTableroSingleton().pintarTablero();
		// falta implementar
		// leerApartadoUbicacionProvisiones(scanner);
		scanner.close();
	}
//			P1=E
//			P2=V
//			P3=E,E
//			P4=P1,P1,P2
//			P6=P5,V,P3
	//P1=E
	//P2=P1,V
	private void leerApartadoProvisiones(Scanner scanner) throws NumberFormatException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		HashMap<Integer, Provisiones> mapaProvisiones=new HashMap<Integer, Provisiones>();
		int numeroDeProvision=1;
		scanner.nextLine();
		scanner.nextLine();
//		System.err.println(scanner.nextLine());
//		System.err.println(scanner.next());
		scanner.findInLine("=");
		String next=scanner.next();
//		System.err.println(next);
		while(!(next.equals("[UBICACION_PROVISIONES]"))&&scanner.hasNextLine()) {
//			System.err.println("Entra");

			StringTokenizer partes=new StringTokenizer(next,",");
//			System.out.println(partes.nextToken());
//			partes.nextToken("=");
			
			while(partes.hasMoreTokens()) {
				String provision=partes.nextToken();
				//ver esto
//				System.err.println("Longitud: "+provision);
				if(provision.length()==2) {
					//HASTA ACA LLEGA
					int segundoDigito=provision.charAt(1);
//					System.err.println(segundoDigito);
					//segundoDigito<=numeroDeProvision; con esta condicion no entra...
					if(segundoDigito>=0) {

						if(mapaProvisiones.get(numeroDeProvision)==null) {

							mapaProvisiones.put(numeroDeProvision, new ComboDeProvisiones(mapaProvisiones.get(segundoDigito)));							
						} else {
							
							ComboDeProvisiones auxiliar=new ComboDeProvisiones(mapaProvisiones.get(numeroDeProvision));
//							System.err.println(mapaProvisiones.get(segundoDigito));
							auxiliar.agregarProvisiones(mapaProvisiones.get(segundoDigito));
//							mapaProvisiones.replace(numeroDeProvision,auxiliar);
							mapaProvisiones.put(numeroDeProvision,auxiliar);		
						}							
					}// else throw new Excepcion;
				} else {
					switch(provision) {
					case "E":
						if(mapaProvisiones.get(numeroDeProvision)==null) {
							mapaProvisiones.put(numeroDeProvision, new EscudoDeFuerza());							
						} else {
							ComboDeProvisiones auxiliar=new ComboDeProvisiones(mapaProvisiones.get(numeroDeProvision));
							auxiliar.agregarProvisiones(new EscudoDeFuerza());
							mapaProvisiones.put(numeroDeProvision,auxiliar);
						}
						break;
					case "V":
						if(mapaProvisiones.get(numeroDeProvision)==null) {
							mapaProvisiones.put(numeroDeProvision, new CajaDeVitaminas());						
						} else {
							ComboDeProvisiones auxiliar=new ComboDeProvisiones(mapaProvisiones.get(numeroDeProvision));
							auxiliar.agregarProvisiones(new CajaDeVitaminas());
							mapaProvisiones.put(numeroDeProvision,auxiliar);
						}
						break;
					}
				}	
			}
			numeroDeProvision++;
			scanner.nextLine();
			scanner.findInLine("=");
			next=scanner.next();
		}
//		System.out.println(partes.nextToken());
		ComboDeProvisiones auxiliar=new ComboDeProvisiones(mapaProvisiones.get(3));
//		System.err.println(mapaProvisiones);
		leerEIntroducirProvisiones(scanner, mapaProvisiones);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int numeroDeProvision=1;
//		//numero de provision y provision
//		HashMap<Integer, Provisiones> provisiones=new HashMap<Integer, Provisiones>();
//		//mientras haya una P
////		System.out.println(scanner.next());
//		String valorInicial=scanner.next();
//		while(scanner.hasNext()&&(valorInicial.charAt(0)=='P')) {
////			System.err.println("Entra a la provision");
////			System.err.println(scanner.next());
//			scanner.findInLine("=");
//			StringTokenizer separador=new StringTokenizer(scanner.next(),",");
//			while(separador.hasMoreTokens()) {
//				String valorActual=separador.nextToken();
//				if(valorActual.length()==2) {
////					System.err.println("2 caracteres");
//					//provision combinada
//					if(valorActual.charAt(1)<=numeroDeProvision) {
//						//en el numero actual de provision, si es otra provision a agregar, la busco en el hashMap y la agrego a la actual
//						provisiones.put(numeroDeProvision, provisiones.get(valorActual.charAt(1)));
//					}
//				} else {					
////					System.err.println("1 caracter");
//					switch(valorActual) {
//						case "E":
//							provisiones.put(numeroDeProvision, new EscudoDeFuerza());
//							break;
//						case "V":
//							//se le suma una vida? asumimos eso
//							provisiones.put(numeroDeProvision, new CajaDeVitaminas());
//							break;
//						default:
//							//excepcion?
//							System.err.println("Provision no permitida");
//					}
//				}
////				valorActual=separador.nextToken();
//			}
//			numeroDeProvision++;
//		}
//		System.err.println(provisiones);
//		leerEIntroducirProvisiones(scanner, provisiones);
	}
//	P1=E
//	P2=V
//	P3=E,E
//	P4=P1,P1,P2
	private void leerEIntroducirProvisiones(Scanner scanner, HashMap<Integer, Provisiones> provisiones) throws NumberFormatException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		scanner.nextLine();
//		scanner.nextLine();
		scanner.findInLine("=");
		StringTokenizer separador=new StringTokenizer(scanner.next(),",");
		int numeroDeProvision=1;
		while(separador.hasMoreTokens()) {	
			String nextToken=separador.nextToken();
			
			
			
//			System.err.println(nextToken);
			
			
			
			
			if(!(Tablero.getTableroSingleton().devolverObjetoEnCasillero(Integer.parseInt(nextToken)) instanceof Pared)) {
				Tablero.getTableroSingleton().agregarObjetoAlCasillero(Integer.parseInt(nextToken),provisiones.get(numeroDeProvision));
			} else if(Tablero.getTableroSingleton().devolverObjetoEnCasillero(Integer.parseInt(nextToken)) instanceof Mina){
				//si ya hay una mina en el casillero que se quiere introducir, se crea objeto de tipo ProvisionYMina
				ProvisionYMina conjunto=new ProvisionYMina(provisiones.get(numeroDeProvision), new Mina());
				Tablero.getTableroSingleton().agregarObjetoAlCasillero(Integer.parseInt(nextToken),conjunto);
			}
			numeroDeProvision++;
			//patron
			if(scanner.hasNextLine()) {
				scanner.nextLine();
				scanner.findInLine("=");
				separador=new StringTokenizer(scanner.next(),",");				
			}				
		}	
	}
	private void introducirProvisionesAlTablero() {
		
	}
	

	private void leerApartadoMinas(Scanner scanner) throws ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		//al ser valores dobles y tener coma de por medio, se tiene que usar StringTokenizer
		scanner.nextLine();
		scanner.nextLine();
		scanner.findInLine("=");
		StringTokenizer separador=new StringTokenizer(scanner.next(),",");
		while(separador.hasMoreTokens()) {
				Tablero.getTableroSingleton().agregarObjetoAlCasillero(Integer.parseInt(separador.nextToken()), new Mina());
		}			
	}

	private void crearProvisiones(StringBuilder provisiones) {

	}

	private void introducirMinasAlTablero() {

	}


	private void leerApartadoTablero(Scanner scanner) throws ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		int cantidadDeColumnas = 0;
		// las key empiezan en 1, casilleros
		int posicionDeCasillero = 0;
		for (int iterador = 0, casos = 0; iterador < 4; iterador++, casos++) {
			scanner.nextLine();
			scanner.findInLine("=");
			switch (casos) {
			case 0:
				cantidadDeColumnas = scanner.nextInt();
				break;
			case 1:
				tablero.setDimensionesDeTablero(scanner.nextInt(), cantidadDeColumnas);
				break;
			case 2:
				posicionSalida = scanner.nextInt();
				break;
			case 3:
				posicionEntrada = scanner.nextInt();
				break;
			}
		}
		if (scanner.hasNext()) {
			scanner.nextLine();
			scanner.findInLine("L=");
			String listaDeValoresJuntos = scanner.next();
			char[] listaDeValores = new char[listaDeValoresJuntos.length()];
			listaDeValores = listaDeValoresJuntos.toCharArray();
//			System.err.println(listaDeValores);
			for (int i = 0; (i < listaDeValores.length)
					&& (i <= Tablero.getTableroSingleton().getNumeroDeCasilleros()); i++) {
				//si hay un objeto en la posicion de salida, poner como casillero libre
//				if(listaDeValores[posicionDeCasillero] == '1'&&posicionDeCasillero==posicionSalida-1) {
//					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicionDeCasillero, new PosicionLibre());
//				}else if (listaDeValores[i] == '0') {
//					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicionDeCasillero, new PosicionLibre());
//				} 
				if (listaDeValores[i] == '1'&& posicionSalida!=posicionDeCasillero) {
					Tablero.getTableroSingleton().agregarObjetoAlCasillero(posicionDeCasillero, new Pared());
				}
				posicionDeCasillero++;				
			}
		}
//		Tablero.getTableroSingleton().setEntrada(posicionEntrada);
		Pac.getPac().setPosicionDeEntrada(posicionEntrada+1);
//		Pac.getPac().moverAPac(posicionEntrada+1);
		Tablero.getTableroSingleton().setSalida(posicionSalida);
//		Tablero.getTableroSingleton().pintarTablero();
	}
}