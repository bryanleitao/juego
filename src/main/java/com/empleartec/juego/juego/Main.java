package com.empleartec.juego.juego;

import servicio.ServicioMostrarPersonaje;

public class Main {
	
	
	public static void main(String[] args) {
		
		ServicioMostrarPersonaje SMP = new ServicioMostrarPersonaje(); 
		
		//descomentar para probar y mostrar todos los personajes
		SMP.Listar();
		
	}

}
