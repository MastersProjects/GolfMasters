package ch.golfmasters.listener;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.golfmasters.model.Runde;
import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

public class AddPointListener implements ActionListener{

	private Spiel spiel;
	private JTextField punkte;
	private int spielerListNr;
	private JTextArea textArea;
	private Runde runde;
	private JTextField nachname;
	private JTextField vorname;
	private JButton add;
	private JButton next;
	private JButton end;
	
	public AddPointListener(Spiel spiel, JTextField punkte, int spielerListNr, JTextArea textArea, Runde runde, JTextField nachnameText, JTextField vornameText, JButton add, JButton next, JButton end){
		this.spiel = spiel;
		this.punkte = punkte;
		this.spielerListNr = spielerListNr;
		this.textArea = textArea;
		this.runde = runde;
		this.nachname = nachnameText;
		this.vorname = vornameText;
		this.add = add;
		this.next = next;
		this.end = end;
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<Spieler> spielern = spiel.getSpielern();	
		this.runde.getPunkte().put(spielern.get(spielerListNr).getSpielerNr(), Integer.parseInt(punkte.getText()));
				
		String currentText = textArea.getText();
		String newText = currentText + "\nNr: "+ spielern.get(spielerListNr).getSpielerNr() + "  Name: " + this.nachname.getText() + "  Vorname: " + this.vorname.getText() + "  Punkte: " + this.punkte.getText();
		textArea.setText(newText);
		punkte.setText("");

		if(spiel.getSpielern().size() == spielerListNr +1){
			end.setEnabled(true);
			next.setEnabled(true);			
			add.setEnabled(false);
			spiel.getRunden().add(runde);
			
		}else if(spiel.getSpielern().size() != spielerListNr +1){
			nachname.setText(spielern.get(spielerListNr +1).getName());
			vorname.setText(spielern.get(spielerListNr +1).getVorname());
			
			this.spielerListNr = this.spielerListNr +1;
		}
	}

}
