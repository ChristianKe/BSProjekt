package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.StringUtils;

import FZAControl.User;


public class FZAFrame extends JFrame  {
	
	// Pfade
	private static final String[] BILDERPFAD = {"src\\PicRessources\\englisch.jpg", "src\\PicRessources\\deutsch.jpg", "src\\PicRessources\\infoIcon.jpg"};
	
	private static final Integer WIDTHMAINFRAME = 800;
	private static final Integer HEIGHTMAINFRAME = 600;
	
	private static final Integer WIDTH = 600;
	private static final Integer HEIGHT = 300;
	
	private static final int WIDTHFORUSERBEARBEITEN = 400;
	private static final int HEIGHTFORUSERBEARBEITEN = 250;
	
	private static final int NORTHPANELSPALTENANZAHL = 7;


	private static final int ROWSFOREASTPANEL = 7;

	// Farben für die linke Button-Spalte
	private static final Color color = new Color(0, 153, 238);


	private static final int southCols = 6;



	
	private JTextField inputFgNr;

	
	private JButton okButton;
	
	private JButton ausstattungsButton;
	
	private JButton serviceEventsButton;
	
	private JButton fahrzeugButton;
	
	private JButton logoutButton;
	
	private JButton languageButton;
	
	// button für Admin zum Benutzer anlegen und bearbeiten 
	private JButton neuerUser;
	private JButton userBearbeiten;
	
	// button für Admin zum Fahrzeug anlegen und bearbeiten 
	private JButton neuesFahrzeug;
	private JButton fahrzeugBearbeiten;
	
	private Container contentPane;
	
	private JPanel centerPanel;

	// 0 für deutsch, 1 für englisch
	private int languageType;

