package modelo;

import java.util.ArrayList;

/**
 * Esta clase define los atributos que posee el jugador con sus get y set para que sean utilizados por el ServicesPlayer para poder
 * modificar los mismos.
 * @author Ezequiel
 */

public class Player {
	private String nickname;
	private int score;
	private Type typePlayer;
	private ArrayList<Character> characters;
	
	public Player(){
		this.nickname = "";
		this.score = 0;
		this.typePlayer = null;
		this.characters = new ArrayList<Character>();
	}
	
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public Type getTypePlayer() {
		return typePlayer;
	}

	public void setTypePlayer(Type typePlayer) {
		this.typePlayer = typePlayer;
	}

}
