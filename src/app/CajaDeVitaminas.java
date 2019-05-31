package app;

public class CajaDeVitaminas implements Provisiones {
	private static final int VIDA_PROVEIDA = 1;

	private void sumarVidaAPac(Pac pac) {
		int vidasActuales = pac.getVidas();
		pac.setVidas(vidasActuales + VIDA_PROVEIDA);
	}

	@Override
	public void aplicarProvision(Pac pac) {
		sumarVidaAPac(pac);
	}
}