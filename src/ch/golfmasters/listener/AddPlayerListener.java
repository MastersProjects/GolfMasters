package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;


public class AddPlayerListener implements ActionListener {
	
	private Spiel spiel;
	private JTextArea textArea;
	private JTextField name;
	private JTextField vorname;

	public AddPlayerListener(Spiel spiel, JTextArea textArea, JTextField name, JTextField vorname){
		this.spiel = spiel;
		this.textArea = textArea;
		this.name = name;
		this.vorname = vorname;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.name.getText());
		System.out.println(this.vorname.getText());
		//Vector mit den Titeln erstellen
		int anzahlSpieler = spiel.getSpieler().size();
		Spieler spieler = new Spieler(anzahlSpieler + 1, this.name.getText(), this.vorname.getText());
		spiel.getSpieler().add(spieler);
		
		String currentText = textArea.getText();
		String newText = currentText + "\nNr: "+ (anzahlSpieler + 1) + "  Name: " + this.name.getText() + "  Vorname: " + this.vorname.getText();
		textArea.setText(newText);
	
		name.setText("");
		vorname.setText("");
		
		for(Spieler spieler1 : spiel.getSpieler()){
			System.out.println(spieler1);
		}
	}

}
