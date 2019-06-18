import java.io.IOException;
import java.util.Scanner;
public class AdministradorDeConsola {
	
	public static void limpiarConsola() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void continuarOCerrar(Scanner scanner) throws ItemsSobreEntradaNoPermitida, IOException, ItemsSobreSalidaNoPermitida {
		System.out.println("\n\tPara volver a jugar presione: C\n\tPara cerrar presione: X");
		String opcionElegida=scanner.nextLine();
		switch(opcionElegida) {
			case "X": cerrarConsola();
				break;
			case "C": GestorDeArchivos configuracion= new GestorDeArchivos();
			Tablero tablero= configuracion.getTablero();
			tablero.pintarTablero();
			Pac.getPac().setVidasYEscudoIniciales();
				break;
				
		}
	}
	
	public static void cerrarConsola() {
		try {
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
        } catch (Exception e) {
            e.printStackTrace();  
        }
	}
}
