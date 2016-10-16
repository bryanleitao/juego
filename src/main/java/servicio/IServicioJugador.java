package servicio;

import modelo.Personaje;
import modelo.Jugador;
import modelo.Tipo;

public interface IServicioJugador {

		public void setNickname(Jugador j,String nombre);
		public void agregarPersonaje(Jugador j, Personaje p);
		public void modificarPuntaje(Jugador j);
		public void mostrarJugador(Jugador j);
		
}
