import java.util.ArrayList;
public class ComboDeProvisiones implements Provisiones {

	private ArrayList<Provisiones> combos;
	
	ComboDeProvisiones() {
		this.combos = new ArrayList<Provisiones>();
	}

	public ComboDeProvisiones(Provisiones provision) {
		this.combos = new ArrayList<Provisiones>();
		combos.add(provision);
	}
	
	public void agregarProvisiones(Provisiones provision) {
		combos.add(provision);
	}

	@Override
	public void aplicarProvision(Pac pac) {
		if(!combos.isEmpty()) {
			System.out.println(combos.get(0));
			//problema previo
//			combos.get(0).aplicarProvision(pac);
			for (Provisiones provisiones : combos) {
				provisiones.aplicarProvision(pac);
			}	
		} else if(combos.isEmpty()){
			
		}
	}
	
	@Override
	public boolean sePuedeAvanzar() {
		return true;
	}
	
	public String toString() {
		return " ";
	}

}