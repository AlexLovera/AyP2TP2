public class VerificadorDePosicion {

	private Pac pac;

	public VerificadorDePosicion() {
		pac = Pac.getPac();
	}

	public boolean sePuedeAvanzarHaciaLaDerecha() {
		pac = Pac.getPac();
		int columnas = Tablero.getTableroSingleton().getNumeroDeColumnas();
		int posicion = pac.obtenerPosicionDePac();
		if ((posicion + 1) % columnas == 0) {
			return false;
		}
		return true;
	}

	public boolean sePuedeAvanzarHaciaLaIzquierda() {
		pac = Pac.getPac();
		int columnas = Tablero.getTableroSingleton().getNumeroDeColumnas();
		int posicion = pac.obtenerPosicionDePac();
		if (posicion % columnas  == 0) {
			return false;
		}
		return true;
	}

	public boolean sePuedeAvanzarHaciaArriba() {
		pac = Pac.getPac();
		int posicion = pac.obtenerPosicionDePac();
		int columnas = Tablero.getTableroSingleton().getNumeroDeColumnas();
		if (posicion - columnas < 0) {
			return false;
		}
		return true;
	}

	public boolean sePuedeAvanzarHaciaAbajo() {
		pac = Pac.getPac();
		int inicioUltimaFila = Tablero.getTableroSingleton().getNumeroDeCasilleros()
				- Tablero.getTableroSingleton().getNumeroDeColumnas();
		int posicion = pac.obtenerPosicionDePac();
		if (posicion >= inicioUltimaFila) {
			return false;
		}
		return true;
	}

}