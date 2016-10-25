package servicio;

import java.util.Map;
import java.util.Map.Entry;

import modelo.Character;
import modelo.Player;

/**
 * Clase que se encarga de definir los metodos que se usaran a la hora del duelo entre dos jugadores. Ya sea la comparacion de las 
 * cualidades de los personajes hasta el seteo de puntaje(score) a los jugadores.
 * @author Ezequiel & Bryan
 */

public class ServicesDuel implements IServicesDuel{

	/**
	 * Metodo encargado de mostrar las cualidades de un personaje.
	 */
	public void showQualitie(Character personaje) {
		
		Map<String, Integer> map = personaje.getQualities();
		
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
	 * 					1 si la cualidad del personaje del jugadorA es mayor que la del jugadorB.
	 * 					2 si la cualidad del personaje del jugadorA es menor que la del jugadorB.
	 */
	public int compareQualitie(int qualitieValueA, int qualitieValueB) {
		
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
	 * Metodo que se encarga de incrementar en 1 al puntaje(score) del jugador.
	 */
	public void incrementScore(Player player) {
		
		int score = player.getScore();
		
		player.setScore(++score);
		
	}

}
