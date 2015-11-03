package ch.golfmasters.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import ch.golfmasters.listener.AddPointListener;
import ch.golfmasters.listener.RoundButtonListener;
import ch.golfmasters.model.Runde;
import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 * GameGUI Klasse, ist nur für Layout zuständig,
 * ist dafür da Resultate in das Programme aufzunehmen
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0
 */
public class GameGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private int spielerListNr;
	
	private Spiel spiel;
	private Runde runde;
	private ArrayList<Spieler> spieler;
	
	private JPanel contentPane;
	private JTextField punkteText;
	private JTextField nachnameText;
	private JTextField vornameText;

	/**
	 * Konstruktor der Klasse {@link GameGUI}
	 * @param spiel {@link Spiel}
	 */
	public GameGUI(Spiel spiel) {
		spielerListNr = 0;
		this.spiel = spiel;
		spieler = spiel.getSpielern();
		System.out.println(spiel.getRunden().size());
		runde = new Runde(spiel.getRunden().size() + 1);		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GolfMasters");
		label.setBackground(new Color(238, 238, 238));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(22, 24, 146, 16);
		contentPane.add(label);
		
		JButton next = new JButton("Nächste Runde");
		next.setBounds(340, 288, 131, 29);
		next.setEnabled(false);
		next.addActionListener(new RoundButtonListener(next.getText(), spiel, this));
		contentPane.add(next);
		
		JButton end = new JButton("Spiel beenden");
		end.setBounds(22, 288, 117, 29);
		end.setEnabled(false);
		end.addActionListener(new RoundButtonListener(end.getText(), spiel, this));
		contentPane.add(end);
		
		JLabel lblRunde = new JLabel("Runde " + (spiel.getRunden().size() + 1));
		lblRunde.setBounds(22, 52, 61, 16);
		contentPane.add(lblRunde);
		
		JLabel lblNewLabel = new JLabel("Punkte:");
		lblNewLabel.setBounds(254, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		punkteText = new JTextField();
		punkteText.setBounds(306, 74, 51, 29);
		contentPane.add(punkteText);
		punkteText.setColumns(10);
		
		nachnameText = new JTextField(spieler.get(spielerListNr).getName());
		nachnameText.setColumns(10);
		nachnameText.setBounds(22, 74, 104, 29);
		nachnameText.setEditable(false);
		contentPane.add(nachnameText);
		
		vornameText = new JTextField(spieler.get(spielerListNr).getVorname());
		vornameText.setColumns(10);
		vornameText.setBounds(140, 74, 104, 29);
		vornameText.setEditable(false);
		contentPane.add(vornameText);
		
		JButton add = new JButton("Add");
		add.setBounds(382, 77, 89, 23);
		contentPane.add(add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 133, 449, 131);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		add.addActionListener(new AddPointListener(spiel, punkteText, spielerListNr, textArea, runde, nachnameText, vornameText, add, next, end));
	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	
	//Getter und Setter
	public Spiel getSpiel() {
		return spiel;
	}

	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	public int getSpielerListNr() {
		return spielerListNr;
	}

	public void setSpielerListNr(int spielerListNr) {
		this.spielerListNr = spielerListNr;
	}

	public Runde getRunde() {
		return runde;
	}

	public void setRunde(Runde runde) {
		this.runde = runde;
	}

	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}

	public void setSpieler(ArrayList<Spieler> spieler) {
		this.spieler = spieler;
	}
}