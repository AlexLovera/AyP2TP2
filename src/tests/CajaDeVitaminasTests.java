package tests;

import org.junit.Assert;
import org.junit.Test;
import app.CajaDeVitaminas;
import app.Pac;


public class CajaDeVitaminasTests {
	
	@Test
	public void siAplicoCajaDeVitaminasSumaUnaVida() {
		CajaDeVitaminas cajaDeVitaminas = new CajaDeVitaminas();
		Pac pac = Pac.getPac();
		pac.setVidas(1);
		cajaDeVitaminas.ejecutarComportamiento(pac);	
		Assert.assertEquals(2, pac.getVidas());
	}
	
	@Test
	public void sePuedeEstarEncimaDeUnaCajaDeVitaminas() {
		CajaDeVitaminas cajaDeVitaminas = new CajaDeVitaminas();
		Assert.assertTrue(cajaDeVitaminas.sePuedeAvanzar());
	}

}
