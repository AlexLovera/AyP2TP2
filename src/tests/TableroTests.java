package tests;

import org.junit.Assert;
import org.junit.Test;

import app.Pared;
import app.ItemsSobreSalidaNoPermitida;
import app.Mina;
import app.MovimientoDePac;
import app.Pac;
import app.ItemsSobreEntradaNoPermitida;
import app.Tablero;


public class TableroTests {
	
	@Test(expected = ItemsSobreSalidaNoPermitida.class)
	public void noPuedoTenerItemsEnLaSalida() throws ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		tablero.setSalida(8);
		Pac.getPac().setPosicionDeEntrada(0);
		tablero.agregarObjetoAlCasillero(8, new Pared());
	}
	
	@Test(expected = ItemsSobreEntradaNoPermitida.class)
	public void noPuedoTenerParedEnLaSalida() throws ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac.getPac().setPosicionDeEntrada(8);
		tablero.setSalida(0);
		tablero.agregarObjetoAlCasillero(8, new Pared());
	}
	
	@Test
	public void siCreoMinaEnPosicionUnoExisteEnDichaPosicion() throws ItemsSobreEntradaNoPermitida, ItemsSobreSalidaNoPermitida {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac.getPac().setPosicionDeEntrada(0);
		tablero.setSalida(8);
		Mina mina = new Mina();
		tablero.agregarObjetoAlCasillero(1, mina);
		Assert.assertEquals(mina, tablero.devolverObjetoEnCasillero(1));
	}
	
	@Test
	public void siExplotaMinaSeBorraDeLaPosicion() throws ItemsSobreEntradaNoPermitida, ItemsSobreSalidaNoPermitida {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac.getPac().setPosicionDeEntrada(0);
		tablero.setSalida(8);
		tablero.agregarObjetoAlCasillero(1, new Mina());
		MovimientoDePac.moverAPacHaciaLaDerecha();
		Assert.assertNull(tablero.devolverObjetoEnCasillero(1));
	}

}
