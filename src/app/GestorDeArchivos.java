package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GestorDeArchivos {

	private final static String RUTA_CONFIGURACION = "src//Configuracion";
	private int posicionEntrada;
	private int posicionSalida;
	private Tablero tablero;
	private ArrayList<Provisiones> provisiones;

	public Tablero getTablero() throws IOException {
		crearTablero();
		return tablero;
	}

	public void crearTablero() throws IOException {
		FileReader s = new FileReader("src//Configuracion");
		Scanner scanner = new Scanner(s);
		tablero = Tablero.getTableroSingleton();
		leerApartadoTablero(scanner);
//		leerApartadoMinas(scanner);
		// falta implementar
		// leerApartadoUbicacionProvisiones(scanner);
		scanner.close();
	}

	private void leerApartadoProvisiones(Scanner scanner) {

	}

	private void leerApartadoUbicacionProvisiones(Scanner scanner) {

	}

	private void leerApartadoMinas(Scanner scanner) {

	}

	private void crearProvisiones(StringBuilder provisiones) {

	}

	private void introducirMinasAlTablero() {

	}

	private void introducirProvisionesAlTablero() {

	}

	private void leerApartadoTablero(Scanner scanner) {

	}
}