package app;

public class MovimientoDePac {
	VerificadorDePosicion verificador = new VerificadorDePosicion();
	
	public boolean moverAPacHaciaLaDerecha() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() + 1;
		Tablero tablero = Tablero.getTableroSingleton();
		if (tablero.devolverObjetoEnCasillero(posicionDestino).sePuedeAvanzar()) {
			tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionDestino);
			// Una vez ejecutado el comportamiento se puede remover el objeto de esa posición
			tablero.eliminarObjetoEnCasillero(posicionDestino);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaLaIzquierda() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() - 1;
		Tablero tablero = Tablero.getTableroSingleton();
		if (tablero.devolverObjetoEnCasillero(posicionDestino).sePuedeAvanzar()) {
			tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionDestino);
			// Una vez ejecutado el comportamiento se puede remover el objeto de esa posición
			tablero.eliminarObjetoEnCasillero(posicionDestino);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaAbajo() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() + Tablero.getTableroSingleton().getNumeroDeColumnas();
		Tablero tablero = Tablero.getTableroSingleton();
		if (tablero.devolverObjetoEnCasillero(posicionDestino).sePuedeAvanzar()) {
			tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionDestino);
			// Una vez ejecutado el comportamiento se puede remover el objeto de esa posición
			tablero.eliminarObjetoEnCasillero(posicionDestino);
			return true;
		} else
			return false;
	}
	
	public boolean moverAPacHaciaArriba() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() - Tablero.getTableroSingleton().getNumeroDeColumnas();
		Tablero tablero = Tablero.getTableroSingleton();
		if (tablero.devolverObjetoEnCasillero(posicionDestino).sePuedeAvanzar()) {
			tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionDestino);
			// Una vez ejecutado el comportamiento se puede remover el objeto de esa posición
			tablero.eliminarObjetoEnCasillero(posicionDestino);
			return true;
		} else
			return false;
	}
	
}