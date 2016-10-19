package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Type;

public class Character {
	//atributos
	private String name;
	private Type type;
	
	/*corroborar si esta bien declarado, 
	lo copie de otros codigos, pero ni idea si funciona asi*/	
	private Map<String,Integer> qualities = new HashMap<String, Integer>();
	
	public Character(String name,Type type){
		this.name = name;
		this.type = type;
	}
	
	
	//metodos
	
	public void addQualities(String name, Integer stat){
		qualities.put(name, stat);
	}
	public void modifyQualities(String name, Integer stat){
		qualities.put(name, stat);
	}
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
