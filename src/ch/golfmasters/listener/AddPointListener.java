package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.golfmasters.model.Runde;
import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

/**
 * ActionListener um Punkte in Punkte Array hinzuzufÃ¼gen
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0
 *
 */
public class AddPointListener implements ActionListener {

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

	/**
	 * Konstruktor der Klasse {@link AddPointListener}
	 * @param spiel {@link Spiel}
	 * @param punkte {@link JTextField}
	 * @param spielerListNr int
	 * @param textArea {@link JTextArea}
	 * @param runde {@link Runde}
	 * @param nachnameText {@link JTextField}
	 * @param vornameText {@link JTextField}
	 * @param add {@link JButton}
	 * @param next {@link JButton}
	 * @param end {@link JButton}
	 */
	public AddPointListener(Spiel spiel, JTextField punkte, int spielerListNr,
			JTextArea textArea, Runde runde, JTextField nachnameText,
			JTextField vornameText, JButton add, JButton next, JButton end) {
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

	@Override
	public void actionPerformed(ActionEvent e) { 
		ArrayList<Spieler> spielern = spiel.getSpielern();
		
		//Wenn eingabe gültig ist
		if(checkInput(punkte.getText())){
			this.runde.getPunkte().put(spielern.get(spielerListNr).getSpielerNr(),Integer.parseInt(punkte.getText())); //eingabe ins model einfügen
				
			//TextArea neue Reihe schreiben
			String currentText = textArea.getText();
			String newText = currentText + "\nNr: "
					+ spielern.get(spielerListNr).getSpielerNr() + "  Name: "
					+ this.nachname.getText() + "  Vorname: "
					+ this.vorname.getText() + "  Punkte: " + this.punkte.getText();
			textArea.setText(newText);
			
			//TextField Inhalt löschen
			punkte.setText("");
	
			//Wenn alle Spieler durch Buttons freischalten
			if (spiel.getSpielern().size() == spielerListNr + 1) {
				end.setEnabled(true);
				next.setEnabled(true);
				add.setEnabled(false);
				spiel.getRunden().add(runde);
	
			//Wenn noch nicht alle spieler durch
			} else if (spiel.getSpielern().size() != spielerListNr + 1) {
				nachname.setText(spielern.get(spielerListNr + 1).getName());
				vorname.setText(spielern.get(spielerListNr + 1).getVorname());
	
				this.spielerListNr = this.spielerListNr + 1;
			}
		}else{
			JOptionPane.showMessageDialog(null, "Die Zahl ist ungültig","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * 
	 * @param input {@link String}
	 * @return
	 */
	public boolean checkInput(String input){
		int inputInt = 0;
		try{
			inputInt = Integer.parseInt(input);
		}catch(NumberFormatException e){
			return false;
		}
		
		if(inputInt <= 7 && inputInt > 0){
			return true;
		}else{
			
			return false;
		}
	}

}
