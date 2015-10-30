package ch.golfmasters.model;

import java.util.ArrayList;
import java.util.Vector;

public class Spiel {
	 
	//Instanz Variablen
	private int spielNr;
	private ArrayList<Runde> runden = new ArrayList<>();
	private ArrayList<Spieler> spielern = new ArrayList<>();
	
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
	public ArrayList<Spieler> getSpielern() {
		return spielern;
	}
	public void setSpielern(ArrayList<Spieler> spielern) {
		this.spielern = spielern;
	}
	
	public String toString(){
		String string = "";
		for(Spieler spieler : spielern){
			string = string + spieler.getName() + " " + spieler.getVorname();
			int punkte = 0;
			for(Runde runde : runden){
				punkte = punkte + runde.getPunkte().get(spieler.getSpielerNr());
			}
			string = string + " Punkt: " + punkte;
			string = string + "\n";
		}
		return string;
		
	}
	
	public Vector<?> getRangliste(){
		Vector<Vector> data = new Vector<Vector>();
		for(Spieler spieler : spielern){
			Vector<Object> row = new Vector<Object>();
			row.addElement(spieler.getName() + " " + spieler.getVorname());
			int punkte = 0;
			for(Runde runde : runden){
				punkte = punkte + runde.getPunkte().get(spieler.getSpielerNr());
			}
			row.addElement(punkte);				
			data.addElement(row);
		}
		return data;
		
	}
	


	
}
