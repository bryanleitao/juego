package menu;

import java.util.List;
import java.util.Scanner;

import modelo.Character;
import modelo.Player;
import servicio.ServicesCharacter;
import servicio.ServicesDuel;
import servicio.ServicesPlayer;

/**
 * Esta clase es la que se encarga del desarrollo del juego. Pide al jugador la seleccion de cualidades al luchar y se encarga de los
 * turnos de los mismos.
 * @author Florencia & Bryan
 */
public class DuelMenu {

	Scanner sc;

	/**
	 * Metodo que se encarga de mostrar el personaje para luchar en cada turno.
	 *@param p Jugador que esta de turno.
	 * @param sd servicio de duelo, se usa para traer la cualidad del personaje del turno i.
	 * @param i Turno de juego: puede ser 1, 2 o 3.
	 */
	public void displayCharacter(Player p, ServicesDuel sd, int i){
		this.sc =new Scanner(System.in);
		System.out.println(p.getNickname() + " ataca con " + p.getCharacters().get(i).getName());
		sd.showQuality(p.getCharacters().get(i));

	}
	/**
	 * Metodo que le permite al jugador seleccionar la cualidadad con la que desea luchar.
	 * @param quality Cualidad de personaje.
	 * @param A Personaje A del jugador p1.
	 * @param B Personaje B del jugador p2.
	 * @param c1 
	 * @param c2 
	 */
	public int chooseQuality(ServicesDuel sd, ServicesCharacter sc, Character A, Character B){

		System.out.println("Elija la cualidad con la que desea atacar: (f)-FUERZA, (v)-VELOCIDAD o (i)-INTELIGENCIA");
		String option = "";
		option = this.sc.nextLine();
		int resultado = 0;
		
		do{
			switch (option){
			case "f": resultado = sd.compareQuality(sc.getQualityValue(A, "Fuerza"), sc.getQualityValue(B, "Fuerza")); break;
			case "v": resultado = sd.compareQuality(sc.getQualityValue(A, "Velocidad"), sc.getQualityValue(B, "Velocidad")); break;
			case "i": resultado = sd.compareQuality(sc.getQualityValue(A, "Inteligencia"), sc.getQualityValue(B, "Inteligencia")); break;
			default: System.out.println("Opcion no reconocida"); option = "error"; break;
			}
		}while (option == "error");
		
		return resultado;
	}
	/**
	 * Metodo encargado de mostrar los puntajes finales.
	 * @param sd
	 * @param players
	 */
	public void finalScore(ServicesDuel score, List<Player> players){

		System.out.println("Los puntajes finales son: ");
		score.showScore(players.get(1), players.get(2));


	}
}
