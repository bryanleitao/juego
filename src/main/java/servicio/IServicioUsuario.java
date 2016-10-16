package servicio;

import modelo.Personaje;
import modelo.Jugador;
import modelo.Tipo;

public interface IServicioUsuario {

		public void setNickname();
		public void elegirPersonaje(Jugador j, Personaje p);
		public void modificarPuntaje();
		
}
