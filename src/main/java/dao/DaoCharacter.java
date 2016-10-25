package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Character;
import modelo.Type;

/**
 * Esta clase es la que tiene los datos de todos los personajes disponibles para jugar. Cada uno de estos esta cargado en un ArrayList
 * con sus cualidades y los valores de las mismas.
 * Contiene distintos metodos que permiten manipular dichos personajes.
 * @author Bryan & Florencia
 */

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
	/**
	 * Metodo que agrega personajes a la lista characters.
	 * @param character Personaje que puede ser SUPERHEROE o VILLANO y que posee distintas cualidades.
	 */
	public void addCharacter(Character character) {
		
		this.characters.add(character);
		
	}
	/**
	 * Metodo para mostrar la lista de todos los personajes.
	 * @return Devuelve la lista characters.
	 */
	public List<Character> getCharacters(){
		
		return characters;
	}
	/**
	 * Metodo que levanta personajes de la lista por nombre.
	 * @param name Nomre del personaje que se encuentra en la lista characters.
	 * @return Devuelve un personaje por su nombre y en caso de que no se encuentre en la lista de tipo Array devuelve null.
	 */
	public Character getCharacter(String name){
		for( Character aCharacter : characters){
			if(aCharacter.getName() == name){
				return aCharacter;
			}
		}
		return null;
	}
	/**
	 * Metodo que genera una lista de tipo Array con personajes de un mismo tipo, ya sea SUPERHEROE o VILLANO.
	 * @param type Tipo de personaje que es: SUPERHEROE o VILLANO.
	 * @return Devuelve una lista de tipo Array de personajes de un tipo determinado.
	 */
	public List<Character> getCharactersOfType(Type type) {
		List<Character> charactersOfType = new ArrayList<Character>();
		for (Character aCharacter: characters) {
			if (aCharacter.getType() == type) {
				charactersOfType.add(aCharacter);
			}
		}
		return charactersOfType;
	}
	/**
	 * Metodo que levanta un personaje por index y tipo(SUPERHEROE o VILLANO). Se utiliza en la clase Menu.
	 * @param index Lugar que ocupa un personaje en la lista (ArrayList).
	 * @param type Tipo de personaje que es: SUPERHEROE o VILLANO.
	 * @return Devuelve un perdonaje d
	 */
	public Character getCharacterByIndex(int index, Type type) {
		return this.getCharactersOfType(type).get(index);
	}
	
}
