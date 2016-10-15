package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Personaje;
import modelo.Tipo;

public class DaoPersonaje {

	private List<Personaje> personajes;
	
	public DaoPersonaje(){
		personajes = new ArrayList<Personaje>();
		
		Personaje nuevoPersonaje = new Personaje("Batman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 80);
		nuevoPersonaje.agregarCualidad("Velocidad", 150);
		nuevoPersonaje.agregarCualidad("Inteligencia", 180);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Superman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 500);
		nuevoPersonaje.agregarCualidad("Velocidad", 350);
		nuevoPersonaje.agregarCualidad("Inteligencia", 150);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Flash",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 150);
		nuevoPersonaje.agregarCualidad("Velocidad", 500);
		nuevoPersonaje.agregarCualidad("Inteligencia", 80);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Linterna Verde",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 250);
		nuevoPersonaje.agregarCualidad("Velocidad", 150);
		nuevoPersonaje.agregarCualidad("Inteligencia", 180);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Aquaman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 180);
		nuevoPersonaje.agregarCualidad("Velocidad", 150);
		nuevoPersonaje.agregarCualidad("Inteligencia", 180);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Wonder Woman",Tipo.SUPERHEROE);
		nuevoPersonaje.agregarCualidad("Fuerza", 200);
		nuevoPersonaje.agregarCualidad("Velocidad", 100);
		nuevoPersonaje.agregarCualidad("Inteligencia", 180);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Guason",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 70);
		nuevoPersonaje.agregarCualidad("Velocidad", 80);
		nuevoPersonaje.agregarCualidad("Inteligencia", 280);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Lex Luthor",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 50);
		nuevoPersonaje.agregarCualidad("Velocidad", 50);
		nuevoPersonaje.agregarCualidad("Inteligencia", 380);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Hiedra Venenosa",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 100);
		nuevoPersonaje.agregarCualidad("Velocidad", 70);
		nuevoPersonaje.agregarCualidad("Inteligencia", 150);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Pinguino",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 20);
		nuevoPersonaje.agregarCualidad("Velocidad", 30);
		nuevoPersonaje.agregarCualidad("Inteligencia", 230);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Doomsday",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 500);
		nuevoPersonaje.agregarCualidad("Velocidad", 150);
		nuevoPersonaje.agregarCualidad("Inteligencia", 80);
		
		AgregarPersonaje(nuevoPersonaje);
		
		nuevoPersonaje = new Personaje("Siniestro",Tipo.VILLANO);
		nuevoPersonaje.agregarCualidad("Fuerza", 270);
		nuevoPersonaje.agregarCualidad("Velocidad", 160);
		nuevoPersonaje.agregarCualidad("Inteligencia", 200);
		
		AgregarPersonaje(nuevoPersonaje);
	}
	
	public void AgregarPersonaje(Personaje personaje) {
		
		this.personajes.add(personaje);
		
	}
	
	public List<Personaje> TraerPersonajes(){
		
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
