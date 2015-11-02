package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.GameGUI;
import ch.golfmasters.gui.ResultGUI;
import ch.golfmasters.model.Spiel;
/**
 * ButtonListener für das {@link MainGUI} enthält Button
 * um Spiel zu beenden oder nächste Runde
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 0.1
 */
public class RoundButtonListener implements ActionListener {
	
	//Instanzvariablen
	private Spiel spiel;
	private String ButtonName;
	private JFrame frame;
	
	/**
	 * Konstruktor dr Klasse RoundButtonListener
	 * @param ButtonName
	 * @param spiel
	 * @param frame
	 */
	public RoundButtonListener(String ButtonName, Spiel spiel, JFrame frame) {
		this.setButtonName(ButtonName);
		this.setSpiel(spiel); 
		this.setFrame(frame);
	}
	
	@Override
	/*Nimmt Text des Buttons und überprüft so welcher
	  Knopf vom User gedrückt wurde*/
	public void actionPerformed(ActionEvent e) {
		if (this.getButtonName().equals("Spiel beenden")) {
			 new ResultGUI(spiel);
			 frame.dispose();
		} else if (this.getButtonName().equals("Nächste Runde")){
			new GameGUI(spiel);
			frame.dispose();
		}	
	}

	public Spiel getSpiel() {
		return spiel;
	}

	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	public String getButtonName() {
		return ButtonName;
	}

	public void setButtonName(String buttonName) {
		ButtonName = buttonName;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
