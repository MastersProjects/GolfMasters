package ch.golfmasters.model;

/**
 * Model Klasse Spieler, enthält alles Attribute die für einen Spieler benötigt
 * werden.
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 0.2
 */
public class Spieler {

	// Instanz Variablen
	private int spielerNr;
	private String name;
	private String vorname;

	/**
	 * Konstruktor der Klasse {@link Spieler}
	 * @param spielerNr int
	 * @param name {@link String}
	 * @param vorname {@link String}
	 */
	public Spieler(int spielerNr, String name, String vorname) {
		this.spielerNr = spielerNr;
		this.name = name;
		this.vorname = vorname;
	}

	// Getter und Setter
	public int getSpielerNr() {
		return spielerNr;
	}

	public void setSpielerNr(int spielerNr) {
		this.spielerNr = spielerNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	//Wurde nur für entwicklung benötigt. 
	public String toString() {
		String string = "";
		string = string + "SpielNr: " + this.spielerNr;
		string = string + " Name: " + this.name;
		string = string + " Vorname: " + this.vorname;
		return string;
	}

}
