package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Character;
import modelo.Type;

public class DaoCharacter {

	private List<Character> characters;
	
	public DaoCharacter(){
		characters = new ArrayList<Character>();
		
		Character newCharacter = new Character("Batman",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 80);
		newCharacter.addQualities("Velocidad", 150);
		newCharacter.addQualities("Inteligencia", 180);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Superman",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 500);
		newCharacter.addQualities("Velocidad", 350);
		newCharacter.addQualities("Inteligencia", 150);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Flash",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 150);
		newCharacter.addQualities("Velocidad", 500);
		newCharacter.addQualities("Inteligencia", 80);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Linterna Verde",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 250);
		newCharacter.addQualities("Velocidad", 150);
		newCharacter.addQualities("Inteligencia", 180);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Aquaman",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 180);
		newCharacter.addQualities("Velocidad", 150);
		newCharacter.addQualities("Inteligencia", 180);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Wonder Woman",Type.SUPERHEROE);
		newCharacter.addQualities("Fuerza", 200);
		newCharacter.addQualities("Velocidad", 100);
		newCharacter.addQualities("Inteligencia", 180);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Guason",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 70);
		newCharacter.addQualities("Velocidad", 80);
		newCharacter.addQualities("Inteligencia", 280);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Lex Luthor",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 50);
		newCharacter.addQualities("Velocidad", 50);
		newCharacter.addQualities("Inteligencia", 380);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Hiedra Venenosa",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 100);
		newCharacter.addQualities("Velocidad", 70);
		newCharacter.addQualities("Inteligencia", 150);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Pinguino",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 20);
		newCharacter.addQualities("Velocidad", 30);
		newCharacter.addQualities("Inteligencia", 230);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Doomsday",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 500);
		newCharacter.addQualities("Velocidad", 150);
		newCharacter.addQualities("Inteligencia", 80);
		
		addCharacter(newCharacter);
		
		newCharacter = new Character("Siniestro",Type.VILLANO);
		newCharacter.addQualities("Fuerza", 270);
		newCharacter.addQualities("Velocidad", 160);
		newCharacter.addQualities("Inteligencia", 200);
		
		addCharacter(newCharacter);
	}
	
	public void addCharacter(Character character) {
		
		this.characters.add(character);
		
	}
	
	public List<Character> getCharacters(){
		
		return characters;
	}
	
	public Character getCharacter(String name){
		for( Character aCharacter : characters){
			if(aCharacter.getName() == name){
				return aCharacter;
			}
		}
		return null;	
	}
	
}
