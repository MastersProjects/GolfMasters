package ch.golfmasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class AddPlayerListener implements ActionListener {
	
	private JFrame frame;
	private JTable table;
	private JTextField name;
	private JTextField vorname;

	public AddPlayerListener(JFrame frame, JTable table, JTextField name, JTextField vorname){
		this.frame = frame;
		this.table = table;
		this.name = name;
		this.vorname = vorname;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.name.getText());
		System.out.println(this.vorname.getText());
		//Vector mit den Titeln erstellen
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Name");
		columnNames.addElement("Vorname");
		
		//Vector mit den Datensätze erstellen
		@SuppressWarnings("rawtypes")
		Vector<Vector> data = new Vector<Vector>();
		
		//erstellt ein Vector mit den Noten
	
			
			Vector<Object> row = new Vector<Object>();
				
			row.addElement(this.name.getText());	
			row.addElement(this.vorname.getText());
							
			data.addElement(row);						
		
		
		//Tabel Model erstellen
		TableModel model = new DefaultTableModel(data, columnNames);
		
		//das alte Table Model mit den neuen Model wechseln
		this.table.setModel(model);		
		SwingUtilities.updateComponentTreeUI(frame);
	}

}
