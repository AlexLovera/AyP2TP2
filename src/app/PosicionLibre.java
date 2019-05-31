package app;

public class PosicionLibre implements ObjetosEscondidos {

	private int posicion;

	@Override
	public boolean sePuedeAvanzar() {
		return true;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public void ejecutarComportamiento(Pac pac) {

	}
}