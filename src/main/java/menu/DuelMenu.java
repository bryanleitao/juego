package menu;

import java.util.List;

import modelo.Character;
import modelo.Player;
import servicio.ServicesDuel;
import servicio.ServicesPlayer;
import dao.DaoCharacter;

public class DuelMenu {

	public void displayCharacter(List<Player> players){

		System.out.println(players.get(1));
		//ver como se hace lo de los turnos
	}

	public void showAndChooseQuality(ServicesDuel sd, List<Player> players){

		//sd.showQualitie(players.get(1));
	}

	public void score(){
		//sumarle puntaje al jugador? no lo hace eze?
	}
}
