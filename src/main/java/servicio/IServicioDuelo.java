package servicio;

import modelo.Personaje;
import modelo.Jugador;

public interface IServicioDuelo {
	
	public void mostrarCualidad (Personaje personaje);
	
	public void mostrarPuntaje (Jugador player1, Jugador player2);
	//Hay que ver como se implementa este metodo
	public void comparaCualidad (int valorCualidadA, int valorCualidadB);

}
