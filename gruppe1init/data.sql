USE `gruppe1` ;

-- -----------------------------------------------------
-- Insert Fahrzeugtypen
-- -----------------------------------------------------
INSERT INTO Fahrzeugtyp (typBezeichnung)
VALUES
--	( 'Anhänger' ),
	( 'Autokran' ),
	( 'Agrarfahrzeug' ),
	( 'Baumaschine' ),
	( 'Coupe' ),
	( 'Cabrio' ),
	( 'Chopper' ),
--	( 'Geländewagen' ),
	( 'Hybridfahrzeug' ),
	( 'Kastenwagen' ),
	( 'Kehrmaschine' ),
	( 'Kombi' ),
	( 'Kleinwagen' ),
	( 'Limousine' ),
	( 'LKW' ),
	( 'Mofa' ),
	( 'Motorrad' ),
--	( 'Mähdrescher' ),
	( 'Oldtimer' ),
	( 'Pickup' ),
	( 'Quad' ),
	( 'Roadster' ),
	( 'SUV' ),
	( 'Sattelzugmaschine' ),
	( 'Sportwagen' ),
	( 'Traktor' ),
	( 'Tieflader' ),
	( 'Transporter' ),
	( 'Van' ),
	( 'Wohnmobil' ),
	( 'Wohnwagen' );
	
-- -----------------------------------------------------
-- Insert Fahrzeugtypen
-- -----------------------------------------------------
INSERT INTO Fahrzeugmarke (bezeichnung)
VALUES
	( 'Audi' ),
	( 'BMW' ),
	( 'Opel' ),
	( 'Toyota' ),
	( 'Ferrari' ),
	( 'Trabant' ),
	( 'Alfa Romeo' ),
	( 'Chevrolet' ),
	( 'Dacia' ),
	( 'Daihatsu' ),
	( 'Dodge' ),
	( 'Fiat' ),
	( 'Ford' ),
	( 'Honda' ),
	( 'MAN' ),
	( 'Lada' ),
	( 'Land Rover' ),
	( 'Lexus' ),
	( 'Suzuki' ),
	( 'Mazda' ),
	( 'Mercedes' ),
	( 'Nissan' ),
	( 'Opel' ),
	( 'Skoda' ),
	( 'Porsche' ),
	( 'Volkswagen' ),
	( 'Volvo' ),
	( 'Toyota' ),
	( 'Subaru' );

-- -----------------------------------------------------
-- Insert Fahrzeugmodelle
-- -----------------------------------------------------
INSERT INTO Fahrzeugmodell ( Fahrzeugmarke_id,
                             Bezeichnung )
VALUES
    ( 1,
      'A1' ),
    ( 1,
      'A2' ),
    ( 1,
      'A3' ),
    ( 1,
      'a4' ),
    ( 1,
      'A5' ),
    ( 1,
      'A6' ),
    ( 2,
      '1er' ),
    ( 2,
      '2er' ),
    ( 2,
      '3er' ),
    ( 2,
      '4er' ),
    ( 2,
      '5er' ),
    ( 2,
      '6er' ),
    ( 2,
      '7er' ),
    ( 2,
      'X1' ),
    ( 2,
      'M5' ),
    ( 3,
      'Adam' ),
    ( 3,
      'Astra' ),
    ( 3,
      'Corsa' ),
    ( 3,
      'Insignia' ),
    ( 3,
      'Meriva' ),
    ( 3,
      'Vivaro' );
     
-- -----------------------------------------------------
-- Insert User groups
-- -----------------------------------------------------
INSERT INTO Usergroup ( groupBezeichnung,
						writeAccess,
						readAccess,
						manageUser )
VALUES
	( 'Admin',
	  true,
	  true,
	  true ),
	( 'Manager',
	  true,
	  true,
	  false ),
	( 'User',
	  false,
	  true,
	  false );

-- -----------------------------------------------------
-- Insert Users
-- -----------------------------------------------------
INSERT INTO User ( userName,
				   userPassword,
				   Name,
				   Vorname,
				   Usergroup_id )
VALUES
	( 'user',
	  SHA1( 'user' ),
	  'User_Name',
	  'User_Vorname',
	   3 ),	/* group User */
	 ( 'manager',
	   SHA1( 'manager' ),
	   'Manager_Name',
	   'Manager_Vorname',
	   2 ),	/* group Manager */
	 ( 'admin',
	   SHA1( 'admin' ),
	   'Admin_Name',
	   'Admin_Vorname',
	   1 );	/* Group admin */
	  
	   
-- -----------------------------------------------------
-- Insert Aufgaben
-- -----------------------------------------------------
INSERT INTO Aufgaben ( aufgabeBezeichnung )
VALUES
	( 'Kundendienst' ),
	( 'Ölwechsel' ),
	( 'Tanken' ),
	( 'Reifenwechsel' ),
	( 'Motortausch' );
	
	
-- -----------------------------------------------------
-- Insert Kunde
-- -----------------------------------------------------
INSERT INTO Ort ( ort )
VALUES ( 'München' );

INSERT INTO PLZ ( plz )
VALUES ( '81927' );

INSERT INTO Kunde ( Name,
					Vorname,
					Kunde_seit,
					Ort_id,
					PLZ_id )
VALUES
	( 'Mustermann',
	  'Max',
	  NOW(),
	  1,
	  1 ),
	( 'Kunde',
	  'Bester',
	  NOW(),
	  1,
	  1 );
	  

-- -----------------------------------------------------
-- Insert Fahrzeug
-- -----------------------------------------------------
/*
INSERT INTO Fahrzeug ( produktionsdatum,
					   Fahrzeugtyp_id,
					   fahrgestellNummer,
					   Kunde_id
					   Fahrzeugmarke_id )
VALUES ();
	*/
	  