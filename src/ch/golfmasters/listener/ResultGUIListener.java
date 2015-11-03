package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.MainGUI;
/**
 * ButtonListener für das ResultGUI enthält Button
 * um Spiel zu beenden oder neues Spiel zu starten
 * @author Chiramed Phong Penglerd, Elia Perenzin 
 * @version 1.0
 */
public class ResultGUIListener implements ActionListener {

	//Instanzvariablen
	private String btnName;
	private JFrame frame;

	/**
	 * Konstruktor der Klasse {@link ResultGUIListener}
	 * @param btnName {@link String}
	 * @param frame {@link JFrame}
	 */
	public ResultGUIListener(String btnName, JFrame frame){
		this.setBtnName(btnName);
		this.setFrame(frame);
	}
	
	@Override
	/*Nimmt Text des Buttons und überprüft so welcher
	  Knopf vom User gedrückt wurde*/
	public void actionPerformed(ActionEvent e) {
		if (this.getBtnName().equals("Beenden")){
			System.exit(0);
		} else if (this.getBtnName().equals("Neues Spiel")){
			new MainGUI();
			this.getFrame().dispose();
		}
	}
	
	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
