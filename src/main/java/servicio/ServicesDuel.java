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

	public void compareQualitie(int qualitieValueA, int qualitieValueB) {
		// TODO Auto-generated method stub
		
	}

}
