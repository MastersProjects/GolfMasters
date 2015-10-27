package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.GameGUI;
import ch.golfmasters.model.Spiel;

public class CreateGameListener implements ActionListener{

	private Spiel spiel;
	private JFrame frame;
	
	public CreateGameListener(JFrame frame, Spiel spiel){
		this.spiel = spiel;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameGUI gameGUI = new GameGUI();
		gameGUI.setSpiel(this.spiel);		
		frame.dispose();		
	}

}
