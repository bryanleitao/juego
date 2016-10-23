package servicio;

import modelo.Character;
import modelo.Player;

public interface IServicesDuel {
	
	//muestra las cualidades del pesonaje
	public void showQualitie (Character personaje);
	//
	public void incrementScore (Player player);
	//muestra el puntaje del jugador
	public void showScore(Player player1, Player player2);
	//Hay que ver como se implementa este metodo
	public int compareQualitie(int qualitieValueA, int qualitieValueB);

}
