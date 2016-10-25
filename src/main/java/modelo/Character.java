package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Type;


/**
 * Esta clase define los atributos que poseen un personaje: el nombre y de que tipo es (se define en el enum (clase Type))
 * para que el ServicesCharacter pueda modificar los mismos.
 * @author Bryan
 *
 */
public class Character {
	//atributos
	private String name;
	private Type type;
	
	/**
	 * HashMap que tiene las cualidades de los personajes(key) con sus respectivos valores(value).	
	 */
	private Map<String,Integer> qualities = new HashMap<String, Integer>();
	
	public Character(String name,Type type){
		this.name = name;
		this.type = type;
	}
	
	
	//metodos
	/**
	 * Metodo que agrega las cualidades con su respectivo valr.
	 * @param name El nombre de la cualidad.
	 * @param stat El valor de la cualidad.
	 */
	public void addQualities(String name, Integer stat){
		qualities.put(name, stat);
	}
	/**
	 * Metodo que modifica las cualidades.
	 * @param name  El nombre de la cualidad.
	 * @param stat El valor de la cualidad.
	 */
	public void modifyQualities(String name, Integer stat){
		qualities.put(name, stat);
	}
	/**
	 * Metodo que se encarga de eliminar una cualidad.
	 * @param name El nombre de la cualidad.
	 */
	public void deleteQualities(String name) {
		if (qualities.containsKey(name)) {
			qualities.remove(name);
		}
		else {
			System.out.println("No existe la qualities: " + name);
		}
	}

	//propiedades
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String,Integer> getQualities() {
		return qualities;
	}
	public void setQualities(Map<String,Integer> qualities) {
		this.qualities = qualities;
	}
	

}
