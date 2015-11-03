package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.GameGUI;
import ch.golfmasters.model.Spiel;
/**
 * ActionListener um ein neues Spiel zu erstellen.
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0 
 */
public class CreateGameListener implements ActionListener{

	//Instanzvariablen
	private Spiel spiel;
	private JFrame frame;
	
	/**
	 * Konstruktor der Klasse {@link CreateGameListener}
	 * @param frame {@link JFrame}
	 * @param spiel {@link Spiel}
	 */
	public CreateGameListener(JFrame frame, Spiel spiel){
		this.setSpiel(spiel);
		this.setFrame(frame);
	}
	
	public void actionPerformed(ActionEvent e) {
		new GameGUI(this.spiel);	
		frame.dispose();		
	}

	public Spiel getSpiel() {
		return spiel;
	}

	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
