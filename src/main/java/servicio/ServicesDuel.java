package servicio;

import java.util.Map;
import java.util.Map.Entry;

import modelo.Character;
import modelo.Player;

public class ServicesDuel implements IServicesDuel{

	public void showQualitie(Character personaje) {
		
		Map<String, Integer> map = personaje.getQualities();
		
		for (Entry<String, Integer> entry : map.entrySet())
		{
		    System.out.println("Cualidad: " + entry.getKey() + " - Valor: " + entry.getValue());
		}
		
	}

	public void showScore(Player player1, Player player2) {
		System.out.println("Puntaje Jugador 1: "+ player1.getScore() + "  //  Puntaje Jugador 2: "+ player2.getScore());
	}

	public int compareQualitie(int qualitieValueA, int qualitieValueB) {
		
		// Si devuelve 0 es empate, 1 gano player A, 2 gano player B
		
		if (qualitieValueA==qualitieValueB){
			return 0;
		}
		
		if (qualitieValueA>qualitieValueB){
			return 1;
		}
		
		if (qualitieValueA<qualitieValueB){
			return 2;
		}
		
		return -1;
		
	}

	public void incrementScore(Player player) {
		int newScore=0;
		
		newScore=player.getScore()+1;
		
		player.setScore(newScore);
		
	}

}
