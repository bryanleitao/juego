package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import modelo.Character;
import modelo.Player;

/**
 * Clase encargada de definir las responsabilidades del Servicio de usuario (ServicesPlayer) que sera la encargada de modificar los 
 * atributos de la clase Player.
 * @author Bryan
 */

public class ServicesPlayer implements IServicesPlayer {

	List<Player> players = new ArrayList<>();
	/**
	 * Metodo que agrega jugadores a una lista.
	 * @param p Jugador que se agregara a la lista.
	 */
	public void addPlayer(Player p){
		players.add(p);
	}
	/**
	 * Metodo que devuelve una lista con los jugadores.
	 * @return Devuelve los jugadores.
	 */
	public List<Player> getPlayers(){
		return this.players;
	}
	/**
	 * Metodo que setea un nombre (nickname) a un jugador.
	 */
	public void setNickname(Player j,String nombre) {
			j.setNickname(nombre);
	}
	/**
	 * Metodo que se encarga de agregar personajes a una lista que posee el jugador.
	 */
	public void addCharacter(Player p, Character c) {
		List listCharacters = p.getCharacters();
		listCharacters.add(c);
	}
	/**
	 * Metodo encargado de modificar el puntaje (score) que tiene el jugador.
	 */
	public void modifyScore(Player p) {
		p.setScore(p.getScore()+1);
	}
	/**
	 * Metodo encargado de mostrar por pantalla los datos de un jugador : nickname, score y los nombres de los personajes que posee
	 * con sus cualidades y valores de las mismas.
	 */
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
