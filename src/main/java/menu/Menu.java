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
 * Esta clase 
 * @author Florencia & Bryan
 */

public class Menu {

	Scanner sc;
	/**
	 * 
	 * @param p
	 * @param sc
	 * @param sp
	 */
	public void menuPlayer(Player p,ServicesCharacter sc, ServicesPlayer sp) {
		this.sc =new Scanner(System.in);		
		System.out.print("Introduzca nickname del Player: ");       
		p.setNickname(this.sc.nextLine());
		this.menuType(p,sc,sp);
	}
	/**
	 * 
	 * @param p
	 * @param sc
	 * @param sp
	 */
	public void menuType(Player p,ServicesCharacter sc, ServicesPlayer sp) {
		this.sc = new Scanner(System.in);
		System.out.println("Elija con que tipo de personajes jugara: (a)-SUPERHEROE o (b)-VILLANO: ");
		String option = this.sc.nextLine();
		switch (option){
		case "a": p.setTypePlayer(Type.SUPERHEROE) ; break;
		case "b": p.setTypePlayer(Type.VILLANO); break;
		default: this.menuType(p,sc,sp); break;
		}
		List<Character> listCharacterByType = sc.getCharactersByType(p.getTypePlayer());
		this.menuCharacters(p,listCharacterByType,sp);
	}
	/**
	 * 
	 * @param p
	 * @param characters
	 * @param player
	 * @return
	 */
	public int menuCharacter(Player p, ServicesCharacter characters, ServicesPlayer player) {
		this.sc = new Scanner(System.in);
		int option = -1;
		Character character = null;
		do{
			try {
				System.out.println("Seleccione el numero del personaje con el que desea jugar:");
				characters.toList(p.getTypePlayer(),characters.getCharacters());

				option = this.sc.nextInt();

				character = characters.getCharacterByIndex(option - 1, p.getTypePlayer());

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

	//el main llama a menuCharacters para la seleccion de personajes
	/**
	 * 
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
