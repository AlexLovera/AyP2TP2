package app;

public interface Provisiones extends ObjetosEscondidos {

	public void aplicarProvision(Pac pac);

	public default void ejecutarComportamiento(Pac pac) {
		aplicarProvision(pac);
	}
	
}