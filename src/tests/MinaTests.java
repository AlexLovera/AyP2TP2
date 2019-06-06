package tests;

import org.junit.Assert;
import org.junit.Test;

import app.Mina;
import app.Pac;

public class MinaTests {
	
	@Test
	public void siExplotaMinaSobrePacYNoTieneEscudoRestaUnaVida() {
		Mina mina = new Mina();
		Pac pac = Pac.getPac();
		pac.setVidas(2);
		pac.setPuntosDeEscudo(0);
		mina.ejecutarComportamiento(pac);	
		Assert.assertEquals(1, pac.getVidas());
		Assert.assertEquals(0, pac.getPuntosDeEscudo());
	}
	
	@Test
	public void siExplotaMinaSobrePacYTieneEscudoRestaUnPuntoDeEscudo() {
		Mina mina = new Mina();
		Pac pac = Pac.getPac();
		pac.setVidas(2);
		pac.setPuntosDeEscudo(1);
		mina.ejecutarComportamiento(pac);	
		Assert.assertEquals(2, pac.getVidas());
		Assert.assertEquals(0, pac.getPuntosDeEscudo());
	}
	
	@Test
	public void sePuedeEstarEncimaDeUnaMina() {
		Mina mina = new Mina();
		Assert.assertTrue(mina.sePuedeAvanzar());
	}

}
