package ch.golfmasters.model;

import java.util.ArrayList;

public class Spiel {
	 
	//Instanz Variablen
	private int spielNr;
	private ArrayList<Runde> runden = new ArrayList<>();
	private ArrayList<Spieler> spieler = new ArrayList<>();
	
	public Spiel(int spielNr){
		this.spielNr = spielNr;
	}
	
	
	
	
	
	//Getter und Setter
	public int getSpielNr() {
		return spielNr;
	}
	public void setSpielNr(int spielNr) {
		this.spielNr = spielNr;
	}
	public ArrayList<Runde> getRunden() {
		return runden;
	}
	public void setRunden(ArrayList<Runde> runden) {
		this.runden = runden;
	}
	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}
	public void setSpieler(ArrayList<Spieler> spieler) {
		this.spieler = spieler;
	}
	


	
}
