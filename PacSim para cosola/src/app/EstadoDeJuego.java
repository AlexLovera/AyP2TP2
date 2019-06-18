import java.io.IOException;
import java.util.Scanner;
public class EstadoDeJuego {
	
	public boolean verificarYActualizarEstadoDeJuego(boolean termino, Scanner scanner) throws ItemsSobreEntradaNoPermitida, IOException, ItemsSobreSalidaNoPermitida {
		AdministradorDeConsola consola=new AdministradorDeConsola();
		Tablero tablero=Tablero.getTableroSingleton();
		if(!termino) {
			consola.limpiarConsola();
			MovimientoDePac.verificarSiHuboErrorDeComando();
			tablero.pintarTablero();
			return false;
		} else if(Pac.getPac().getVidas()==0) {
			System.err.println("Perdiste");
			consola.continuarOCerrar(scanner);
			return termino=(Pac.getPac().obtenerPosicionDePac()==tablero.getSalida()||Pac.getPac().getVidas()==0) ? true : false;
		} else if(Pac.getPac().obtenerPosicionDePac()==tablero.getSalida()) {
			System.out.println("Felicidades, ganaste!!");
			consola.continuarOCerrar(scanner);
			return termino=(Pac.getPac().obtenerPosicionDePac()==tablero.getSalida()||Pac.getPac().getVidas()==0) ? true : false;
		}
		return false;
	}
}
