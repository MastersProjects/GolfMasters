package ch.golfmasters.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ch.golfmasters.listener.AddPlayerListener;
import ch.golfmasters.listener.CreateGameListener;
import ch.golfmasters.model.Spiel;

import java.awt.Color;
import java.util.Vector;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nachname_textField;
	private JTextField vorname_textField;
	private JLabel lblPlayers;
	private JButton btnCreateGame;
	private JTextArea textArea = new JTextArea();
	
	private Spiel spiel = new Spiel(1);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 382);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Name");
		columnNames.addElement("Vorname");
		textArea.setBounds(22, 161 , 410, 131);
		contentPane.add(textArea);
		
		lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(22, 134, 61, 16);
		contentPane.add(lblPlayers);
		
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(315, 303, 117, 29);
		contentPane.add(btnCreateGame);
		
		btnCreateGame.addActionListener(new CreateGameListener(this, spiel));
		btnAddUser.addActionListener(new AddPlayerListener(spiel, textArea, nachname_textField, vorname_textField));
		setContentPane(contentPane);
	}
}
