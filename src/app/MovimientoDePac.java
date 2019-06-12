package app;

public class MovimientoDePac {
	private static VerificadorDePosicion verificador = new VerificadorDePosicion();
	
	public static boolean moverAPac(String entrada) {
		switch (entrada) {
		case "Derecha":
			return moverAPacHaciaLaDerecha();
//			break;
		case "Izquierda":
			return moverAPacHaciaLaIzquierda();
//			break;
		case "Arriba":
			return moverAPacHaciaArriba();
//			break;
		case "Abajo":
			return moverAPacHaciaAbajo();
//			break;
		default: 
			System.err.println("Debe ingresar un comando valido");
			return true;
		} 
		
	}

	public static boolean moverAPacHaciaLaDerecha() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() + 1;
		Tablero tablero = Tablero.getTableroSingleton();
		if (!(tablero.devolverObjetoEnCasillero(posicionDestino) instanceof Pared)) {
			if(tablero.devolverObjetoEnCasillero(posicionDestino) != null) {
				tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
				// Una vez ejecutado el comportamiento se puede remover el objeto de esa posici�n
				tablero.eliminarObjetoEnCasillero(posicionDestino);				
			}
			Pac.getPac().moverAPac(posicionDestino);
			return true;
		} else 
			//Antes boolean, pero se corta el while asi...
			return true;			
	}
	
	public static boolean moverAPacHaciaLaIzquierda() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() - 1;
		Tablero tablero = Tablero.getTableroSingleton();
		if (!(tablero.devolverObjetoEnCasillero(posicionDestino) instanceof Pared)) {
			if(tablero.devolverObjetoEnCasillero(posicionDestino) != null) {
				tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
				// Una vez ejecutado el comportamiento se puede remover el objeto de esa posici�n
				tablero.eliminarObjetoEnCasillero(posicionDestino);				
			}
			Pac.getPac().moverAPac(posicionDestino);
			return true;
		} else
			//Antes boolean, pero se corta el while asi...
			return true;
	}
	
	public static boolean moverAPacHaciaAbajo() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() + Tablero.getTableroSingleton().getNumeroDeColumnas();
		Tablero tablero = Tablero.getTableroSingleton();
		if (!(tablero.devolverObjetoEnCasillero(posicionDestino) instanceof Pared)) {
			if(tablero.devolverObjetoEnCasillero(posicionDestino) != null) {
				tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
				// Una vez ejecutado el comportamiento se puede remover el objeto de esa posici�n
				tablero.eliminarObjetoEnCasillero(posicionDestino);			
			}
			Pac.getPac().moverAPac(posicionDestino);
			return true;
		} else
			//Antes boolean, pero se corta el while asi...
			return true;
	}
	
	public static boolean moverAPacHaciaArriba() {
		int posicionDestino = Pac.getPac().obtenerPosicionDePac() - Tablero.getTableroSingleton().getNumeroDeColumnas();
		Tablero tablero = Tablero.getTableroSingleton();
//		if (tablero.devolverObjetoEnCasillero(posicionDestino).sePuedeAvanzar()) {
		if(!(tablero.devolverObjetoEnCasillero(posicionDestino) instanceof Pared)) {
			if(tablero.devolverObjetoEnCasillero(posicionDestino) != null) {
				tablero.devolverObjetoEnCasillero(posicionDestino).ejecutarComportamiento(Pac.getPac());
				// Una vez ejecutado el comportamiento se puede remover el objeto de esa posici�n
				tablero.eliminarObjetoEnCasillero(posicionDestino);		
			}
			Pac.getPac().moverAPac(posicionDestino);
			return true;
		} else
			//Antes boolean, pero se corta el while asi...
			return true;
	}
	
}