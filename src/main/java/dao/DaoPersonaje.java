package dao;

import java.util.ArrayList;

import modelo.Personaje;
import modelo.Tipo;

public class DaoPersonaje {

	private ArrayList<Personaje> personajes;
	
	public DaoPersonaje(){
		personajes = new ArrayList<Personaje>();
		
		Personaje nuevoPersonaje = new Personaje("Batman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 50);
		nuevoPersonaje.agregarCualidad("Velocidad", 150);
		nuevoPersonaje.agregarCualidad("Inteligencia", 80);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Superman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 500);
		nuevoPersonaje.agregarCualidad("Velocidad", 350);
		nuevoPersonaje.agregarCualidad("Inteligencia", 180);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Guason",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 50);
		nuevoPersonaje.agregarCualidad("Velocidad", 50);
		nuevoPersonaje.agregarCualidad("Inteligencia", 280);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Pinguino",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 20);
		nuevoPersonaje.agregarCualidad("Velocidad", 30);
		nuevoPersonaje.agregarCualidad("Inteligencia", 230);
		
		AgregarPersonaje(nuevoPersonaje);
	}
	
	public void AgregarPersonaje(Personaje personaje) {
		
		this.personajes.add(personaje);
		
	}
	
	public ArrayList<Personaje> TraerPersonajes(){
		
		return personajes;
	}
	
	public Personaje TraerPersonaje(String nombre){
		Personaje p = null;
		
		for( Personaje unPersonaje : personajes){
			if(unPersonaje.getNombre() == nombre){
				return unPersonaje;
			}
		}
		
		return p;	
	}
	
}
