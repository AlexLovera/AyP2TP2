package app;

public interface ObjetosEscondidos {

	public void ejecutarComportamiento(Pac pac);

	public default boolean sePuedeAvanzar() {
		return true;
	}
}