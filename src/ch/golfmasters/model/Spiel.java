package ch.golfmasters.model;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Model Klasse Spiel, enthält alles Attribute die für eine Spiel benötigt
 * werden.
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0
 */
public class Spiel {

	// Instanz Variablen
	private int spielNr;
	private ArrayList<Runde> runden;
	private ArrayList<Spieler> spielern;

	/**
	 * Konstruktor der Klasse {@link Spiel}
	 * @param spielNr int
	 */
	public Spiel(int spielNr) {
		this.spielNr = spielNr;
		this.runden = new ArrayList<>();
		this.spielern = new ArrayList<>();
	}

	// Getter und Setter
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

	//Wurde nur für Entwicklung benötigt
	public String toString() {
		String string = "";
		for (Spieler spieler : spielern) {
			string = string + spieler.getName() + " " + spieler.getVorname();
			int punkte = 0;
			for (Runde runde : runden) {
				punkte = punkte + runde.getPunkte().get(spieler.getSpielerNr());
			}
			string = string + " Punkt: " + punkte;
			string = string + "\n";
		}
		return string;

	}
//ToDo
	/**
	 * 
	 * @return Vector<Object>
	 */
	public Vector<Object> getRangliste() {
		Vector<Object> data = new Vector<Object>();
		for (Spieler spieler : spielern) {
			Vector<Object> row = new Vector<Object>();
			row.addElement(spieler.getName() + " " + spieler.getVorname());
			int punkte = 0;
			for (Runde runde : runden) {
				punkte = punkte + runde.getPunkte().get(spieler.getSpielerNr());
			}
			row.addElement(punkte);
			data.addElement(row);
		}
		return data;

	}

}
