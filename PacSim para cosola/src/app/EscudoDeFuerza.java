public class EscudoDeFuerza implements Provisiones {

	private int PUNTOS_DE_ESCUDO = 2;

	private void sumarPuntosDeEscudo(Pac pac) {
		int puntosDeEscudoActuales = pac.getPuntosDeEscudo();
		pac.setPuntosDeEscudo(puntosDeEscudoActuales + PUNTOS_DE_ESCUDO);
	}

	@Override
	public void aplicarProvision(Pac pac) {
		sumarPuntosDeEscudo(pac);
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