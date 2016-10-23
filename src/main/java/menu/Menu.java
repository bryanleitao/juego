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
	
 	public void menuPlayer(Player p) {
		Scanner sc =new Scanner(System.in);		
		System.out.print("Introduzca nickname del Player");       
		p.setNickname(sc.nextLine());
	}
	
	public void menuType(Player p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija con que tipo de personajes jugara: (a)-SUPERHEROE o (b)-VILLANO");
		String option = sc.nextLine();
		switch (option){
			case "a": p.setTypePlayer(Type.SUPERHEROE) ; break;
			case "b": p.setTypePlayer(Type.VILLANO); break;
			default: this.menuType(p); break;
		}
	}
	
	public void menuCharacter(Player p, ServicesCharacter characters, ServicesPlayer player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione el personaje con el que desea jugar (Presione las teclas 1, 2, 3, 4, 5 o 6 para seleccionarlo)");
		characters.toList(p.getTypePlayer());
		int option = sc.nextInt();
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
