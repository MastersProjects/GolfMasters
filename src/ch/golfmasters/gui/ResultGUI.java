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

public class ResultGUI extends JFrame {

	private JPanel contentPane;
	private JTable rangliste_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultGUI frame = new ResultGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
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
		btnBeenden.setBounds(327, 243, 117, 29);
		btnBeenden.addActionListener(new ResultGUIListener(btnBeenden.getText(), this));
		contentPane.add(btnBeenden);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setBounds(174, 243, 117, 29);
		btnNeuesSpiel.addActionListener(new ResultGUIListener(btnNeuesSpiel.getText(), this));
		contentPane.add(btnNeuesSpiel);
	}

}
