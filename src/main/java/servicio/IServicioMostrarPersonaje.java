package servicio;
import java.util.ArrayList;

import modelo.Personaje;
import modelo.Tipo;

public interface IServicioMostrarPersonaje {
	
	
	
	public ArrayList<Personaje> Listar ();
	
	public void Listar (Tipo value);
	
	public void Crear (Personaje personaje);
}
