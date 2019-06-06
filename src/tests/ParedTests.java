package tests;

import org.junit.Assert;
import org.junit.Test;

import app.Pared;

public class ParedTests {
	
	@Test
	public void noSePuedeEstarEncimaDeUnaPared() {
		Pared pared = new Pared();
		Assert.assertFalse(pared.sePuedeAvanzar());
	}

}
