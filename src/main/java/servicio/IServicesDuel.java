package servicio;

import modelo.Character;
import modelo.Player;

/**
 * Esta interfaz contiene los metodos abstractos que se redefiniran en el ServicioDuel.
 * @author Ezequiel
 */

public interface IServicesDuel {
	
	//muestra las cualidades del pesonaje
	public void showQualitie (Character personaje);
	//muestra el puntaje del jugador
	public void showScore(Player player1, Player player2);
	//Hay que ver como se implementa este metodo
	public int compareQualitie(int qualitieValueA, int qualitieValueB);
	public int compareScore(Player player1, Player player2);

}