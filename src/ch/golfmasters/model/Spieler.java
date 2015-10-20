package ch.golfmasters.model;

public class Spieler {

	//Instanz Variablen
	private int spielerNr;
	private String name;
	private String vorname;
	
	public Spieler(int spielerNr, String name, String vorname){
		this.spielerNr = spielerNr;
		this.name = name;
		this.vorname = vorname;
	}
	
	
	//Getter und Setter
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
	
	public String toString(){
		String string = "";
		string = string + "SpielNr: " + this.spielerNr;
		string = string + " Name: " + this.name;
		string = string + " Vorname: " + this.vorname;
		return string;
		
	}
	
	
}
