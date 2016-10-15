package servicio;

import modelo.Personaje;
import modelo.Player;

public interface IServicioDuelo {
	
	public void MostrarCualidad (Personaje personaje);
	
	public void MostrarPuntaje (Player player1, Player player2);
	//Hay que ver como se implementa este metodo
	public void ComparaCualidad (Personaje personajeA, Personaje personajeB);

}
