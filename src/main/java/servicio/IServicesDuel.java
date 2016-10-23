package servicio;

import modelo.Character;
import modelo.Player;

public interface IServicesDuel {
	
	//muestra las cualidades del pesonaje
	public void showQualitie (Character personaje);
<<<<<<< HEAD
	//muestra el puntaje del jugador
=======
	
	public void incrementScore (Player player);
	
>>>>>>> db2dcaec60a1904cd83b671a42b48ea51aec3e74
	public void showScore(Player player1, Player player2);
	//Hay que ver como se implementa este metodo
	public int compareQualitie(int qualitieValueA, int qualitieValueB);

}