	private JLabel defaultInfoLabel;
	private JLabel currentUserLabel;
	
	
	// Konstruktor für ein Frame, Parameter ist currentUser
	public FZAFrame(User currentUser) throws HeadlessException {
		super();
		this.setSize(WIDTHMAINFRAME, HEIGHTMAINFRAME);
		this.setResizable(false); // nicht vergrößerbar
		centerFrame();
		this.languageType = 0; // Deutsch als Initial-Sprache
		this.setTitle(LR.APPLIKATIONSNAME[languageType]);
		
		// intitialisierung des JTextFields
		this.inputFgNr = new JTextField();
		this.inputFgNr.setEditable(true);
		this.inputFgNr.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// intitialisierung des OkButton
		this.okButton = new JButton("OK");
		this.okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				fahrzeugSuchen();
				}
		});
		
		// Initialisierung des
		this.ausstattungsButton = new JButton(LR.AUSSTATTUNG[languageType]);
		this.ausstattungsButton.setBackground(color);
		this.ausstattungsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				showFahrzeugAusstatung();
				}
		});
		
		// Initialisierung des
		this.serviceEventsButton = new JButton(LR.SERVICEFAELLE[languageType]);
		this.serviceEventsButton.setBackground(color);
		this.serviceEventsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				showServiceEvents();
				}
		});
		
		// Initialisierung des
		this.fahrzeugButton = new JButton(LR.FAHRZEUG[0][languageType]);
		this.fahrzeugButton.setBackground(color);
		this.fahrzeugButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				showFahrzeugDetails();
				}
		});
		
		
		// Button zum Anlegen eines neuen Users nur für Admins
		this.neuerUser = new JButton(LR.NEUERUSER[0][languageType]);
		this.neuerUser.setToolTipText(LR.NEUERUSER[1][languageType]);
		this.neuerUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				neuerUserAnlegen("","", "","", "");
				}
		});
		
		// Button zum Bearbeiten eines Users nur für Admins
		this.userBearbeiten = new JButton(LR.USERBEARBEITEN[0][languageType]);
		this.userBearbeiten.setToolTipText(LR.USERBEARBEITEN[1][languageType]);
		this.userBearbeiten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				userBearbeiten();
				}
		});
		
		// Button zum Anlegen eines neuen Fahrzeugs nur für Admins
		this.neuesFahrzeug = new JButton(LR.NEUESFAHRZEUG[0][languageType]);
		this.neuesFahrzeug.setToolTipText(LR.NEUESFAHRZEUG[1][languageType]);
		this.neuesFahrzeug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				neuesFahrzeugAnlegen();
				}
		});
		
		// Button zum Bearbeiten eine Fahrzeugs nur für Admins
		this.fahrzeugBearbeiten = new JButton(LR.FAHRZEUGBEARBEITEN[0][languageType]);
		this.fahrzeugBearbeiten.setToolTipText(LR.FAHRZEUGBEARBEITEN[1][languageType]);
		this.fahrzeugBearbeiten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				fahrzeugBearbeiten();
				}
		});
		
		
		// DefaultPanel als CenterPanel in itialisiert 
		this.centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		defaultInfoLabel = new JLabel();
		defaultInfoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		defaultInfoLabel.setText(LR.DEFAULTVALUES[languageType]);
		this.centerPanel.add(defaultInfoLabel);
		
	
		
		this.setLayout(new BorderLayout());
		contentPane = this.getContentPane();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, NORTHPANELSPALTENANZAHL));
		// erste Reihe
		for (int j = 0; j < NORTHPANELSPALTENANZAHL; j++) {
			northPanel.add(new JLabel());
		}
		
		// zweite Reihe
		northPanel.add(inputFgNr);
		northPanel.add(new JLabel());
		currentUserLabel = new JLabel(LR.AKTUELLERUSER[languageType], SwingConstants.RIGHT);
		northPanel.add(currentUserLabel);
		northPanel.add(new JLabel(currentUserAsString(currentUser)));
		northPanel.add(new JLabel());
		
		// Initialisierung des Language-Buttons
		Icon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File(BILDERPFAD[languageType])));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.languageButton = new JButton(LR.LANGUAGE[0][languageType] ,icon);
		languageButton.setToolTipText(LR.LANGUAGE[1][languageType]);
		languageButton.addActionListener(new ActionListener() {
			private int i = 1;

			@Override
			public void actionPerformed(final ActionEvent e) {
				changeLanguage(i);
				i++;
				}
		});
		
		
		northPanel.add(languageButton);
		
		// Initialisierung de Logout-Button Icon möglich
		this.logoutButton = new JButton("logout", null);
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logoutDialog(languageType);	
				}
		});

		northPanel.add(logoutButton);
		
		// dritte Reihe
		northPanel.add(okButton);
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		northPanel.add(new JLabel());
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(ROWSFOREASTPANEL, 1));
		westPanel.add(ausstattungsButton);
		westPanel.add(serviceEventsButton);
		westPanel.add(fahrzeugButton);
		westPanel.add(new JLabel());
		westPanel.add(new JLabel());
		westPanel.add(new JLabel());
		
		contentPane.add(westPanel, BorderLayout.WEST);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, southCols));
		// Admin mit manager-Rechten 
		if(currentUser.isManageUser()) {
			
			
			southPanel.add(new JLabel());
			southPanel.add(neuerUser);
			southPanel.add(userBearbeiten);
			southPanel.add(neuesFahrzeug);
			southPanel.add(fahrzeugBearbeiten);
			southPanel.add(new JLabel());
			
			contentPane.add(southPanel, BorderLayout.SOUTH);
			
			//ReaWrite-Access 
		} else if (currentUser.isWriteAccess()) {
						
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(neuesFahrzeug);
			southPanel.add(fahrzeugBearbeiten);
			southPanel.add(new JLabel());
			
			contentPane.add(southPanel, BorderLayout.SOUTH);
			
			// Write-Access
		} else if (currentUser.isReadAccess()) {
			
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			southPanel.add(new JLabel());
			
			contentPane.add(southPanel, BorderLayout.SOUTH);
		}
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
// ende Konstruktor		
	}
	
	
	
	private void showFahrzeugDetails() {
		CenterPanel fahrzeugData = new FahrzeugData(contentPane, centerPanel, languageType);
	}



	private void showServiceEvents() {
		
		CenterPanel serviceEvents = new ServiceEvent(contentPane, centerPanel, languageType);
		
	}



	private void showFahrzeugAusstatung() {
		// TODO 
		this.contentPane.remove(centerPanel);
		JPanel newJPanel = new JPanel();
		newJPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.contentPane.add(newJPanel);
		this.contentPane.revalidate();
	}



	// Sprache umstellen deutsch/englisch
	private void changeLanguage(int i) {
		this.languageType = i%2;
		this.setTitle(LR.APPLIKATIONSNAME[languageType]);
		try {
			this.languageButton.setIcon(new ImageIcon(ImageIO.read(new File(BILDERPFAD[languageType]))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.languageButton.setText(LR.LANGUAGE[0][languageType]);
		this.languageButton.setToolTipText(LR.LANGUAGE[1][languageType]);
		this.currentUserLabel.setText(LR.AKTUELLERUSER[languageType]);
		this.defaultInfoLabel.setText(LR.DEFAULTVALUES[languageType]);
		// Menü-Button linke Seite
		this.ausstattungsButton.setText(LR.AUSSTATTUNG[languageType]);
		this.fahrzeugButton.setText(LR.FAHRZEUG[0][languageType]);
		this.serviceEventsButton.setText(LR.SERVICEFAELLE[languageType]);
		// 6 Buttons nur für Admins
		this.neuerUser.setText(LR.NEUERUSER[0][languageType]);
		this.neuerUser.setToolTipText(LR.NEUERUSER[1][languageType]);
		this.userBearbeiten.setText(LR.USERBEARBEITEN[0][languageType]);
		this.userBearbeiten.setToolTipText(LR.USERBEARBEITEN[1][languageType]);
		this.neuesFahrzeug.setText(LR.NEUESFAHRZEUG[0][languageType]);
		this.neuesFahrzeug.setToolTipText(LR.NEUESFAHRZEUG[1][languageType]);
		this.fahrzeugBearbeiten.setText(LR.FAHRZEUGBEARBEITEN[0][languageType]);
		this.fahrzeugBearbeiten.setToolTipText(LR.FAHRZEUGBEARBEITEN[1][languageType]);
	}



	// fahrzeug suchen
	private void fahrzeugSuchen() {
		String fahrgestellnummer = inputFgNr.getText();
		if (StringUtils.isEmptyOrWhitespaceOnly(fahrgestellnummer)) {
		notifyUserInvalidParameter();	
		} else {
			
			if (true) {
				notifyUserEmptyResult(fahrgestellnummer);
			} else {
			// TODO
			this.contentPane.remove(centerPanel);
			JPanel newJPanel = new JPanel();
			newJPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			this.contentPane.add(newJPanel);
			this.contentPane.revalidate();
			}
		}
	}


	// Info zur ergebnislosen Suche
	private void notifyUserEmptyResult(String fahrgestellnummer) {
		String text = LR.MELDUNG[2][languageType] + fahrgestellnummer;
		JOptionPane.showMessageDialog(null, text, LR.MELDUNG[1][languageType], JOptionPane.ERROR_MESSAGE);
	}



	// Info zur ungültigen Eingabe
	private void notifyUserInvalidParameter() {
		 JOptionPane.showMessageDialog(null, LR.MELDUNG[0][languageType], LR.MELDUNG[1][languageType], JOptionPane.WARNING_MESSAGE);
	}



	// neuen User Anlegen
	private void neuerUserAnlegen(String pName, String pVorname, String pAnmeldeNamen, String pPasswort, String pGroupId) {
		
		JTextField name = new JTextField(pName);
		JTextField vorname = new JTextField(pVorname);
		JTextField anmeldeNamen = new JTextField(pAnmeldeNamen);
		JTextField passwort = new JTextField(pPasswort);
		String groupID = pGroupId;
		
		String[] userGroups = LR.USERGROUPS[languageType];
		Object[] message = {LR.NEUERUSER[2][languageType], name, 
							LR.NEUERUSER[3][languageType], vorname, 
							LR.NEUERUSER[4][languageType], anmeldeNamen, 
							LR.NEUERUSER[5][languageType], passwort,
							getHelpLabel(), 
							LR.NEUERUSER[6][languageType]};

		groupID = (String) JOptionPane.showInputDialog(null, message, LR.NEUERUSER[0][languageType],
				JOptionPane.WARNING_MESSAGE, null, userGroups, pGroupId);
	
		// Falls Vorgang nicht abgebrochen wird
		if (groupID != null) {
			String[] inputNewUser = {name.getText(), vorname.getText(), anmeldeNamen.getText(), passwort.getText(), groupID};
			if (newUserInputValid(inputNewUser)) {
				// TODO Methode zum Abspeichern des Neuen Users
				confirmationNewUser(inputNewUser);   // Datenhalter: inputNewUser
				System.out.println("Name " + inputNewUser[0] + " Vorname "+ inputNewUser[1] + "   " + inputNewUser[2] + "   " + inputNewUser[3]+  " Gruppe " + inputNewUser[4]);
				}
			}

		}
	
	private JLabel getHelpLabel() {
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
				provideInfos();
			}
		});
		return helpLabel;
	}



	// Bestätigung das ein neuer User angelegt wurde
	private void confirmationNewUser(String[] inputNewUser) {
		String bestaetigung = inputNewUser[1] + " " + inputNewUser[0] + LR.NEUERUSER[7][languageType] + inputNewUser[4];
		JOptionPane.showMessageDialog(null, bestaetigung, null, JOptionPane.INFORMATION_MESSAGE);
	}



	// Überprüfung ob alle * Felder befüllt
	private boolean newUserInputValid(String[] inputNewUser) {
		boolean invalid = true;
		for (int i = 0; i < inputNewUser.length; i++) {
			if (StringUtils.isEmptyOrWhitespaceOnly(inputNewUser[i])) {
				JOptionPane.showMessageDialog(null, LR.HILFE[0][languageType], LR.MELDUNG[1][languageType],
						JOptionPane.ERROR_MESSAGE);
				invalid = false;
				neuerUserAnlegen(inputNewUser[0], inputNewUser[1], inputNewUser[2], inputNewUser[3], inputNewUser[4]);
				break;
			}
		}
		return invalid;
	}



	// Info Box zu Gruppen
	private void provideInfos() {
		String dialogText = LR.HILFE[0][languageType]
				+ LR.HILFE[1][languageType] + LR.HILFE[2][languageType]
				+ LR.HILFE[3][languageType] + LR.HILFE[4][languageType];
		JOptionPane.showMessageDialog(null, dialogText, null, JOptionPane.INFORMATION_MESSAGE);
	}



	// User bearbeiten
	private void userBearbeiten() {
		//TODO 
		UserBearbeitenFrame userBearbeiten = new UserBearbeitenFrame(WIDTHFORUSERBEARBEITEN, HEIGHTFORUSERBEARBEITEN, languageType);
	}
	
	// neues Fahrzeug anlegen
	private void neuesFahrzeugAnlegen() {
		// TODO
		NFF frameNeu = new NFF(WIDTH, HEIGHT, languageType);
	}



	// Fahrzeug bearbeiten
	private void fahrzeugBearbeiten() {
		// TODO 
	}
	
	
	// Logout dialog methode
	private void logoutDialog(int l) {
		
		int showConfirmDialog = JOptionPane.showOptionDialog(null, LR.EXITDIALOG[0][l], LR.EXITDIALOG[1][l], JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, LR.YESNOOPTIONS[l], null);
		boolean dialog = true;
		if (showConfirmDialog == 0) {
			dialog = false;
		} else if (showConfirmDialog == 1){
			dialog = true;
		} else if (showConfirmDialog == 2) {
			dialog = true;
		}
		setVisible(dialog);
	}
	
	

	
	// Name und Vorname als String
	private String currentUserAsString(User currentUser) {
		
		String current = null;
		String vorname = currentUser.getVorname();
		String nachName = currentUser.getName();
		current = nachName + ", " + vorname;
		
		return current;
	}


	// setz das Fenster in die Bildschirmmitte
	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}

	






	
	
// ende Klasse
}
