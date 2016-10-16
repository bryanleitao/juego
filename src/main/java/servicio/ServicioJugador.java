package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import modelo.Personaje;
import modelo.Jugador;
import modelo.Tipo;
import servicio.ServicioPersonaje;

public class ServicioJugador implements IServicioJugador {

	
	public void setNickname(Jugador j,String nombre) {
			j.setNickname(nombre);
	}
	
	public void agregarPersonaje(Jugador j, Personaje p) {
		List listaPersonajes = j.getPersonajes();
		listaPersonajes.add(p);
	}

	public void modificarPuntaje(Jugador j) {
		j.setPuntaje(j.getPuntaje()+1);
	}
	
	public void mostrarJugador(Jugador j){
		System.out.println(j.getNickname());//muestra nombre del jugador
		System.out.println(j.getPuntaje());//muestra el puntaje
		for(Personaje p : j.getPersonajes()){
			System.out.println(p.getNombre());//muestra el nombre del personaje
			
			Iterator<Entry<String, Integer>> it = p.getCualidades().entrySet().iterator();
			Entry<String, Integer> cualidades;
			while (it.hasNext()) {
				cualidades = it.next();
				System.out.println("\t " + cualidades.getKey() + " - : " + cualidades.getValue());
			}
		}
		
	}
}
