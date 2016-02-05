package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FahrzeugData extends CenterPanel {

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	public FahrzeugData(Container contentPane, JPanel centerPanel,
			int languageType) {
		super(contentPane, centerPanel, languageType);
		JLabel infoLabel = new JLabel(LR.FAHRZEUG[0][languageType], SwingConstants.CENTER);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		super.add(infoLabel, BorderLayout.NORTH);
		model = new DefaultTableModel();
		
		model.addColumn(" ");
		model.addColumn(" ");
		
		completeTableWithFahrzeugData(model, languageType);
		
		table = new JTable(model);	
		scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
        
	} // Konstruktor ende
	
	

	private void completeTableWithFahrzeugData(DefaultTableModel model, int languageType) {
		
		ArrayList<String> versuchsData = new ArrayList<>(); // TODO
//		versuchsData.add("BMW");
//		versuchsData.add("2014");
//		versuchsData.add("coupe");
//		versuchsData.add("124734");
//		versuchsData.add("200");
//		versuchsData.add("2");
//		versuchsData.add("1er");
//		versuchsData.add("b5643456");
//		versuchsData.add("ED-K-1410");
//		
//		versuchsData.add("Name");
//		versuchsData.add("Vorname");
//		versuchsData.add("FirmaAdresse");
//		versuchsData.add("PLZ");
//		versuchsData.add("Ort");
		
		
		Vector<String> rowData;
		for (int i = 0; i < versuchsData.size(); i++) {
			rowData = new Vector<String>();
			rowData.add(0, LR.FAHRZEUGANZEIGE[i][languageType].toUpperCase());
			String str = versuchsData.get(i);
			if (i == 5 && (str.equals("1") || str.equals("2"))) {
				if (str.equals("1")) {
					str = "Benzin";
				} else if (str.equals("2")) {
					str = "Diesel";
				} else {
					str = "unbekannt";
				}
			}
			rowData.add(1, str);
			model.addRow(rowData);
					
		}
		

	}

}
