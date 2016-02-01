package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.DatabaseRessourres;

import com.mysql.jdbc.StringUtils;

public class NFF extends JFrame {
	
	private static final String[] BILDERPFAD = {"src\\PicRessources\\englisch.jpg", "src\\PicRessources\\deutsch.jpg", "src\\PicRessources\\infoIcon.jpg"};

	private static final int KILOMETERSPRUNG = 1000;
	private JComboBox<String> comboMarke;
	private JComboBox<String> combobauJahr;
	private JComboBox<String> comboModel;
	private JComboBox<String> comboTyp;
	private JComboBox<String> comboKMstand;
	private JComboBox<String> comboLeistung;
	
	private JRadioButton benzin;
	private JRadioButton diesel; 
	
	private JTextField kundeName;
	private JTextField kundeVorname;
	private JTextField firmaName;
	private JTextField kundeAdresse;
	private JTextField plzNummer;
	private JTextField ortName;
	
	private JTextField fahrgeNummer;
	private JTextField amtlichesKennzeichen;
	

	private String baujahr;
	private String marke;
	private int markenNummer;
	private String modelBezeichnung;
	private String typ;
	private String kmStand;
	private String leistung;
	
	private Map<Integer,String> inputData;
	
	private JButton okButton;

	public NFF(int breite, int hoehe, int languageType) {
		// breite, hoehe
		this.setSize(breite, hoehe);
		// zentrieren
		this.centerFrame();
		// Titel
		this.setTitle(LR.NEUESFAHRZEUG[0][languageType]);
		
		//this.setLayout(new BorderLayout());
		Container contentPane = getContentPane();
		JTabbedPane tabbed = new JTabbedPane();
		
		// fahrzeugPanel
		JPanel fahrzeugPanel = new JPanel();
		fahrzeugPanel.setLayout(new GridLayout(4, 1));
		fahrzeugPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		String[] marken = DatabaseRessourres.getMarkenFromDatabase();
		String[] baujahrArray = createConstructionYears();
		int currentIndex = 0;
		
		String[] model = DatabaseRessourres.getModelFromDatabase(currentIndex);
		String[] typenNeu = DatabaseRessourres.getTypesFromDatabase(); 
		String[] leistungArray = createPowerNumbers();
		String[] kmStandArray = createKilometerNumber();
		
		
		comboMarke = new JComboBox<>(marken);
		combobauJahr = new JComboBox<>(baujahrArray);
		comboModel = new JComboBox<>(model);
		comboTyp = new JComboBox<>(typenNeu);
		comboLeistung = new JComboBox<>(leistungArray);
		comboKMstand = new JComboBox<>(kmStandArray);
		
		comboMarke.setEnabled(true);
		combobauJahr.setEnabled(true);
		comboModel.setEnabled(true);
		comboTyp.setEnabled(true);
		comboLeistung.setEnabled(true);
		comboKMstand.setEnabled(true);
		
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[1][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(comboMarke);
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[2][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(combobauJahr);
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[3][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(comboModel);
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[4][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(comboTyp);
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[6][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(comboLeistung);
		fahrzeugPanel.add(new JLabel(LR.FAHRZEUG[7][languageType], SwingConstants.RIGHT));
		fahrzeugPanel.add(comboKMstand);
	
		
	    benzin = new JRadioButton("Benzin");
	    benzin.setSelected(true);
	    diesel = new JRadioButton("Diesel");
	    fahrzeugPanel.add(new JLabel());
	    fahrzeugPanel.add(diesel);
	    fahrzeugPanel.add(benzin);
	    
	    // northPanel
	 	JPanel northPanel = new JPanel();
	 	northPanel.setLayout(new GridLayout(3, 3));
	 	amtlichesKennzeichen = new JTextField();
	 	amtlichesKennzeichen.setEditable(true);
	 	fahrgeNummer = new JTextField();
	 	fahrgeNummer.setEditable(true);
	 	
	 	addBlankoZeile(northPanel, 3);
	 	northPanel.add(new JLabel(LR.FAHRZEUG[5][languageType], SwingConstants.RIGHT));
	 	northPanel.add(fahrgeNummer);
	 	northPanel.add(new JLabel());
	 	
	 	northPanel.add(new JLabel(LR.FAHRZEUG[8][languageType], SwingConstants.RIGHT));
	 	northPanel.add(amtlichesKennzeichen);
	 	northPanel.add(new JLabel());
		
		// southPanel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		okButton = new JButton(LR.NEUESFAHRZEUG[2][languageType]);
		southPanel.add(getHelpLabel(languageType), SwingConstants.CENTER);
		southPanel.add(okButton);
		
		JPanel kundenPanel = new JPanel();
		kundenPanel.setLayout(new GridLayout(5, 5));
		kundeName = new JTextField();
		kundeVorname = new JTextField();
		firmaName = new JTextField();
		kundeAdresse = new JTextField();
		plzNummer = new JTextField();
		ortName = new JTextField();
		
		kundeName.setEditable(true);
		kundeVorname.setEditable(true);
		firmaName.setEditable(true);
		kundeAdresse.setEditable(true);
		plzNummer.setEditable(true);
		ortName.setEditable(true);
		
		// erste Zeile
		addBlankoZeile(kundenPanel, 5);
		// zweite Zeile
		kundenPanel.add(new JLabel(LR.KUNDE[1][languageType], SwingConstants.RIGHT));
		kundenPanel.add(kundeName);
		kundenPanel.add(new JLabel(LR.KUNDE[2][languageType], SwingConstants.RIGHT));
		kundenPanel.add(kundeVorname);
		kundenPanel.add(new JLabel());
		// dritte Zeile
		kundenPanel.add(new JLabel(LR.KUNDE[3][languageType], SwingConstants.RIGHT));
		kundenPanel.add(firmaName);
		kundenPanel.add(new JLabel(LR.KUNDE[4][languageType], SwingConstants.RIGHT));
		kundenPanel.add(kundeAdresse);
		kundenPanel.add(new JLabel());
		// vierte Zeile
		kundenPanel.add(new JLabel(LR.KUNDE[5][languageType], SwingConstants.RIGHT));
		kundenPanel.add(plzNummer);
		kundenPanel.add(new JLabel(LR.KUNDE[6][languageType], SwingConstants.RIGHT));
		kundenPanel.add(ortName);
		kundenPanel.add(new JLabel());
		// fünfte Zeile
		addBlankoZeile(kundenPanel, 3);
		
		tabbed.addTab(LR.FAHRZEUG[0][languageType], fahrzeugPanel);
		tabbed.addTab(LR.KUNDE[0][languageType], kundenPanel);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(tabbed, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		inputData = new HashMap<>();
		
		// ActionListener-Registrierung der ComboBoxen
		comboMarke.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				marke = (String) comboMarke.getSelectedItem();
				markenNummer = comboMarke.getSelectedIndex();
				updateComboBoxModel(comboModel, markenNummer);
				inputData.put(1, marke);
			}
		});
		
		combobauJahr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				baujahr = (String) combobauJahr.getSelectedItem();
				inputData.put(2, baujahr);
			}
		});
		
		comboModel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				modelBezeichnung = (String)comboModel.getSelectedItem();
			}
		});
		
		comboTyp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				typ = (String) comboTyp.getSelectedItem();
				inputData.put(3,typ);
			}
		});
		
		comboKMstand.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				kmStand = (String) comboKMstand.getSelectedItem();
				inputData.put(4, kmStand);
			}
		});
		
		comboLeistung.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				leistung = (String) comboLeistung.getSelectedItem();
				inputData.put(5, leistung);
			}
		});
	    
	    diesel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	benzin.setSelected(false);
            	inputData.put(6, "Diesel");
            }
        });
	    benzin.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		diesel.setSelected(false);
        		inputData.put(7, "Benzin");            
        		}
        });
		
	    okButton.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				completeInputData();
				if (checkInput(languageType, inputData)) {
					// TODO Methode zum Abspeichern
					confirmationMessage(languageType, inputData);
					closeNeuesFahrzeug();
				} else 
					{
					JOptionPane.showMessageDialog(null, LR.HILFE[0][languageType], LR.MELDUNG[1][languageType],
							JOptionPane.ERROR_MESSAGE);
				}
			}
        });
	    
	    

		this.setVisible(true);
		
	} // ende Konstruktor
	
	
	
	
	// Bestätigung
	private void confirmationMessage(int pLanguageType, Map<Integer, String> pInputData) {
		String kuFahrgestellNummer = pInputData.get(new Integer(10));
		String kuVorname = pInputData.get(new Integer(11));
		String text = LR.MELDUNG[3][pLanguageType];
		JOptionPane.showMessageDialog(null, text, null, JOptionPane.INFORMATION_MESSAGE);
		
	}

	private void completeInputData() {
		inputData.put(8, modelBezeichnung);
		inputData.put(9 , fahrgeNummer.getText());
		inputData.put(10, amtlichesKennzeichen.getText());
		inputData.put(11, kundeName.getText());
		inputData.put(12, kundeVorname.getText());
		inputData.put(13, kundeAdresse.getText());
		inputData.put(14, firmaName.getText()); 
		inputData.put(15, plzNummer.getText());
		inputData.put(16, ortName.getText());
	}

	// schließen des Eingabe dialogs
	private void closeNeuesFahrzeug() {
		setVisible(false);
		dispose();
	}
	
	// HilfeIcon
	private JLabel getHelpLabel(int languageType) {
		ImageIcon helpIcon = null;
		try {
			helpIcon = new ImageIcon(ImageIO.read(new File(BILDERPFAD[2])));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel helpLabel = new JLabel(helpIcon, SwingConstants.RIGHT);
		helpLabel.setToolTipText(LR.HILFE[5][languageType]);
		helpLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me){
				provideInfosForNewCar(languageType);
			}
		});
		return helpLabel;
	}


	// Info Box zu Gruppen
	private void provideInfosForNewCar(int languageType) {
		String dialogText = LR.HILFE[0][languageType];
		JOptionPane.showMessageDialog(null, dialogText, null, JOptionPane.INFORMATION_MESSAGE);
	}


	private void addBlankoZeile(JPanel kundenPanel, int spalten) {
		for (int i = 0; i < spalten; i++) {
		kundenPanel.add(new JLabel());
		}
	}


	// liefert in 1000 sprüngen Zahlen bis 1 Mio
	private String[] createKilometerNumber() {
		ArrayList<String> km = new ArrayList<>();
		km.add("");
		for (int i = 0; i <= Math.pow(10, 6);) {
			km.add(String.valueOf(i));
			i = i + KILOMETERSPRUNG;
		}
		String[] kmArray = km.toArray(new String[km.size()]);
		return kmArray;
	}


	// liefert Zahlen bis 1000 
	private String[] createPowerNumbers() {
		ArrayList<String> leistung = new ArrayList<>();
		leistung.add("");
		for (int i = 0; i <= Math.pow(10, 3); i++) {
			leistung.add(String.valueOf(i));
		}
		String[] leistungArray = leistung.toArray(new String[leistung.size()]);
		return leistungArray;
	}



	// setz das Fenster in die Bildschirmmitte
	private void centerFrame() {
		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}
	
	// liefert Jahre bis 1900 absteigend ab aktuellem Jahr 
	private String[] createConstructionYears() {
		ArrayList<String> bauJahr = new ArrayList<>();
		bauJahr.add("");
		int currentYear = new GregorianCalendar().get(Calendar.YEAR);
		for (int i = currentYear; i > 1900; i--) {
			bauJahr.add(String.valueOf(i));
		}
		String[] baujahrArray = bauJahr.toArray(new String[bauJahr.size()]);
		return baujahrArray;
	}
	
	
	// prüft ob alle Felder gesetzt sind
	private boolean checkInput(int pLanguageType, Map<Integer, String> data) {
		boolean invalid = true;
		for (Entry<Integer, String> vo : data.entrySet()) {
			if (!vo.getKey().equals(new Integer(14))) {
				if (StringUtils.isEmptyOrWhitespaceOnly(vo.getValue())) {
					invalid = false;
					break;
				}
			}
			
		}
	
		return invalid;
	}

	// Liefert zur Marke die passenden Modelle
	private void updateComboBoxModel(JComboBox<String> comboModel, int selectedIndex) {
		comboModel.removeAllItems();
		String[] newModels = DatabaseRessourres.getModelFromDatabase(selectedIndex);
		for (int i = 0; i < newModels.length; i++) {
			comboModel.addItem(newModels[i]);
		}
		comboModel.revalidate();
	}

}
