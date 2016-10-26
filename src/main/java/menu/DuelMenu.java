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
	 * @param quality Cualidades del personaje del turno i.
	 * @param i Turno de juego: puede ser 1, 2 o 3.
	 */
	public void displayCharacter(Player p, ServicesDuel quality, ServicesPlayer score, int i){
			
				System.out.println(p.getNickname() + " ataca con " + p.getCharacters().get(i));
				quality.showQuality(p.getCharacters().get(i));	
							
}
	/**
	 * Metodo que le permite al jugador seleccionar la cualidadad con la que desea luchar.
	 * @param quality Cualidad de personaje.
	 * @param A Personaje A del jugador p1.
	 * @param B Personaje B del jugador p2.
	 * @param c1 
	 * @param c2 
	 */
	public void chooseQuality(ServicesDuel quality, ServicesCharacter c1, ServicesCharacter c2, Character A, Character B){
					
		System.out.println("Elija la cualidad con la que desea atacar: (f)-FUERZA, (v)-VELOCIDAD o (i)-INTELIGENCIA");
		String option = this.sc.nextLine();
		switch (option){
			case "f": quality.compareQuality(c1.getQualityValue(A, "Fuerza"), c2.getQualityValue(B, "Fuerza")); break;
			case "v": quality.compareQuality(c1.getQualityValue(A, "Velocidad"), c2.getQualityValue(B, "Velocidad")); break;
			case "i": quality.compareQuality(c1.getQualityValue(A, "Inteligencia"), c2.getQualityValue(B, "Inteligencia")); break;
		}
		
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
