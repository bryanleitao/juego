package servicio;

import java.util.ArrayList;

import dao.DaoPersonaje;
import modelo.Personaje;
import modelo.Tipo;

public class ServicioMostrarPersonaje implements IServicioMostrarPersonaje{
	
	private ArrayList<Personaje> personajes;
	
	private DaoPersonaje DP = new DaoPersonaje();
	
	public ServicioMostrarPersonaje(){
		personajes = Listar();
	}

	public ArrayList<Personaje> Listar() {
		return DP.TraerPersaonjes();
	}

	public void Listar(Tipo value) {
		// TODO Auto-generated method stub
		
	}

	public void Crear(Personaje personaje) {
		
		DP.AgregarPersonaje(personaje);
	}

}
