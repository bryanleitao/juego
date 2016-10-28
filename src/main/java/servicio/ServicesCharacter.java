package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map.Entry;

import dao.DaoCharacter;
import modelo.Character;
import modelo.Type;

/**
 * Clase que se encarga de las responsabilidades del personaje. 
 * @author Bryan & Florencia
 */

public class ServicesCharacter implements IServicesCharacter{
	
	private List<Character> characters;
	
	private DaoCharacter DP = new DaoCharacter();
	
	public ServicesCharacter(){
		this.setCharacters(DP.getCharacters());
	}
	/**
	 * Metodo que se encarga de listar todos los personajes de DP(DaoCharacter) mostrando el tipo, cualidades y valores de las mismas.
	 */
	public void toList() {
		for(Character p: DP.getCharacters()){
			System.out.println(p.getName() + " - " + p.getType());
			
			Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
			Entry<String, Integer> qualities;
			while (it.hasNext()) {
				qualities = it.next();
				System.out.println("\t " + qualities.getKey() + " - : " + qualities.getValue());
			}
		}
	}
	/**
	 * Metodo que se encarga de listar personajes, filtrados en el menu, por tipo mostrando sus cualidades y sus respectivos valores.
	 */
	public void toList(Type value,List<Character> c) {
		int i = 1;
		for(Character p: c){
			System.out.println(i++ + ") " + p.getName() + " - " + p.getType());
			
			Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
			Entry<String, Integer> qualities;
			while (it.hasNext()) {
				qualities = it.next();
				System.out.println("\t " + qualities.getKey() + " = " + qualities.getValue());
			}
		}
	}
	/**
	 * Metodo que se encarga de listar personajes por tipo mostrando sus cualidades y sus respectivos valores.
	 */
	public void toList(Type value) {
		int i = 1;
		for(Character p: DP.getCharacters()){
			if(p.getType() == value){
				System.out.println(i++ + ") " + p.getName() + " - " + p.getType());
				
				Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
				Entry<String, Integer> qualities;
				while (it.hasNext()) {
					qualities = it.next();
					System.out.println("\t " + qualities.getKey() + " = " + qualities.getValue());
				}
			}
			
		}
	}
	/**
	 * Metodo encargado de traer el valor de una cualidad de un personaje.
	 * @param p Personaje al que se desea obtener el valor de la cualidad.
	 * @param c	Nombre de la cualidad.
	 * @return Devuelve el valor de una cualidad y en caso de que no encuentre dicha cualidad retorna -1.
	 */
	public int getQualityValue (Character p,String c){
		
		Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
		Entry<String, Integer> qualities;
		while (it.hasNext()) {
			qualities = it.next();
			if(qualities.getKey() == c)
				return qualities.getValue();
		}
		
		return -1;
	}
	/**
	 * Metodo que se encarga de traer un personaje por el nombre.
	 */
	public Character getCharacter(String name){
		return DP.getCharacter(name);
	}
	/**
	 * Metodo que se encarga de traer un personaje por index y tipo.
	 * @param index Lugar que ocupa un personaje en la lista (ArrayList).
	 * @param type Tipo de personaje (SUPERHEROE o VILLANO).
	 * @return Devuelve un personaje.
	 */
	public Character getCharacterByIndex(int index, Type type) {
		return DP.getCharacterByIndex(index, type);
	}
	/**
	 * Metodo que toma un objeto personaje y lo muestra: nmbre, tipo y cualidades.
	 * @param p Personaje que se mostrara.
	 */
	public void showCharacter(Character p){
		System.out.println(p.getName() + " - " + p.getType());
		
		Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
		Entry<String, Integer> qualities;
		while (it.hasNext()) {
			qualities = it.next();
			System.out.println("\t" + qualities.getKey() + " = " + qualities.getValue());
		}
	}
	/**
	 * Metodo encargado agregar un personaje al DP (DaoCharacter).
	 */
	public void create(Character character) {
		
		DP.addCharacter(character);
	}
	
	public List<Character> getCharacters() {
		return characters;
	}
	/**
	 * Metodo encargado de guardar en una lista los personajes del mismo tipo.
	 * @param t Tipo de personaje (SUPERHEROE o VILLANO).
	 * @return Devuelve una lista con personajes del mismo tipo.
	 */
	public List<Character> getCharactersByType(Type t) {
		List<Character> ct = new ArrayList();
		
		for(Character c: DP.getCharacters()){
			if(c.getType() == t){
				ct.add(c);
			}
		}
		return ct;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	
}

