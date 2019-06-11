package appV2;

public class ProvisionYMina implements ObjetosEscondidos{
	private Mina mina;
	private Provisiones provisiones;

	public ProvisionYMina(Provisiones provisiones,Mina mina) {
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
