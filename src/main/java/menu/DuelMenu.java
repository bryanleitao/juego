package menu;

import java.util.List;

import modelo.Character;
import modelo.Player;
import servicio.ServicesDuel;
import servicio.ServicesPlayer;
import dao.DaoCharacter;

/**
 * 
 * @author Florencia 
 */
public class DuelMenu {

	public void displayCharacter(List<Player> players){

		System.out.println(players.get(1));
		//ver como se hace lo de los turnos
	}

	public void showAndChooseQuality(ServicesDuel sd, List<Player> players){
		
		//personaje p elige cualidad J		
		//sd.showQualitie(players.get(1));
	}
	
	public void finalScore(ServicesDuel sd, List<Player> players){
		
		System.out.println("Los puntajes finales son: ");
		sd.showScore(players.get(1), players.get(2));

	
	}
	//ver quien llega a 2 ptos primero
	//mostrar ganador
}
