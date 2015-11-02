package ch.golfmasters.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ch.golfmasters.listener.ResultGUIListener;
import ch.golfmasters.model.Spiel;

import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class ResultGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Spiel spiel;
	
	private JPanel contentPane;	
	
	protected JTable ranglisteTable = new JTable();
	

	/**
	 * Create the frame.
	 */
	public ResultGUI(Spiel spiel) {
		this.setSpiel(spiel);
		System.out.println(spiel.getRunden().size());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 403);
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
		

		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(365, 324, 117, 29);
		btnBeenden.addActionListener(new ResultGUIListener(btnBeenden.getText(), this));
		contentPane.add(btnBeenden);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setBounds(224, 324, 117, 29);
		btnNeuesSpiel.addActionListener(new ResultGUIListener(btnNeuesSpiel.getText(), this));
		contentPane.add(btnNeuesSpiel);
		
		
		
		
		Vector<Object> data = spiel.getRangliste();
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Spieler");
		columnNames.addElement("Punkte");
		
		//TABLEMODEL with rangliste sort fix
		TableModel model = new DefaultTableModel(data, columnNames) {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column)
            {
                // Lookup first non-null data on column
                for (int row = 0; row < getRowCount(); row++) 
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
	    };
	    
		for(int i = 0; i < 10; i++){
			ranglisteTable.setRowHeight(i, 30);
		}
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(SwingConstants.CENTER);
		JTableHeader header = ranglisteTable.getTableHeader();
		header.setBounds(22, 79, 460, 37);
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setEnabled(false);
		contentPane.add(header);
		


		ranglisteTable.setModel(model);
		ranglisteTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		ranglisteTable.getColumnModel().getColumn(0).setCellRenderer(centerRender);
		ranglisteTable.getColumnModel().getColumn(1).setCellRenderer(centerRender);
		ranglisteTable.setFont(new Font("Arial", Font.PLAIN, 20));
		ranglisteTable.setEnabled(false);
		ranglisteTable.setRowHeight(25);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(ranglisteTable.getModel());		
		ranglisteTable.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 89, 460, 224);
		
		scrollPane.setViewportView(ranglisteTable);
		
		contentPane.add(scrollPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setVisible(true);
	}


	public Spiel getSpiel() {
		return spiel;
	}


	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}
}
