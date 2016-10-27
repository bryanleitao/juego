package com.empleartec.juego.juego;

import servicio.ServicesCharacter;
import servicio.ServicesDuel;
import servicio.ServicesPlayer;

import java.util.List;

import menu.DuelMenu;
import menu.Menu;

import modelo.Player;

public class Main {


	public static void main(String[] args) {

		ServicesCharacter SC = new ServicesCharacter();
		ServicesPlayer SP = new ServicesPlayer();
		ServicesDuel SD = new ServicesDuel();

		Menu m = new Menu();
		DuelMenu dm = new DuelMenu();

		Player p = new Player();
		SP.addPlayer(p);
		p = new Player();
		SP.addPlayer(p);

		//configuracion de los Jugadores y sus personajes
		for(int i = 0 ; i<2 ; i++  ){

			List<Player> players = SP.getPlayers();
			p = players.get(i);

			m.menuPlayer(p,SC, SP);
		}

		//Duelo
		Player p1 = SP.getPlayers().get(0);
		Player p2 = SP.getPlayers().get(1);
		int turno = 0;
		int result = -1;
		boolean next = true;

		while(next){

			if((p1.getScore()!= 2) && (p2.getScore()!= 2)){// no funciona esta validacion
				if(turno == 0){
					dm.displayCharacter(p1, SD, turno);
				}else{
					if(result == 1){
						dm.displayCharacter(p2, SD, turno);
					}else{
						dm.displayCharacter(p1, SD, turno);
					}
				}
				do{
					if(result == 0){
						System.out.println("\nElija otra cualidad!");
					}
					result = dm.chooseQuality(SD, SC, p1.getCharacters().get(turno), p2.getCharacters().get(turno));
				}while(result == 0);

				switch(result){
				case 1 : SP.modifyScore(p1); break;
				case 2 : SP.modifyScore(p2); break;
				}

				SD.showScore(p1, p2);
				turno++;	
			}else{
				next = false;
			}

		}

		int ganador = SD.compareScore(SP.getPlayers().get(0), SP.getPlayers().get(1));

		if (ganador == 1){
			System.out.println("\nel ganador es: " + SP.getPlayers().get(0).getNickname());	
		}else{
			System.out.println("\nel ganador es: " + SP.getPlayers().get(1).getNickname());
		}


	}
}
