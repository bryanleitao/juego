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

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca nickname del Player");
		p.setNickname(sc.nextLine());

	}

	public void menuType(Player p) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Elija con que tipo de personajes jugara: (a)-SUPERHEROE o (b)-VILLANO");
		String op = sc.nextLine();
		switch (op){
		case "a": p.setTypePlayer(Type.SUPERHEROE) ; break;
		case "b": p.setTypePlayer(Type.VILLANO); break;
		default: this.menuType(p); break;
		}


	}

	public void menuCharacters(Player p) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione los personaje con el que desea jugar");
		String character = sc.nextLine();
		//p.setCharacters(characters);
	}
}