package tests;

import org.junit.Assert;
import org.junit.Test;

import app.EscudoDeFuerza;
import app.Pac;

public class EscudoDeFuerzaTests {
	
	@Test
	public void siAplicoEscudoDeFuerzaSumaDosPuntosDeEscudo() {
		EscudoDeFuerza escudoDeFuerza = new EscudoDeFuerza();
		Pac pac = Pac.getPac();
		pac.setPuntosDeEscudo(0);
		escudoDeFuerza.ejecutarComportamiento(pac);	
		Assert.assertEquals(2, pac.getPuntosDeEscudo());
	}
	
	@Test
	public void sePuedeEstarEncimaDeUnEscudoDeFuerza() {
		EscudoDeFuerza escudoDeFuerza = new EscudoDeFuerza();
		Assert.assertTrue(escudoDeFuerza.sePuedeAvanzar());
	}


}
