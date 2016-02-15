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
	private Fahrzeug aktuellesFahrzeug;
	
	public FahrzeugData(Fahrzeug pAktuellesFahrzeug, Container contentPane, JPanel centerPanel,
			int languageType) {
		super(contentPane, centerPanel, languageType);
		JLabel infoLabel = new JLabel(LR.FAHRZEUG[0][languageType], SwingConstants.CENTER);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		super.add(infoLabel, BorderLayout.NORTH);
		
		aktuellesFahrzeug = pAktuellesFahrzeug;
		
		model = new DefaultTableModel();
		
		model.addColumn(" ");
		model.addColumn(" ");
		
		completeTableWithFahrzeugData(pAktuellesFahrzeug, model, languageType);
		
		table = new JTable(model);	
		scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
        
	} // Konstruktor ende
	
	

	private void completeTableWithFahrzeugData(Fahrzeug fahrzeug, DefaultTableModel model, int languageType) {
		
		ArrayList<String> fahrzeugData = new ArrayList<>(); 
//		fahrzeugData.add(fahrzeug.getmMarke());
//		fahrzeugData.add(fahrzeug.getmProduktionsdatum());
//		fahrzeugData.add(fahrzeug.getmTyp());
//		fahrzeugData.add(String.valueOf(fahrzeug.getmKilometerstand()));
//		fahrzeugData.add(String.valueOf(fahrzeug.getmLeistung()));
//		fahrzeugData.add(fahrzeug.getmKraftstoff());
//		fahrzeugData.add(fahrzeug.getmModell());
//		fahrzeugData.add(fahrzeug.getmFahrgestellnummer());
//		fahrzeugData.add(fahrzeug.getmKennzeichen());
//		fahrzeugData.add(fahrzeug.getmKundenName());
//		fahrzeugData.add(fahrzeug.getmKundenVorname());
//		fahrzeugData.add(fahrzeug.getmKundenFirma());
//		fahrzeugData.add(fahrzeug.getmKundenPLZ());
//		fahrzeugData.add(fahrzeug.getmKundenOrt());
	
		fahrzeugData.add("BMW"); 
		fahrzeugData.add("2014");
		fahrzeugData.add("coupe");
		fahrzeugData.add("124734");
		fahrzeugData.add("200");
		fahrzeugData.add("2");
		fahrzeugData.add("1er");
		fahrzeugData.add("b5643456");
		fahrzeugData.add("ED-K-1410");
		
		fahrzeugData.add("Name");
		fahrzeugData.add("Vorname");
		fahrzeugData.add("FirmaAdresse");
		fahrzeugData.add("PLZ");
		fahrzeugData.add("Ort");
		
		
		Vector<String> rowData;
		for (int i = 0; i < fahrzeugData.size(); i++) {
			rowData = new Vector<String>();
			rowData.add(0, LR.FAHRZEUGANZEIGE[i][languageType].toUpperCase());
			String str = fahrzeugData.get(i);
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
