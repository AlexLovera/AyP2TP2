public class MovimientoDePac {
	private static VerificadorDePosicion verificador = new VerificadorDePosicion();
	private static boolean existenciaDeErrorEnComando;
	
	public static void moverAPac(String entrada) {
		switch (entrada) {
		case "D":
			moverAPacHaciaLaDerecha();
			break;
		case "A":
			 moverAPacHaciaLaIzquierda();
			break;
		case "W":
			 moverAPacHaciaArriba();
			break;
		case "S":
			 moverAPacHaciaAbajo();
			break;
		default: 
			existenciaDeErrorEnComando=true;
			break;
		} 
		
	}
	
	private static boolean getExistenciaDeErrorEnComando() {
		return existenciaDeErrorEnComando;
	}
	public static void errorDeComandoNulo(){
		existenciaDeErrorEnComando=false;
	}
	public static void verificarSiHuboErrorDeComando() {
		if(getExistenciaDeErrorEnComando()) {
			System.err.println("Debe ingresar un comando valido");
		} else ;
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
			if(verificador.sePuedeAvanzarHaciaLaDerecha()) {
				Pac.getPac().moverAPac(posicionDestino);
			}
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
			if(verificador.sePuedeAvanzarHaciaLaIzquierda()) {
				Pac.getPac().moverAPac(posicionDestino);
			}
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
			if(verificador.sePuedeAvanzarHaciaAbajo()) {
				Pac.getPac().moverAPac(posicionDestino);
			}
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
			if(verificador.sePuedeAvanzarHaciaArriba()) {
				Pac.getPac().moverAPac(posicionDestino);
			}
			return true;
		} else
			//Antes boolean, pero se corta el while asi...
			return true;
	}
	
}