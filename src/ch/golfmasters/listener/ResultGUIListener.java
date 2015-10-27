package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.golfmasters.gui.MainGUI;

public class ResultGUIListener implements ActionListener {

	private String btnName;

	public ResultGUIListener(String btnName){
		this.setBtnName(btnName);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.getBtnName().equals("Beenden")){
			System.exit(0);
		} else if (this.getBtnName().equals("Neues Spiel")){
			new MainGUI();
		}
	}
	
	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}
	
}
