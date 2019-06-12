package app;

public class CajaDeVitaminas implements Provisiones {
	private static final int VIDA_PROVISTA = 1;

	private void sumarVidaAPac(Pac pac) {
		int vidasActuales = pac.getVidas();
		pac.setVidas(vidasActuales + VIDA_PROVISTA);
	}

	@Override
	public void aplicarProvision(Pac pac) {
		sumarVidaAPac(pac);
	}
	
	@Override
	public boolean sePuedeAvanzar() {
		return true;
	}
	
	@Override
	public String toString() {
		return " ";
	}

}