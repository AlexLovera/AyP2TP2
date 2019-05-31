package app;

public class Mina implements ObjetosEscondidos {

	private static final int PUNTO_A_RESTAR = 1;

	private void explotarBomba(Pac pac) {

		if (pac.getPuntosDeEscudo() > 0) {
			sacarPuntoDeEscudo(pac);
		} else {
			sacarPuntoDeVida(pac);
		}
	}

	private void sacarPuntoDeEscudo(Pac pac) {
		int puntosDeEscudo = pac.getPuntosDeEscudo();
		pac.setPuntosDeEscudo(puntosDeEscudo - PUNTO_A_RESTAR);
	}

	private void sacarPuntoDeVida(Pac pac) {
		int vidasActuales = pac.getVidas();
		if (vidasActuales > 1) {
			pac.setVidas(vidasActuales - PUNTO_A_RESTAR);
		} else if (vidasActuales == 1) {
			// throw new ExceptionEspecial();
		}
	}

	@Override
	public void ejecutarComportamiento(Pac pac) {
		explotarBomba(pac);
	}

}