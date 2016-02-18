package GUIFZAApp;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.DatabaseRessourres;

public class FahrzeugbearbeitenFrame extends JFrame {
	
	private static final int ROWS = 9;
	private static final int COLS = 7;
	
	private JTextField ausstattungsFeld;
	private JTextField serviceEventFieldDatum;
	private JTextField serviceEventFieldKomponeneten;
	private JTextField serviceEventFieldMitarbeiter;
	
	private JComboBox<String> fahrgestellNummerCombo;
	
	private JCheckBox checkBox1;
	
	private JButton speichernButton;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;

	public FahrzeugbearbeitenFrame(int breite, int hoehe, int languageType)  {
		// breite, hoehe
		this.setSize(breite, hoehe);
		// zentrieren
		this.centerFrame();
		// Titel
		this.setTitle(LR.FAHRZEUGBEARBEITEN[0][languageType]);
	
		// ContentPane
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ROWS, COLS));
		
		ausstattungsFeld = new JTextField();
		ausstattungsFeld.setEditable(true);
		serviceEventFieldDatum = new JTextField();
		serviceEventFieldDatum.setEditable(true);
		serviceEventFieldKomponeneten = new JTextField();
		serviceEventFieldKomponeneten.setEditable(true);
		serviceEventFieldMitarbeiter = new JTextField();
		serviceEventFieldMitarbeiter.setEditable(true);
		
		checkBox1 = new JCheckBox("Servolenkung");
		checkBox2 = new JCheckBox("Klimaanlage");
		checkBox3 = new JCheckBox("ABS");
		checkBox4 = new JCheckBox("ESP");
		checkBox5 = new JCheckBox("Sitzheitzung");
		checkBox6 = new JCheckBox("Schiebedach");
		
		speichernButton = new JButton(LR.NEUESFAHRZEUG[2][languageType]);
		
		// Alle verfügbaren fahrgestellnummer
		String[] vorhandeneFahrgestellNummern = DatabaseRessourres.getAllFahrgestellnumbers();
		
		fahrgestellNummerCombo = new JComboBox<String>(vorhandeneFahrgestellNummern);
		fahrgestellNummerCombo.setEnabled(true);
		
		addBlankoZeile(panel, COLS); // 1.Reihe
		
		panel.add(new JLabel());  // 2. Reihe
		panel.add(new JLabel(LR.FAHRZEUG[5][languageType], SwingConstants.RIGHT));
		panel.add(fahrgestellNummerCombo);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		addBlankoZeile(panel, COLS); // 3.Reihe
		
		panel.add(new JLabel("Datum", SwingConstants.RIGHT)); // 4. Reihe
		panel.add(serviceEventFieldDatum);
		panel.add(new JLabel("Komponenten", SwingConstants.RIGHT));
		panel.add(serviceEventFieldKomponeneten);
		panel.add(new JLabel("Mitarbeiter", SwingConstants.RIGHT));
		panel.add(serviceEventFieldMitarbeiter);
		panel.add(new JLabel());
		
		addBlankoZeile(panel, COLS); // 5.Reihe
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel("Ausstattung", SwingConstants.RIGHT)); // 6. Reihe
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
	
		panel.add(checkBox1);  // 7.Reihe
		panel.add(checkBox2);
		panel.add(checkBox3);
		panel.add(checkBox4);
		panel.add(checkBox5);
		panel.add(checkBox6);
		panel.add(new JLabel()); 
		
		addBlankoZeile(panel, COLS); // 8.Reihe
		
		panel.add(new JLabel());  // 9. Reihe
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(speichernButton);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		Map<Integer, Object> input = new HashMap<Integer, Object>();
		
		
		
		// ActionListener ComboBox
		fahrgestellNummerCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String fahrgestellNummer = (String) fahrgestellNummerCombo.getSelectedItem();
				input.put(1, fahrgestellNummer);
			}
		});
		
		// ActionListener CeckBox1
		checkBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected1 = abstractButton.getModel().isSelected();

			}
		});
		
		// ActionListener CeckBox2
		checkBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected2 = abstractButton.getModel().isSelected();

			}
		});
		
		// ActionListener CeckBox3
		checkBox3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected3 = abstractButton.getModel().isSelected();

			}
		});
		
		// ActionListener CeckBox4
		checkBox4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected4 = abstractButton.getModel().isSelected();
				
			}
		});
		
		// ActionListener CeckBox5
		checkBox5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected5 = abstractButton.getModel().isSelected();

			}
		});
		
		// ActionListener CeckBox6
		checkBox6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				boolean checkBoxSelected6 = abstractButton.getModel().isSelected();
				
			}
		});
		
		
		speichernButton.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		// TODO abspeichern
              
        	}
        });
		
		contentPane.add(panel);
		this.setVisible(true);
	
	}  // Ende Konstruktor
	
	
	
	
	
	
	// setz das Fenster in die Bildschirmmitte
	private void centerFrame() {
		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}

	
	// fügt leere Labels hinzu
	private void addBlankoZeile(JPanel panel, int spalten) {
		for (int i = 0; i < spalten; i++) {
			panel.add(new JLabel());
		}
	}

	
	
	
	
}
