package modelo;

import java.util.List;

public class Jugador {
	private String nickname;
	private int puntaje;
	private List personajeSeleccionado;
	
	public List getPersonajeSeleccionado() {
		return personajeSeleccionado;
	}
	public void setPersonajeSeleccionado(List personajeSeleccionado) {
		this.personajeSeleccionado = personajeSeleccionado;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
