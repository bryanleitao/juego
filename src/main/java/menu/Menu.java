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

public class Menu {

	Scanner sc;
	public void menuPlayer(Player p) {
		this.sc =new Scanner(System.in);		
		System.out.print("Introduzca nickname del Player: ");       
		p.setNickname(this.sc.nextLine());
	}

	public void menuType(Player p) {
		this.sc = new Scanner(System.in);
		System.out.println("Elija con que tipo de personajes jugara: (a)-SUPERHEROE o (b)-VILLANO: ");
		String option = this.sc.nextLine();
		switch (option){
		case "a": p.setTypePlayer(Type.SUPERHEROE) ; break;
		case "b": p.setTypePlayer(Type.VILLANO); break;
		default: this.menuType(p); break;
		}
	}

	public int menuCharacter(Player p, ServicesCharacter characters, ServicesPlayer player) {
		this.sc = new Scanner(System.in);
		int option = -1;
		Character character = null;

		do{
			try {
				System.out.println("Seleccione el numero del personaje con el que desea jugar:");
				characters.toList(p.getTypePlayer());

				
				option = this.sc.nextInt();

				character = characters.getCharacterByIndex(option - 1, p.getTypePlayer());

				if (character != null) {	
					player.addCharacter(p, character);
					return option;
				}
				
				
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			} catch (InputMismatchException e) {
			// TODO: handle exception
		}
		}while(character == null);

		return option;
	}

	//el main deberia llamar a menuCharacters para la seleccion de personajes
	public void menuCharacters(Player p, List<Character> listaCharacter, ServicesPlayer player){

		ServicesCharacter characters = new ServicesCharacter();
		characters.setCharacters(listaCharacter);

		for(int i = 0; i<3; i++){
			this.menuCharacter(p,characters, player);
		}
	}
}
