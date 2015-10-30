package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

public class AddPlayerListener implements ActionListener {

	private Spiel spiel;
	private JTextArea textArea;
	private JTextField name;
	private JTextField vorname;
	private JButton btnCreateGame;

	public AddPlayerListener(Spiel spiel, JTextArea textArea, JTextField name,
			JTextField vorname, JButton btnCreateGame) {
		this.spiel = spiel;
		this.textArea = textArea;
		this.name = name;
		this.vorname = vorname;
		this.btnCreateGame = btnCreateGame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!name.getText().isEmpty() && !vorname.getText().isEmpty()) {
			int anzahlSpieler = spiel.getSpielern().size();
			Spieler spieler = new Spieler(anzahlSpieler + 1,
					this.name.getText(), this.vorname.getText());
			spiel.getSpielern().add(spieler);

			String currentText = textArea.getText();
			String newText = currentText + "\nNr: " + (anzahlSpieler + 1)
					+ "  Name: " + this.name.getText() + "  Vorname: "
					+ this.vorname.getText();
			textArea.setText(newText);

			name.setText("");
			vorname.setText("");
			if (spiel.getSpielern().size() > 1) {
				btnCreateGame.setEnabled(true);
			}
			
			for (Spieler spieler1 : spiel.getSpielern()) {
				System.out.println(spieler1);
			} 
		} else {
			JOptionPane.showMessageDialog(null,
				    "Bitte alles ausfüllen.",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
		}
				
		}

}
