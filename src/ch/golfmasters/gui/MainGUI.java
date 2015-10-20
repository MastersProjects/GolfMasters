package ch.golfmasters.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nachname_textField;
	private JTextField vorname_textField;
	private JTable user_table;
	private JLabel lblPlayers;
	private JButton btnCreateGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGolfmasters = new JLabel("GolfMasters");
		lblGolfmasters.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGolfmasters.setBounds(22, 24, 146, 16);
		contentPane.add(lblGolfmasters);
		
		JLabel lblVorname = new JLabel("Nachname");
		lblVorname.setBounds(22, 71, 75, 16);
		contentPane.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Vorname");
		lblNachname.setBounds(239, 71, 90, 16);
		contentPane.add(lblNachname);
		
		nachname_textField = new JTextField();
		nachname_textField.setBounds(93, 65, 134, 28);
		contentPane.add(nachname_textField);
		nachname_textField.setColumns(10);
		
		vorname_textField = new JTextField();
		vorname_textField.setBounds(298, 65, 134, 28);
		contentPane.add(vorname_textField);
		vorname_textField.setColumns(10);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(336, 105, 101, 29);
		contentPane.add(btnAddUser);
		
//		String [] columns = {"Nachname", "Vorname"};
		user_table = new JTable();
		user_table.setToolTipText("\n");
		user_table.setBounds(32, 270, 405, -72);
		contentPane.add(user_table);
		
		lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(24, 164, 61, 16);
		contentPane.add(lblPlayers);
		
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(336, 280, 117, 29);
		contentPane.add(btnCreateGame);
	}
}
