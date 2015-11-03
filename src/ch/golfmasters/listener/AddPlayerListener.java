package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

/**
 * ActionListener um Spieler in Spieler Array hinzuzufÃ¼gen
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0
 */
public class AddPlayerListener implements ActionListener {

	private Spiel spiel;
	private JTextArea textArea;
	private JTextField name;
	private JTextField vorname;
	private JButton btnCreateGame;

	/**
	 * Konstruktor der Klasse {@link AddPlayerListener}
	 * @param spiel {@link Spiel}
	 * @param textArea {@link JTextArea}
	 * @param name {@link JTextField}
	 * @param vorname {@link JTextField}
	 * @param btnCreateGame {@link JButton}
	 */
	public AddPlayerListener(Spiel spiel, JTextArea textArea, JTextField name,JTextField vorname, JButton btnCreateGame) {
		this.spiel = spiel;
		this.textArea = textArea;
		this.name = name;
		this.vorname = vorname;
		this.btnCreateGame = btnCreateGame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Wenn Eingabe nicht leer ist
		if (!name.getText().isEmpty() && !vorname.getText().isEmpty()) {
			int anzahlSpieler = spiel.getSpielern().size(); //anzahl spieler
			Spieler spieler = new Spieler(anzahlSpieler + 1, this.name.getText(), this.vorname.getText());
			spiel.getSpielern().add(spieler);
		
			//TextArea neue Reihe schreiben
			String currentText = textArea.getText();
			String newText = currentText + "\nNr: " + (anzahlSpieler + 1)
					+ "  Name: " + this.name.getText() + "  Vorname: "
					+ this.vorname.getText();
			textArea.setText(newText);

			//TextField Inhalt löschen
			name.setText("");
			vorname.setText("");
			
			//Wenn min. 2 Spieler dann kann man Create Game
			if (spiel.getSpielern().size() > 1) {
				btnCreateGame.setEnabled(true);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Bitte alles ausfüllen.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
