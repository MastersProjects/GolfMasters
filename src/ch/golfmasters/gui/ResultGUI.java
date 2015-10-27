package ch.golfmasters.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ch.golfmasters.listener.ResultGUIListener;
import ch.golfmasters.model.Spiel;

import javax.swing.JTextArea;

public class ResultGUI extends JFrame {

	private Spiel spiel;
	
	private JPanel contentPane;
	private JTable rangliste_table;

	/**
	 * Create the frame.
	 */
	public ResultGUI(Spiel spiel) {
		this.spiel = spiel;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblResultat.setBackground(SystemColor.window);
		lblResultat.setBounds(22, 24, 146, 16);
		contentPane.add(lblResultat);
		
		JLabel lblGewinner = new JLabel("Rangliste");
		lblGewinner.setBounds(22, 52, 61, 16);
		contentPane.add(lblGewinner);
		
		rangliste_table = new JTable();
		rangliste_table.setBounds(22, 229, 399, -127);
		contentPane.add(rangliste_table);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(329, 268, 117, 29);
		btnBeenden.addActionListener(new ResultGUIListener(btnBeenden.getText(), this));
		contentPane.add(btnBeenden);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setBounds(177, 268, 117, 29);
		btnNeuesSpiel.addActionListener(new ResultGUIListener(btnNeuesSpiel.getText(), this));
		contentPane.add(btnNeuesSpiel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 79, 424, 178);
		contentPane.add(textArea);
		setVisible(true);
	}

}
