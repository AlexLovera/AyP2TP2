package tests;

import org.junit.Assert;
import org.junit.Test;

import app.CajaDeVitaminas;
import app.Mina;
import app.ProvisionYMina;
import app.Pac;


public class MinaYProvisionTests {
	
	@Test
	public void primeroSeAgregaProvisionYLuegoExplotaMina() {
		ProvisionYMina minaYProvision = new ProvisionYMina(new CajaDeVitaminas(), new Mina());
		Pac pac = Pac.getPac();
		pac.setVidas(1);
		pac.setPuntosDeEscudo(0);
		minaYProvision.ejecutarComportamiento(pac);
		Assert.assertEquals(1, pac.getVidas());
		Assert.assertEquals(0, pac.getPuntosDeEscudo());
	}
	
}
