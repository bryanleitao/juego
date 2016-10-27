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
	/**
	 * Metodo que se encarga de preguntar al usuario el nickname.
	 * @param p 
	 * @param sc
	 * @param sp
	 */
	public void menuPlayer(Player p,ServicesCharacter sc, ServicesPlayer sp) {
		this.sc =new Scanner(System.in);		
		System.out.print("\nIntroduzca nickname del Jugador: ");       
		p.setNickname(this.sc.nextLine());
		this.menuType(p,sc,sp);
	}
	/**
	 * Metodo que permite la eleccion del tipo de personajes (SUPERHEROE o VILLANO).
	 * @param p
	 * @param sc
	 * @param sp
	 */
	public void menuType(Player p,ServicesCharacter sc, ServicesPlayer sp) {
		this.sc = new Scanner(System.in);
		String option = "";
		
		do{
			System.out.println("\nElija con que tipo de personajes jugara: (a)-SUPERHEROE o (b)-VILLANO: ");
			option = this.sc.nextLine();
			switch (option){
			case "a": p.setTypePlayer(Type.SUPERHEROE) ; break;
			case "b": p.setTypePlayer(Type.VILLANO); break;
			default: System.out.println("Opcion no reconocida"); option = "error"; break;
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
		this.sc = new Scanner(System.in);
		int option = -1;
		Character character = null;
		do{
			try {
				System.out.println("\nSeleccione el numero del personaje con el que desea jugar:");
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
