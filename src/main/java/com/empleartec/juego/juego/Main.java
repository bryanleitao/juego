package com.empleartec.juego.juego;

import servicio.ServicesCharacter;
import servicio.ServicesPlayer;

import java.util.ArrayList;
import java.util.List;

import menu.Menu;

import modelo.Player;
import modelo.Type;

public class Main {


	public static void main(String[] args) {

		ServicesCharacter SC = new ServicesCharacter();
		ServicesPlayer SP = new ServicesPlayer();

		Menu m = new Menu();

		Player p = new Player();
		SP.addPlayer(p);
		p = new Player();
		SP.addPlayer(p);


		for(int i = 0 ; i<2 ; i++  ){

			List<Player> players = SP.getPlayers();
			p = players.get(i);

			m.menuPlayer(p,SC, SP);

		}


	}

}
