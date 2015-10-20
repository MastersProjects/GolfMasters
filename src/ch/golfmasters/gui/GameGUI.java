package ch.golfmasters.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTable runde_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GolfMasters");
		label.setBackground(new Color(238, 238, 238));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(22, 24, 146, 16);
		contentPane.add(label);
		
		JButton btnNchsteRunde = new JButton("Nächste Runde");
		btnNchsteRunde.setBounds(313, 243, 131, 29);
		contentPane.add(btnNchsteRunde);
		
		JButton btnSpielBeenden = new JButton("Spiel beenden");
		btnSpielBeenden.setBounds(164, 243, 117, 29);
		contentPane.add(btnSpielBeenden);
		
		JButton btnLetzteRunde = new JButton("Letzte Runde");
		btnLetzteRunde.setBounds(0, 243, 131, 29);
		contentPane.add(btnLetzteRunde);
		
		runde_table = new JTable();
		runde_table.setBounds(22, 220, 406, -131);
		contentPane.add(runde_table);
		
		JLabel lblRunde = new JLabel("Runde x");
		lblRunde.setBounds(22, 52, 61, 16);
		contentPane.add(lblRunde);
	}

}
