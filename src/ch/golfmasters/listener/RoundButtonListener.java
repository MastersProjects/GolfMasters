package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.GameGUI;
import ch.golfmasters.gui.ResultGUI;
import ch.golfmasters.model.Spiel;

public class RoundButtonListener implements ActionListener {
	
	private Spiel spiel;
	private String ButtonName;
	private JFrame frame;
	
	public RoundButtonListener(String ButtonName, Spiel spiel, JFrame frame) {
		this.ButtonName = ButtonName;
		this.spiel = spiel; 
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.ButtonName.equals("Spiel beenden")) {
			 new ResultGUI(spiel);
			 frame.dispose();
		} else if (this.ButtonName.equals("Nächste Runde")){
			new GameGUI(spiel);
		}	
	}

}
