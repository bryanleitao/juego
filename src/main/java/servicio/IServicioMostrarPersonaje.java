package servicio;
import java.util.ArrayList;

import modelo.Personaje;
import modelo.Tipo;

public interface IServicioMostrarPersonaje {
	
	public void Listar ();
	
	public void Listar (Tipo value);
	
	public void Crear (Personaje personaje);
	
	public Personaje TraerPersonaje(String nombre);
}
