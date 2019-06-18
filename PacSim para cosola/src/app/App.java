import java.io.IOException;
import java.util.Scanner;
public class App {
	
	public static void main(String[] args) throws IOException, InterruptedException, ItemsSobreSalidaNoPermitida, ItemsSobreEntradaNoPermitida {
		AdministradorDeConsola consola=new AdministradorDeConsola();
		consola.limpiarConsola();
		GestorDeArchivos configuracion= new GestorDeArchivos();
		Tablero tablero= configuracion.getTablero();
		tablero.pintarTablero();
		Scanner scanner= new Scanner(System.in);
		boolean termino;
		EstadoDeJuego estadoDeJuego=new EstadoDeJuego();
		do {
			MovimientoDePac.errorDeComandoNulo();
			tablero.pintarMarcador();
			System.out.println("\nEscribir: W(Arriba), S(Abajo), D(Derecha), A(Izquierda) para moverse");
			String entrada=scanner.nextLine();
			MovimientoDePac.moverAPac(entrada);
			termino=(Pac.getPac().obtenerPosicionDePac()==tablero.getSalida()||Pac.getPac().getVidas()==0) ? true : false;
			termino=estadoDeJuego.verificarYActualizarEstadoDeJuego(termino, scanner);
		} while(!termino);
		scanner.close();
	}

}
