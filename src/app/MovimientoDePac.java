package app;

public class MovimientoDePac {
	VerificadorDePosicion verificador = new VerificadorDePosicion();
	
	public boolean moverAPacHaciaLaDerecha() {
		int posicionActual = Pac.getPac().obtenerPosicionDePac() + 1;
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual).sePuedeAvanzar()) {
			Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual)
					.ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionActual);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaLaIzquierda() {
		int posicionActual = Pac.getPac().obtenerPosicionDePac() - 1;
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual).sePuedeAvanzar()) {
			Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual)
					.ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionActual);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaAbajo() {
		int posicionActual = Pac.getPac().obtenerPosicionDePac() + Tablero.getTableroSingleton().getNumeroDeColumnas();
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual).sePuedeAvanzar()) {
			Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual)
					.ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionActual);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaArriba() {
		int posicionActual = Pac.getPac().obtenerPosicionDePac() - Tablero.getTableroSingleton().getNumeroDeColumnas();
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual).sePuedeAvanzar()) {
			Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual)
					.ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionActual);
			return true;
		} else
			return false;
	}
	
}