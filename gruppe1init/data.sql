USE `gruppe1` ;
SET FOREIGN_KEY_CHECKS = 0;
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
-- Insert Kraftstoff
-- -----------------------------------------------------
INSERT INTO Kraftstoff ( Bezeichnung )
VALUES ( 'Benzin' ),
       ( 'Diesesl' ),
       ( 'Gas' ),
       ( 'Strom' );
         
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
CALL addUser( 'user',
              'user',
              'Name',
              'Vorname',
              3 );  /* group User */
              
CALL addUser( 'manager',
              'manager',
              'Name',
              'Vorname',
              2 );  /* group Manager */
             
CALL addUser( 'admin',
              'admin',
              'Name',
              'Vorname',
              1 );  /* group admin */
	  
	   
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

CALL addCustomer( 'Mustermann',
		          'Max',
		          'Muenchenn',
		          '81927',
		          'Musterstraße 32',
		          'BS GmbH' );
		         
CALL addCustomer( 'Mustermann',
                  'Max der II',
                  'Muenchen',
                  '81927',
                  'Musterstraße 32',
                  'XY AG' );
         
CALL addCustomer( 'Musterfrau',
		          'Angelika',
		          'Garching-Hochbrueck',
		          '12345',
		          'Weststraße 3',
		          '' );

-- -----------------------------------------------------
-- Insert Fahrzeug
-- -----------------------------------------------------
CALL addVehicle( '2013',
                 12,
                 '862da47ee51',
                 1,
                 1,
                 3,
                 132503,
                 80,
                 1,
                 'M-AF23');
                 
CALL addVehicle( '2015',
                 4,
                 '45de8f6f00h',
                 2,
                 2,
                 10,
                 21500,
                 120,
                 2,
                 'Y-YJ20');
	  
CALL addVehicle( '2002',
                 11,
                 '45de8a6f00h',
                 3,
                 3,
                 18,
                 180321,
                 75,
                 1,
                 'M-AB12');