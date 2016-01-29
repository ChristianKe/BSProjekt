package GUILoggin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import FZAControl.LogginControl;
import FZAControl.User;
import GUIFZAApp.FZAFrame;

public class FZALogin extends JFrame{

	private JTextField loginName;
	private JTextField loginPassword;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel picLabel;
	private JButton okButton;
	
	
	
	public FZALogin() throws HeadlessException {
		super();
		this.setSize(500, 400);
		centerFrame();
		this.setResizable(false); // nicht vergrößerbar
		this.setTitle("Elektronische Fahrzeugakte");
		
		// initialisiert
		this.loginName = new JTextField();
		this.loginPassword = new JPasswordField();
		
		this.okButton = new JButton("OK");
		
		this.label1 = new JLabel("Logginname:", SwingConstants.CENTER);
		this.label2 = new JLabel("Passwort:", SwingConstants.CENTER);
		this.label3 = new JLabel("Willkomen bei der elektronischen Fahrzeugakte", SwingConstants.CENTER);
		this.label3.setFont(new Font("Arial", Font.BOLD, 16));
		
		// editierbar
		this.loginName.setEditable(true);
		this.loginPassword.setEditable(true);
		
		
		
		this.setLayout(new BorderLayout());
		Container contentPane = this.getContentPane();
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(new JLabel());
		northPanel.add(label3);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(label1);
		
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(4, 4));
		// erste Zeile
		southPanel.add(new JLabel());
		southPanel.add(label1);
		southPanel.add(loginName);
		southPanel.add(new JLabel());
		
		// zweite Zeile
		southPanel.add(new JLabel());
		southPanel.add(label2);
		southPanel.add(loginPassword);
		southPanel.add(new JLabel());
		
		// dritte Zeile
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(okButton);
		southPanel.add(new JLabel());
		
		// vierte Zeile 
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		southPanel.add(new JLabel());
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("src\\PicRessources\\index.jpg"));
			picLabel = new JLabel(new ImageIcon(myPicture));
			contentPane.add(picLabel , BorderLayout.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		// okButton beim ActionListener
		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

//				String nameAnmeldung = loginName.getText();
//				String passwortAnmelde = loginPassword.getText();
				
				String nameAnmeldung = "admin";
				String passwortAnmelde = "admin";
				
				boolean anmelden = LogginControl.login(nameAnmeldung, passwortAnmelde);
				if (anmelden) {
					User currentUser = LogginControl.getCurrentUser();
					FZAFrame fzaFrame = new FZAFrame(currentUser);
					closeFZALogin();
				} else {
					JOptionPane.showMessageDialog(null, "Name und Passwort nicht korrekt", null, JOptionPane.ERROR_MESSAGE);
					clearTextfield();
				}
			}

			private void clearTextfield() {
				loginName.setText("");
				loginPassword.setText("");
			}

			private void closeFZALogin() {
				setVisible(false);
				dispose();
			}
		});
		
		
        
		
// ende Konstruktor
	}

	
	
	// setz das Logginfenster in die Bildschirmmitte
	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}

	
	
	public String getAnmeldeName() {
		return this.loginName.getText();
	}

	public String getAnmeldepasswort() {
		return this.loginPassword.getText();
	}

	

	
	
	

	
// ende Klasse
}
