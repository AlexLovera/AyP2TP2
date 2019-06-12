package app;

import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws IOException, InterruptedException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		GestorDeArchivos configuracion= new GestorDeArchivos();
		Tablero tablero= configuracion.getTablero();
		tablero.pintarTablero();
		Scanner scanner= new Scanner(System.in);
		boolean termino;
		do {
			tablero.pintarMarcador();
			System.out.println("\nEscribir: Arriba, Abajo, Derecha, Izquierda para moverse");
			String entrada=scanner.nextLine();
			MovimientoDePac.moverAPac(entrada);
			termino=(Pac.getPac().obtenerPosicionDePac()==tablero.getSalida()||Pac.getPac().getVidas()==0) ? true : false;
			if(!termino) tablero.pintarTablero(); else if(Pac.getPac().getVidas()==0) System.err.println("Perdiste");
		} while(!termino);
		scanner.close();
	}

}
