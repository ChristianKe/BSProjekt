package GUIFZAApp;

public class LR {
	
	// Deutsch/Englisch Texte
	protected static final String[][] LANGUAGE = {{"Englisch", "Deutsch"}, {"Change to english", "Zu Deutsch wechseln"}};
	protected static final String[] AUSSTATTUNG = {"Ausstattung", "Equipment"};
	protected static final String[][] EXITDIALOG = {{"Möchten Sie die Anwendung beenden?", "Do you want to exit?"}, {"Abmelden", "sign off"}};
	protected static final String[] APPLIKATIONSNAME = {"Elektronische Fahrzeugakte", "Electronic Vehicle Record"};
	protected static final String[] AKTUELLERUSER =  {"Aktueller User:  ", "Current user: "};
	protected static final String[][] FAHRZEUG = {{"Fahrzeug", "Vehicle"}, {"Marke:* ", "Car brand:* "},
												  {"Baujahr:* ", "Year of construction:* "}, 
												  {"Model:* ", "Model:* "}, {"Typ:* ", "Type:* "}, 
												  {" Fahrgestellnummer*: ", " VIN*: "}, 
												  {" Leistung[KW]:* ", " Engine power[KW]:* "},
												  {"Kilometerstand[KM]:* ", "Mileage[KM]:* "},
												  {"Amtliches Kennzeichen:*", "Car registration number:*"}};
	protected static final String[] SERVICEFAELLE = {"  Service Fälle  ", "Service Events"};
	protected static final String[][] NEUERUSER = {{"Neuer User", "New user"}, {"Neuer User anlegen", "Create new user"}, 
												   {"Name:*", "surname:*"}, {"Vorname:*", "name:*"} ,
												   {"Anmeldenamen:*", "login name:*"}, {"Passwort:*", "password:*"}, 
												   {"User-Gruppe:*", "user group:*"}, {" wurde hinzugefügt zur Gruppe: ", " was added to group: "}};
	protected static final String[][] USERBEARBEITEN = {{"User bearbeiten", "Edit user"}, {"Existierenden User bearbeiten", "Edit existing user"},
													{"Altes Passwort:*", "old password:*"}, {"Neues Passwort:*", "new password:*"}, {"speichern", "save"}, {" wurde geändert", "was changed"}};
	protected static final String[][] NEUESFAHRZEUG = {{"Neues Fahrzeug", "New vehicle"}, {"Neues Fahrzeug anlegen", "Create new vehicle"}, {"Anlegen", "Save"}};
	protected static final String[][] FAHRZEUGBEARBEITEN = {{"Fahrzeug bearbeiten", "Edit vehicle"}, {"Existierendes Fahrzeug bearbeiten", "Edit existing vehicle"}};
	protected static final String[][] YESNOOPTIONS = {{"Ja", "Nein"}, {"Yes", "No"}};
	protected static final String[][] MELDUNG = {{"Ungültige Fahrgestellnummer!", "Invalid VIN!"}, {"Achtung!", "Attention!"}, {"Kein Fahrzeug gefunden zu:\n", "No results available for:\n"}, {"Fahrzeug angelegt", "Vehicle successfully created"}, {"Fahrzeug bereits vorhanden", "Vehicle already exits"}};
	protected static final String[][] DEFAULTVALUES = {{"Keine Fahrzeugdaten geladen", "No vehicle data loaded"}, {"Daten geladen", "Data load"}};
	protected static final String[][] HILFE = {{"Mit * markierte Felder sind Pflichtfelder.\n", "Fields marked with an asterisk* are obligatory.\n"},
				{"Die Benutzer-Gruppen sind:\n", "User groups:\n"}, 
				{"Gruppe1: Lesen.\n", "Group1: read.\n"}, 
				{"Gruppe2: Lesen, Schreiben.\n", "Group2: read, write.\n"}, 
				{"Gruppe3: Lesen, Schreiben und Benutzer verwalten.\n", "Group3: read, write and user management.\n"},
				{"Für weitere Informationen auf das Icon klicken!.\n", "Click here for further information.\n"}};
	protected static final String[][] USERGROUPS = {{"", "User", "Manager", "Admin"}, {"", "User", "Manager", "Admin"}};	
	protected static final String[][] KUNDE = {{"Kunde", "Customer"}, {"Name:*", "Surname:*"}, {"Vorname:*", "Name:*"}, {"Firma: ", "Company: "}, {"Adresse:* ", "Address:* "}, {"PLZ:* ", "Postcode:* "}, {"Ort:* ", "Place:* "}};
	
	protected static final String[][] SERVICE = {{"Datum", "Date"}, {"betr. Komponeneten", "affected parts"}, {"Mitarbeiter", "employee"}};
	protected static final String[][] FAHRZEUGANZEIGE = {{"Marke:", "Car brand:"},{"Baujahr:", "Year of construction:"}, {"Typ:", "Type:"},
														{"Kilometerstand[KM]:", "Mileage[KM]:"}, {"Leistung[KW]:", "Engine power[KW]:"}, 
														{"Kraftstoff:", "Fuel:"}, {"Model:", "Model:"}, {"Fahrgestellnummer:", "VIN:"},
														{"Amtliches Kennzeichen:", "Car registration number:"}, {"Name des Kunden:", "Customers surname:"}, 
														{"Vorname", "Customers name:"}, {"Firmenadresse:", "Company's address:"}, {"PLZ:", "Postcode:"}, {"Ort:", "Place:"}}; 
	
}
