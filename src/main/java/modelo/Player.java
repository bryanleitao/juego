package modelo;

import java.util.ArrayList;

public class Player {
	private String nickname;
	private int score;
	private Type typePlayer;
	private ArrayList<Character> characters;
	
	public Player(){
		this.nickname = "";
		this.score = 0;
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
