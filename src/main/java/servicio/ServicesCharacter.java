package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map.Entry;

import dao.DaoCharacter;
import modelo.Character;
import modelo.Type;

public class ServicesCharacter implements IServicesCharacter{
	
	private List<Character> characters;
	
	private DaoCharacter DP = new DaoCharacter();
	
	public ServicesCharacter(){
		this.setCharacters(DP.getCharacters());
	}
	
	public void toList() {
		for(Character p: DP.getCharacters()){
			System.out.println(p.getName() + " :" + p.getType());
			
			Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
			Entry<String, Integer> qualities;
			while (it.hasNext()) {
				qualities = it.next();
				System.out.println("\t " + qualities.getKey() + " - : " + qualities.getValue());
			}
		}
	}

	public void toList(Type value) {
		int i = 1;
		for(Character p: DP.getCharacters()){
			if(p.getType() == value){
				System.out.println(i++ + ") " + p.getName() + " :" + p.getType());
				
				Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
				Entry<String, Integer> qualities;
				while (it.hasNext()) {
					qualities = it.next();
					System.out.println("\t " + qualities.getKey() + " - : " + qualities.getValue());
				}
			}
			
		}
	}
// paso por parametro el personaje
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
	
	//traigo el personaje q busco por nombre q le paso por parametro
	public Character getCharacter(String name){
		return DP.getCharacter(name);
	}
	
	//traigo el personaje q busco por index que le paso por parámetro y el tipo (Flor)
	public Character getCharacterByIndex(int index, Type type) {
		return DP.getCharacterByIndex(index, type);
	}
	
	//paso por parametro el objeto personaje y lo muestro: nombre, tipo y cualidades
	public void showCharacter(Character p){
		System.out.println(p.getName() + " :" + p.getType());
		
		Iterator<Entry<String, Integer>> it = p.getQualities().entrySet().iterator();
		Entry<String, Integer> qualities;
		while (it.hasNext()) {
			qualities = it.next();
			System.out.println("\t " + qualities.getKey() + " - : " + qualities.getValue());
		}
	}

	public void create(Character character) {
		
		DP.addCharacter(character);
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	
}

