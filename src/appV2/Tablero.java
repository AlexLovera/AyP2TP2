package appV2;

import java.util.HashMap;

public class Tablero {

	private static Tablero tableroSingleton;
	private int numeroDeCasilleros;
	private int numeroDeColumnas;
	private int numeroDeFilas;
	private int posicionSalida;
	public HashMap<Integer, ObjetosEscondidos> casilleros = new HashMap<Integer, ObjetosEscondidos>();

	private Tablero() {

	}

	public static Tablero getTableroSingleton() {
		if (tableroSingleton == null) {
			tableroSingleton = new Tablero();
		}
		return tableroSingleton;
	}

	// para el gestor
	public void setDimensionesDeTablero(int numeroDeFilas, int numeroDeColumnas) {
		this.numeroDeColumnas = numeroDeColumnas;
		this.numeroDeFilas = numeroDeFilas;
		this.numeroDeCasilleros = numeroDeColumnas * numeroDeFilas;
	}

	public int getNumeroDeFilas() {
		return numeroDeFilas;
	}

	public int getNumeroDeColumnas() {
		return numeroDeColumnas;
	}

	public int getNumeroDeCasilleros() {
		return numeroDeCasilleros;
	}

	public void agregarObjetoAlCasillero(int posicion, ObjetosEscondidos objeto) throws ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
//		if (posicion == this.posicionSalida) {
//			throw new ItemsSobreSalidaNoPermitida("No se permite poner items sobre la salida");
//		}
//		
//		if (posicion == Pac.getPac().getPosicionDeEntrada()) {
//			throw new ItemsSobreEntradaNoPermitida("No se permite poner items sobre la entrada");
//		}
//		
		// ver si funciona...
		if (casilleros.get(posicion) != null) {
			casilleros.replace(posicion, objeto);
		} else {
			casilleros.put(posicion, objeto);
		}
	}

	public ObjetosEscondidos devolverObjetoEnCasillero(int posicion) {
		return this.casilleros.get(posicion);
	}
	
	public void eliminarObjetoEnCasillero(int posicion) {
		if (!this.casilleros.containsKey(posicion)) {
			// Excepción
		}
		
		this.casilleros.remove(posicion);
	}

	public HashMap<Integer, ObjetosEscondidos> devolverCasilleros() {
		return casilleros;
	}

	public void pintarTablero() {
		Pac pac = Pac.getPac();
//		System.err.println(Pac.getPac().getPosicion());
		for (int casillero = 0; casillero < this.numeroDeCasilleros; casillero++) {
			boolean esFinDeColumna = casillero != 0 && casillero % this.numeroDeColumnas == 0;
									
			if (esFinDeColumna) {
				System.out.print("|");
				System.out.print("\n");
			} 
			System.out.print("|");
			// if(casillero==posicionSalida) System.err.println("S"); else 
			if (casilleros.containsKey(casillero)) {
				System.out.print(casilleros.get(casillero).toString());
			} else if (casillero == posicionSalida) {
				System.out.print("S");
			} else if (casillero == Pac.getPac().getPosicion()) {
				System.out.print("P");
			} else {
				System.out.print(" ");
			}	
		}
		System.out.print("|");
	}
	
	public void setSalida(int salida) throws ItemsSobreSalidaNoPermitida {
		if (this.casilleros.containsKey(salida)) {
			throw new ItemsSobreSalidaNoPermitida("No se permite poner la salida donde hay items");
		}
		
		this.posicionSalida=salida;
	}
	public int getSalida() {
		return posicionSalida;
	}
	
	public void pintarMarcador() {
		Pac pac= Pac.getPac();
		System.out.println("\nEscudo: "+pac.getPuntosDeEscudo()+" Vidas: "+pac.getVidas());
	}
	
	/*
	public void setEntrada(int entrada) throws ItemsSobreEntradaNoPermitida {
		if (this.casilleros.containsKey(entrada)) {
			throw new ItemsSobreEntradaNoPermitida("No se permite poner la entrada donde hay items");
		}
		
		this.posicionEntrada=entrada;
	}*/

}