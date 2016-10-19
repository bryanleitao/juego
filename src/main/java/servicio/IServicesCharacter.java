package servicio;
import java.util.ArrayList;

import modelo.Character;
import modelo.Type;

public interface IServicesCharacter {
	
	public void toList ();
	
	public void toList (Type value);
	
	public void create (Character personaje);
	
	public Character getCharacter(String nombre);
}
