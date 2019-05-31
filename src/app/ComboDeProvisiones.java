package app;

import java.util.ArrayList;

public class ComboDeProvisiones implements Provisiones {

	private ArrayList<Provisiones> combos = new ArrayList<Provisiones>();

	public ComboDeProvisiones(Provisiones provision) {
		combos.add(provision);
	}
	
	public void agregarProvisiones(Provisiones provision) {
		combos.add(provision);
	}

	@Override
	public void aplicarProvision(Pac pac) {
		for (Provisiones provisiones : combos) {
			provisiones.aplicarProvision(pac);
		}
	}

}