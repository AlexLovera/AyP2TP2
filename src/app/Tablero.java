package app;

import java.util.HashMap;

public class Tablero {

	private static Tablero tableroSingleton;
	private int numeroDeCasilleros;
	private int numeroDeColumnas;
	private int numeroDeFilas;
	private int posicionEntrada;
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
	public void setDimensionesDeTableros(int numeroDeFilas, int numeroDeColumnas) {
		this.numeroDeColumnas = numeroDeColumnas;
		this.numeroDeFilas = numeroDeFilas;
		numeroDeCasilleros += (numeroDeColumnas * numeroDeFilas);
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

	public void agregarObjetoAlCasillero(int posicion, ObjetosEscondidos objeto) {
		// ver si funciona...
		if (casilleros.get(posicion) != null) {
			casilleros.replace(posicion, objeto);
		} else {
			casilleros.put(posicion, objeto);
		}
	}

	public ObjetosEscondidos devolverObjetoEnCasillero(int posicion) {
		return casilleros.get(posicion);
	}

	public HashMap<Integer, ObjetosEscondidos> devolverCasilleros() {
		return casilleros;
	}

	public void pintarTablero(HashMap<Integer, ObjetosEscondidos> casilleros) {
		int elementosPintados = 1;
		while (elementosPintados < numeroDeCasilleros) {
			if (casilleros.get(elementosPintados).sePuedeAvanzar()) {
				System.out.print(" ");
				elementosPintados++;
			} else {
				System.err.print("X");
				elementosPintados++;

			}
		}

	}
}