package modelo;

import java.util.ArrayList;

public class Player {
	private String nickname;
	private int puntaje;
	private ArrayList personajeSeleccionado;
	
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
