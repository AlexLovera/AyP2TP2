package appV2;

public class Pac {
	
	private static Pac pacSingleton;
	private int posicionDeEntrada;
	private int posicion;
	private int vidas;

	private int puntosDeEscudo;
	
	private Pac() {
		//supongo que empieza con 3 vidas
		vidas=20;
	}
	
	public static Pac getPac() {
		if(pacSingleton==null)
			pacSingleton=new Pac();
		return pacSingleton;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setPosicionDeEntrada(int posicion) throws ItemsSobreEntradaNoPermitida {
		if (Tablero.getTableroSingleton().devolverObjetoEnCasillero(posicion) != null) {
			throw new ItemsSobreEntradaNoPermitida("No se permite poner la entrada donde hay items");
		}
		
		this.posicionDeEntrada = posicion;
		// Lo lógico es que si necesitamos llamar a este método es porque estamos reubicando a Pac
		this.posicion = posicion;
	}
	
	public boolean moverAPac(int posicion) {
		if(posicion==Tablero.getTableroSingleton().getSalida()) {
			System.out.println("Felicidades, ganaste!!");
			this.posicion=posicion;
			return false;
		} else {
			this.posicion=posicion;		
			return true;
		}
	}
	
	public int obtenerPosicionDePac() {
		return posicion;
	}
	
	public void añadirEscudoDeFuerza(EscudoDeFuerza escudo) {
		
	}
	
	public void setVidas(int vidas) {
		this.vidas=vidas;
	}

	public int getPuntosDeEscudo() {
		return puntosDeEscudo;
	}
	
	public int getPosicionDeEntrada() {
		return this.posicionDeEntrada;
	}
	
	public int getPosicion() {
		return this.posicion;
	}

	public void setPuntosDeEscudo(int puntosDeEscudo) {
		this.puntosDeEscudo = puntosDeEscudo;
	}
	
	public String toString() {
		return "P";
	}
	
}