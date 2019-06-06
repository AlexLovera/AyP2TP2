package app;

public class MinaYProvision implements ObjetosEscondidos{
	private Mina mina;
	private Provisiones provisiones;

	public MinaYProvision(Mina mina,Provisiones provisiones) {
		this.mina=mina;
		this.provisiones=provisiones;
	}
	
	//primero se agrega la provision y luego explota la bomba
	@Override
	public void ejecutarComportamiento(Pac pac) {
		provisiones.ejecutarComportamiento(pac);
		mina.ejecutarComportamiento(pac);
	}

	@Override
	public boolean sePuedeAvanzar() {
		return true;
	}
	
	public Mina getMina() {
		return this.mina;
	}
	
	public Provisiones getProvisiones() {
		return this.provisiones;	
	}
	
}
