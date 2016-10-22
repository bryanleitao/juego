package servicio;

import modelo.Character;
import modelo.Player;

public interface IServicesDuel {
	
	public void showQualitie (Character personaje);
	
	public void showScore(Player player1, Player player2);
	//Hay que ver como se implementa este metodo
	public int compareQualitie(int qualitieValueA, int qualitieValueB);

}
