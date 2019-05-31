package app;

public class MovimientoDePac {
	VerificadorDePosicion verificador = new VerificadorDePosicion();
	
	public boolean moverAPacALaDerecha() {
		int posicionActual = Pac.getPac().obtenerPosicionDePac() - 1;
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual).sePuedeAvanzar()) {
			Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicionActual)
					.ejecutarComportamiento(Pac.getPac());
			Pac.getPac().moverAPac(posicionActual);
			return true;
		} else
			return false;
	}
}