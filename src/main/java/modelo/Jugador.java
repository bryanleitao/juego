package modelo;

import java.util.ArrayList;

public class Jugador {
	private String nickname;
	private int puntaje;
	private ArrayList<Personaje> personajes;
	
	public Jugador(){
		this.nickname = "";
		this.puntaje = 0;
		this.personajes = new ArrayList<Personaje>();
	}
	
	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
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
