package menu;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Scanner;

import modelo.Character;
import modelo.Player;
import servicio.ServicesCharacter;
import servicio.ServicesDuel;

/**
 * Esta clase es la que se encarga del desarrollo del juego. Pide al jugador la seleccion de cualidades al luchar y se encarga de los
 * turnos de los mismos.
 * @author Florencia & Bryan
 */
public class DuelMenu {

	Scanner sc;
	public DuelMenu(){
		this.sc = new Scanner(System.in);
	}
	public void gameRules(){
		System.out.println("The League of Cards");
		System.out.println("\nReglas del juego: A cada jugador se le permitira la eleccion de un bando(Superheroe o Villano) y de tres " +
				"personajes\nque seran con los que se enfrentaran." +
				"\nLa batalla consiste en que el jugador de turno elija una habilidad del personaje con el cual va a luchar,\n" +
				"dichas habilidades pueden ser Fuerza, Velocidad e Inteligencia, las cuales se compararan con las del\n" +
				"personaje del otro jugador para determinar el ganador de la ronda." +
				"\nEl mejor de 3 rondas gana. Cada battalla da 1pto en caso de victoria y en caso de empate se debera elegir otra\n" +
				"habilidad para compararla nuevamente. Ingrese [help] para saber los comandos validos" +
				"\n\n----Toca enter para continuar.----");
		String option = this.sc.nextLine();
		
	}
	/**
	 * Metodo que se encarga de mostrar el personaje que ataca.
	 *@param p Jugador que esta de turno.
	 * @param sd servicio de duelo, se usa para traer la cualidad del personaje del turno i.
	 * @param i Turno de juego: puede ser 1, 2 o 3.
	 */
	public void displayCharacterA(Player p, ServicesDuel sd, int i){
		System.out.println(p.getNickname() + " ataca con " + p.getCharacters().get(i).getName()+ ":");
		sd.showQuality(p.getCharacters().get(i));

	}
	/**
	 * Metodo que se encarga de mostrar el personaje que defiende.
	 *@param p Jugador que esta de turno.
	 * @param sd servicio de duelo, se usa para traer la cualidad del personaje del turno i.
	 * @param i Turno de juego: puede ser 1, 2 o 3.
	 */
	public void displayCharacterB(Player p, ServicesDuel sd, int i){
		System.out.println(p.getNickname() + " defiende con " + p.getCharacters().get(i).getName() + " con la misma habilidad");
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

		String option = "";
		int resultado = 0;

		do{
			System.out.println("Elija la cualidad con la que desea atacar:");
			option = this.sc.nextLine();
			option = option.toLowerCase();
			
			switch (option){
			case "fuerza": resultado = sd.compareQuality(sc.getQualityValue(A, "Fuerza"), sc.getQualityValue(B, "Fuerza")); break;
			case "velocidad": resultado = sd.compareQuality(sc.getQualityValue(A, "Velocidad"), sc.getQualityValue(B, "Velocidad")); break;
			case "inteligencia": resultado = sd.compareQuality(sc.getQualityValue(A, "Inteligencia"), sc.getQualityValue(B, "Inteligencia")); break;
			case "help": System.out.println("FUERZA - VELOCIDAD - INTELIGENCIA"); option = "error"; break;
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
	public void finalScore(ServicesDuel SD, List<Player> players){

		System.out.println("\nLos puntajes finales son: ");
		SD.showScore(players.get(0), players.get(1));

		int ganador = SD.compareScore(players.get(0),players.get(1));
		if (ganador == 1){
			System.out.println("\nel ganador es: " + players.get(0).getNickname());	
		}else{
			System.out.println("\nel ganador es: " + players.get(1).getNickname());
		}
	}
}
