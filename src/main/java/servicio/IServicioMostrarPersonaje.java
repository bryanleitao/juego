package servicio;
import java.util.ArrayList;

import modelo.Personaje;
import modelo.Tipo;

public interface IServicioMostrarPersonaje {
	
	public void listar ();
	
	public void listar (Tipo value);
	
	public void crear (Personaje personaje);
	
	public Personaje traerPersonaje(String nombre);
}
