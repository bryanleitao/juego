package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.DaoCharacter;
import modelo.Character;
import modelo.Player;
import modelo.Type;
import servicio.ServicesPlayer;
import servicio.ServicesCharacter;

/**
 * Esta clase es la que se encarga de la etapa inicial del juego, pide el ingreso de los datos del Player.
 * @author Florencia & Bryan
 */

public class Menu {

	Scanner sc;
	private void resetScanner(){
		this.sc = new Scanner(System.in);
	}
	public Menu(){
		this.sc =new Scanner(System.in);
	}
	/**
	 * Metodo que se encarga de preguntar al usuario el nickname.
	 * @param p jugador.
	 * @param sc controladora del personaje.
	 * @param sp controladora del jugador.
	 */
	public void menuPlayer(Player p,ServicesCharacter schar, ServicesPlayer sp) {
		resetScanner();
		System.out.print("\nEscribe tu nombre: "); 
		String name = this.sc.nextLine();
		p.setNickname(name);
		this.menuType(p,schar,sp);
	}
	/**
	 * Metodo que permite la eleccion del tipo de personajes (SUPERHEROE o VILLANO).
	 * @param p jugador.
	 * @param schar controladora del personaje.
	 * @param sp controladora del jugador.
	 */
	public void menuType(Player p,ServicesCharacter schar, ServicesPlayer sp) {
		String option;
		resetScanner();
		do{
			System.out.println("\nElige, seras Villano o Superheroe:");
			option = this.sc.nextLine();
			option = option.toLowerCase();
			switch (option){
			case "superheroe": p.setTypePlayer(Type.SUPERHEROE) ; break;
			case "villano": p.setTypePlayer(Type.VILLANO); break;
			case "help": System.out.println("SUPERHEROE - VILLANO"); option = "error"; break;
			default: System.out.println("Opcion no reconocida, ingresa help para ver las opciones disponibles."); option = "error"; break;
			}
		}while (option == "error");
		
		List<Character> listCharacterByType = schar.getCharactersByType(p.getTypePlayer());
		this.menuCharacters(p,listCharacterByType,sp);
	}
	/**
	 * Metodo que lista personajes por tipo y le permite al jugador la eleccion del personaje con el que desea jugar.
	 * @param p jugador
	 * @param schar controladora del personaje 
	 * @param sp controladora del jugador 
	 * @return Devuelve el personaje elegido por el jugador.
	 */
	public int menuCharacter(Player p, ServicesCharacter schar, ServicesPlayer sp) {
		int option = -1;
		resetScanner();
		Character character = null;
		do{
			try {
				System.out.println("\nSelecciona el numero del personaje con el que deseas jugar:");
				schar.toList(p.getTypePlayer(),schar.getCharacters());

				option = this.sc.nextInt();

				character = schar.getCharacters().get(option-1);
				if (character != null) {	
					sp.addCharacter(p, character);
					return option;
				}

			} catch (IndexOutOfBoundsException e) {
				System.out.println("\nSólo se pueden ingresar números dentro del rango.");			
			}catch (InputMismatchException e) {
				System.out.println("\nSólo se pueden ingresar números.");
				sc.next();			
			}
		}while(character == null);

		return option;
	}
	/**
	 * Metodo encargado de eliminar los personajes ya elegidos y de guardar los 3 personajes finales del jugador.
	 * @param p jugador
	 * @param listCharacter lista de caracteres
	 * @param sp controladora del jugador
	 */
	public void menuCharacters(Player p, List<Character> listaCharacter, ServicesPlayer sp){

		ServicesCharacter characters = new ServicesCharacter();
		characters.setCharacters(listaCharacter);

		for(int i = 0; i<3; i++){
			listaCharacter.remove(this.menuCharacter(p,characters, sp)-1);
			characters.setCharacters(listaCharacter);
		}
	}
}
