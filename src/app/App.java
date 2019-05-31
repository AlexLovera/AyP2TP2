package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		GestorDeArchivos configuracion = new GestorDeArchivos();
		Tablero tablero = configuracion.getTablero();
	}

}
