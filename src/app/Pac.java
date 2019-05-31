package app;

import java.util.ArrayList;

public class Pac {
	
	private static Pac pacSingleton;
	private int posicion;
	private int vidas;

	private int puntosDeEscudo;
	
	private Pac() {

	}
	
	public static Pac getPac() {
		if(pacSingleton==null)
			pacSingleton=new Pac();
		return pacSingleton;
	}
	

	
	public int getVidas() {
		return vidas;
	}
	
	
	public void moverAPac(int posicion) {

		this.posicion=posicion;
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

	public void setPuntosDeEscudo(int puntosDeEscudo) {
		this.puntosDeEscudo = puntosDeEscudo;
	}
	
}