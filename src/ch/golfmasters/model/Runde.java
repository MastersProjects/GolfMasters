package ch.golfmasters.model;

import java.util.Map;

public class Runde {

	//Instanz Variablen
	private int rundeNummer;
	private Map<?, ?> punkte;
	
	
	//Getter und Setter
	public int getRundeNummer() {
		return rundeNummer;
	}
	public void setRundeNummer(int rundeNummer) {
		this.rundeNummer = rundeNummer;
	}
	public Map<?, ?> getPunkte() {
		return punkte;
	}
	public void setPunkte(Map<?, ?> punkte) {
		this.punkte = punkte;
	}
	
	
	
}
