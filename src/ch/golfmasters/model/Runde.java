package ch.golfmasters.model;

import java.util.HashMap;
import java.util.Map;

public class Runde {

	//Instanz Variablen
	private int rundeNummer;
	private Map<Integer, Integer> punkte = new HashMap<Integer, Integer>();
	
	public Runde(int rundeNummer){
		this.rundeNummer = rundeNummer;
	}
	
	
	//Getter und Setter
	public int getRundeNummer() {
		return rundeNummer;
	}
	public void setRundeNummer(int rundeNummer) {
		this.rundeNummer = rundeNummer;
	}


	public Map<Integer, Integer> getPunkte() {
		return punkte;
	}


	public void setPunkte(Map<Integer, Integer> punkte) {
		this.punkte = punkte;
	}

	
	
	
}
