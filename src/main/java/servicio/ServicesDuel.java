package servicio;

import java.util.Map;
import java.util.Map.Entry;

import modelo.Character;
import modelo.Player;

/**
 * Clase que se encarga de definir los metodos que se usaran a la hora del duelo entre dos jugadores. Ya sea la comparacion de las 
 * cualidades de los personajes hasta el seteo de puntaje(score) a los jugadores.
 * @author Ezequiel, Bryan & Florencia
 */

public class ServicesDuel implements IServicesDuel{

	/**
	 * Metodo encargado de mostrar las cualidades de un personaje.
	 */
	public void showQuality(Character character) {
		
		Map<String, Integer> map = character.getQualities();
		
		for (Entry<String, Integer> entry : map.entrySet())
		{
		    System.out.println("Cualidad: " + entry.getKey() + " - Valor: " + entry.getValue());
		}
		
	}
	/**
	 * Metodo que se encarga de mostrar el puntaje(score) de los jugadores.
	 */
	public void showScore(Player player1, Player player2) {
		System.out.println("Puntaje Jugador 1: "+ player1.getScore() + "  //  Puntaje Jugador 2: "+ player2.getScore());
	}
	/**
	 * Metodo que se encarga de comparar la misma cualidad del personaje del jugadorA con el jugadorB.
	 * @return Devuelve 0 si es un empate. La cualidad de ambos personajes tienen el mismo valor.
	 * 					1 si la cualidad del personaje del jugador1 es mayor que la del jugador2.
	 * 					2 si la cualidad del personaje del jugador1 es menor que la del jugador2.
	 */
	public int compareQuality(int qualitieValueA, int qualitieValueB) {
		
		int i = -1;
		
		if (qualitieValueA==qualitieValueB){
			i = 0;
		}
		
		if (qualitieValueA>qualitieValueB){
			i =  1;
		}
		
		if (qualitieValueA<qualitieValueB){
			i = 2;
		}
		
		return i;
		
	}
	/**
	 * Metodo que se encarga de comparar el puntaje de los jugadores.
	 * @param player1 Jugador1.
	 * @param player2 Jugador2.
	 * @return Devuelve 1 o 2 dependiendo de que jugador tiene mayor puntaje:
	 * 					1- si el jugador1 tiene mayor puntaje.
	 * 					2- si el jugador2 tiene mayor puntaje.
	 */
	public int compareScore(Player player1, Player player2){
		
		int i= -1;
		
		if(player1.getScore() > player2.getScore()){
			i=1;
		}
		if(player1.getScore() < player2.getScore()){
			i=2;
		}
		
		return i;
	}
	
	public void duel(){
		
	}
	
}
