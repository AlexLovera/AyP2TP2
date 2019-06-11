package appV2;

public class Pared implements ObjetosEscondidos {
	private int posicion;

	@Override
	public boolean sePuedeAvanzar() {
		return false;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public void ejecutarComportamiento(Pac pac) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return "X";
	}
	
}