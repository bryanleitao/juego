package com.empleartec.juego.juego;

import servicio.ServicesCharacter;
import servicio.ServicesDuel;
import servicio.ServicesPlayer;

import java.io.Console;
import java.util.List;

import javax.swing.SingleSelectionModel;

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
		dm.gameRules();

		//configuracion de los Jugadores y sus personajes
		System.out.println("\n---------------VAMO A COMENZAR!!!----------------\n");
		for(int i = 0 ; i<2 ; i++  ){

			List<Player> players = SP.getPlayers();
			p = players.get(i);
			if(i == 1){
				System.out.println("Ahora es el turno de tu oponente.");
			}
			m.menuPlayer(p,SC, SP);
		}
		System.out.println("\n---------------A PELEAR!!!----------------\n");
		//Duelo
		Player p1 = SP.getPlayers().get(0);
		Player p2 = SP.getPlayers().get(1);
		int turno = 0;
		int result = -1;
		boolean next = true;

		Player actualPlayer = p1;
		Player otherPlayer = p2;
		SP.changePlayer(actualPlayer, otherPlayer);

		while(next){

			if((p1.getScore()!= 2) && (p2.getScore()!= 2)){

				dm.displayCharacterA(actualPlayer, SD, turno);

				do{
					if(result == 0){
						System.out.println("\nElija otra cualidad!");
					}
					result = dm.chooseQuality(SD, SC, actualPlayer.getCharacters().get(turno), otherPlayer.getCharacters().get(turno));
					dm.displayCharacterB(otherPlayer, SD, turno);
					System.out.println("\n---------------Fight----------------\n");
				}while(result == 0);

				switch(result){
				case 1 : SP.modifyScore(actualPlayer);
				Player aux = actualPlayer; actualPlayer = otherPlayer; otherPlayer = aux;
				break;
				case 2 : SP.modifyScore(otherPlayer); 
				break;
				}
				SD.showScore(p1, p2);
					System.out.println("\n------------------------------------\n");
				turno++;	
			}else{
				next = false;
			}
		}

		dm.finalScore(SD, SP.getPlayers());

	}
}
