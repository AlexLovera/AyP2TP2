package appV2;

public class Casillero {

	private ObjetosEscondidos contiene;

	public Casillero(ObjetosEscondidos contiene) {
		this.setContiene(contiene);
	}

	public ObjetosEscondidos getContiene() {
		return contiene;
	}

	public void setContiene(ObjetosEscondidos contiene) {
		this.contiene = contiene;
	}

}