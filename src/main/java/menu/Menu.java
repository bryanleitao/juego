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
	 * @param p 
	 * @param sc
	 * @param sp
	 */
	public void menuPlayer(Player p,ServicesCharacter sc, ServicesPlayer sp) {
		resetScanner();
		System.out.print("\nEscribe tu nombre: "); 
		String name = this.sc.nextLine();
		p.setNickname(name);
		this.menuType(p,sc,sp);
	}
	/**
	 * Metodo que permite la eleccion del tipo de personajes (SUPERHEROE o VILLANO).
	 * @param p
	 * @param sc
	 * @param sp
	 */
	public void menuType(Player p,ServicesCharacter sc, ServicesPlayer sp) {
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
		
		List<Character> listCharacterByType = sc.getCharactersByType(p.getTypePlayer());
		this.menuCharacters(p,listCharacterByType,sp);
	}
	/**
	 * Metodo que lista personajes por tipo y le permite al jugador la eleccion del personaje con el que desea jugar.
	 * @param p 
	 * @param characters 
	 * @param player 
	 * @return Devuelve el personaje elegido por el jugador.
	 */
	public int menuCharacter(Player p, ServicesCharacter characters, ServicesPlayer player) {
		int option = -1;
		resetScanner();
		Character character = null;
		do{
			try {
				System.out.println("\nSelecciona el numero del personaje con el que deseas jugar:");
				characters.toList(p.getTypePlayer(),characters.getCharacters());

				option = this.sc.nextInt();

				character = characters.getCharacters().get(option-1);
				if (character != null) {	
					player.addCharacter(p, character);
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
	 * @param p
	 * @param listaCharacter 
	 * @param player
	 */
	public void menuCharacters(Player p, List<Character> listaCharacter, ServicesPlayer player){

		ServicesCharacter characters = new ServicesCharacter();
		characters.setCharacters(listaCharacter);

		for(int i = 0; i<3; i++){
			listaCharacter.remove(this.menuCharacter(p,characters, player)-1);
			characters.setCharacters(listaCharacter);
		}
	}
}
