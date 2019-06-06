package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		//GestorDeArchivos configuracion = new GestorDeArchivos();
		Tablero tablero = Tablero.getTableroSingleton();
		
		// para probar
		tablero.setDimensionesDeTablero(8, 8);
		Pared pared = new Pared();
		Pac pac = Pac.getPac();
		try {
			pac.setPosicionDeEntrada(1);
			tablero.setSalida(52);
			tablero.agregarObjetoAlCasillero(0, pared);
			tablero.agregarObjetoAlCasillero(12, pared);
			tablero.agregarObjetoAlCasillero(3, pared);
			tablero.agregarObjetoAlCasillero(63, pared);
			tablero.agregarObjetoAlCasillero(10, new Mina());
			tablero.pintarTablero();
		} catch (ItemsSobreSalidaNoPermitida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemsSobreEntradaNoPermitida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
