package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import modelo.Character;
import modelo.Player;
import modelo.Type;
import servicio.ServicesCharacter;

public class ServicesPlayer implements IServicesPlayer {

	
	public void setNickname(Player j,String nombre) {
			j.setNickname(nombre);
	}
	
	public void addCharacter(Player p, Character c) {
		List listCharacters = p.getCharacters();
		listCharacters.add(c);
	}

	public void modifyScore(Player p) {
		p.setScore(p.getScore()+1);
	}
	
	public void showPlayer(Player p){
		System.out.println(p.getNickname());//muestra nombre del jugador
		System.out.println(p.getScore());//muestra el puntaje
		for(Character c : p.getCharacters()){
			System.out.println(c.getName());//muestra el nombre del personaje
			
			Iterator<Entry<String, Integer>> it = c.getQualities().entrySet().iterator();
			Entry<String, Integer> qualities;
			while (it.hasNext()) {
				qualities = it.next();
				System.out.println("\t " + qualities.getKey() + " - : " + qualities.getValue());
			}
		}
		
	}
}
