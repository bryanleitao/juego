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
		System.out.println("\nEn un mundo donde los villanos y superheroes pelean entre si deberas elegir con quien quieres luchar. "
				+ "\nTendras que seleccionar tres cartas, que representan a distintos superheroes o villanos, estas tienen 3 habilidades distintas."
				+ "\nA la hora de combatir deberas elegir una habilidad por cada carta y el que tenga el puntaje mayor en la misma, ganara la batalla, pero no la guerra."
				+ "\nEl vencedor sera el jugador que tenga dos de tres batallas ganadas. Ingrese [help] para saber los comandos permitidos" +
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
		System.out.println(p.getNickname() + " atacara con " + p.getCharacters().get(i).getName()+ ":");
		sd.showQuality(p.getCharacters().get(i));

	}
	/**
	 * Metodo que se encarga de mostrar el personaje que defiende.
	 *@param p Jugador que esta de turno.
	 * @param sd servicio de duelo, se usa para traer la cualidad del personaje del turno i.
	 * @param i Turno de juego: puede ser 1, 2 o 3.
	 */
	public void displayCharacterB(Player p, ServicesDuel sd, int i){
		System.out.println(p.getNickname() + " se defiende con " + p.getCharacters().get(i).getName() + " usando la misma habilidad");
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
			System.out.println("Elige la habilidad con la que deseas atacar:");
			option = this.sc.nextLine();
			option = option.toLowerCase();
			
			switch (option){
			case "fuerza": resultado = sd.compareQuality(sc.getQualityValue(A, "Fuerza"), sc.getQualityValue(B, "Fuerza")); break;
			case "velocidad": resultado = sd.compareQuality(sc.getQualityValue(A, "Velocidad"), sc.getQualityValue(B, "Velocidad")); break;
			case "inteligencia": resultado = sd.compareQuality(sc.getQualityValue(A, "Inteligencia"), sc.getQualityValue(B, "Inteligencia")); break;
			case "help": System.out.println("FUERZA - VELOCIDAD - INTELIGENCIA"); option = "error"; break;
			default: System.out.println("Opcion no reconocida, ingresa help para ver las opciones disponibles."); option = "error"; break;
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
			System.out.println("\nEl ganador es: " + players.get(0).getNickname());	
		}else{
			System.out.println("\nEl ganador es: " + players.get(1).getNickname());
		}
	}
}
