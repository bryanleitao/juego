package servicio;

import java.util.Map;
import java.util.Map.Entry;

import modelo.Personaje;
import modelo.Player;

public class ServicioDuelo implements IServicioDuelo{

	public void MostrarCualidad(Personaje personaje) {
		
		Map<String, Integer> map = personaje.getCualidades();
		
		for (Entry<String, Integer> entry : map.entrySet())
		{
		    System.out.println("Cualidad: " + entry.getKey() + " - Valor: " + entry.getValue());
		}
		
	}

	public void MostrarPuntaje(Player player1, Player player2) {
		System.out.println("Puntaje Jugador 1: "+ player1.getPuntaje() + "  //  Puntaje Jugador 2: "+ player2.getPuntaje());
	}

	public void ComparaCualidad(Personaje personajeA, Personaje personajeB) {
		// TODO Auto-generated method stub
		//Hay que ver como se implementa este metodo
	}

}
