package tests;

import org.junit.Test;

import app.Pac;
import app.Tablero;
import app.VerificadorDePosicion;
import org.junit.Assert;

public class VerificadorDePosicionTests {
	
	@Test
	public void siEstoyEnFronteraDerechaNoPuedoMovermeALaDerecha() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(7);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertFalse(verificador.sePuedeAvanzarHaciaLaDerecha());
	}
	
	@Test
	public void siEstoyEnFronteraIzquierdaNoPuedoMovermeALaIzquierda() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(16);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertFalse(verificador.sePuedeAvanzarHaciaLaIzquierda());
	}
	
	@Test
	public void siEstoyEnFronteraSuperiorNoPuedoIrHaciaArriba() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(7);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertFalse(verificador.sePuedeAvanzarHaciaArriba());
	}
	
	@Test
	public void siEstoyEnFronteraInferiorNoPuedoIrHaciaAbajo() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(4, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(24);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertFalse(verificador.sePuedeAvanzarHaciaAbajo());
	}
	
	@Test
	public void siEstoyEnPosicionIntermediaPuedoMovermeALaDerecha() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(3);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertTrue(verificador.sePuedeAvanzarHaciaLaDerecha());
	}
	
	@Test
	public void siEstoyEnPosicionIntermediaPuedoMovermeALaIzquierda() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(3);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertTrue(verificador.sePuedeAvanzarHaciaLaIzquierda());
	}
	
	@Test
	public void siEstoyEnPosicionIntermediaPuedoMovermeHaciaArriba() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(11);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertTrue(verificador.sePuedeAvanzarHaciaArriba());
	}
	
	@Test
	public void siEstoyEnPosicionIntermediaPuedoMovermeHaciaAbajo() {
		Tablero tablero = Tablero.getTableroSingleton();
		tablero.setDimensionesDeTablero(8, 8);
		Pac pac = Pac.getPac();
		pac.moverAPac(28);
		VerificadorDePosicion verificador = new VerificadorDePosicion();
		
		Assert.assertTrue(verificador.sePuedeAvanzarHaciaAbajo());
	}
	

}
