package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ch.golfmasters.gui.MainGUI;

public class ResultGUIListener implements ActionListener {

	private String btnName;
	private JFrame frame;

	public ResultGUIListener(String btnName, JFrame frame){
		this.setBtnName(btnName);
		this.setFrame(frame);
	}
	
	@Override
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
