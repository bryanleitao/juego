package servicio;

import modelo.Character;
import modelo.Player;
import modelo.Type;

public interface IServicesPlayer {

		public void setNickname(Player p,String name);
		public void addCharacter(Player p, Character c);
		public void modifyScore(Player p);
		public void showPlayer(Player p);
		
}
