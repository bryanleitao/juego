package servicio;

import modelo.Character;
import modelo.Player;

/**
 * Esta interfaz contiene los metodos abstractos que se redefiniran en el ServicioDuel.
 * @author Ezequiel, Bryan & Florencia
 */

public interface IServicesDuel {
	
	public void showQuality (Character personaje);
	public void showScore(Player player1, Player player2);
	public int compareQuality(int qualitieValueA, int qualitieValueB);
	public int compareScore(Player player1, Player player2);

}