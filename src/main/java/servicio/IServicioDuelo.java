package servicio;

import modelo.Personaje;
import modelo.Jugador;

public interface IServicioDuelo {
	
	public void MostrarCualidad (Personaje personaje);
	
	public void MostrarPuntaje (Jugador player1, Jugador player2);
	//Hay que ver como se implementa este metodo
	public void ComparaCualidad (Personaje personajeA, Personaje personajeB);

}
