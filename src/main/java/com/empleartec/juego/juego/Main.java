package com.empleartec.juego.juego;

import servicio.ServicioMostrarPersonaje;
import modelo.Tipo;

public class Main {
	
	
	public static void main(String[] args) {
		
		ServicioMostrarPersonaje SMP = new ServicioMostrarPersonaje(); 
		
		
		//seleccione tipo de personaje
		Tipo [] tipos = Tipo.values();
		
		for(Tipo t : tipos){
			System.out.println(t);
		}
		
		SMP.Listar();
		
		//descomentar para probar y mostrar todos los personajes
//		SMP.Listar();
//		
//		SMP.MostrarPersonaje(SMP.TraerPersonaje("Batman"));
		
	}

}
