package menu;

import java.util.ArrayList;
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

	public void menuCharacter(Player p, ServicesCharacter characters, ServicesPlayer player) {

		this.sc = new Scanner(System.in);
		System.out.println("Seleccione el numero del personaje con el que desea jugar:");
		characters.toList(p.getTypePlayer());
		
		int option = this.sc.nextInt();
		
		Character character = characters.getCharacterByIndex(option - 1, p.getTypePlayer());
		
		if (character != null) {	
			player.addCharacter(p, character);
		} else {
			this.menuCharacter(p, characters, player);
		}
	}

	//el main deberia llamar a menuCharacters para la seleccion de personajes
	public void menuCharacters(Player p, ServicesCharacter characters, ServicesPlayer player){
		for(int i = 0; i<3; i++){
			this.menuCharacter(p, characters, player);
		}
	}
}
