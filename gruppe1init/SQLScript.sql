SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `gruppe1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gruppe1` ;

-- -----------------------------------------------------
-- Table `gruppe1`.`Usergroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Usergroup` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `groupBezeichnung` VARCHAR(45) NOT NULL,
  `writeAccess` TINYINT(1) NULL DEFAULT 0,
  `readAccess` TINYINT(1) NULL DEFAULT 0,
  `manageUser` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(255) NOT NULL,
  `userPassword` VARCHAR(255) NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Vorname` VARCHAR(255) NULL,
  `Usergroup_Id` INT NOT NULL,
  PRIMARY KEY (`id`, `Usergroup_Id`),
  INDEX `fk_Users_Usergroup_idx` (`Usergroup_Id` ASC),
  CONSTRAINT `fk_Users_Usergroup`
    FOREIGN KEY (`Usergroup_Id`)
    REFERENCES `gruppe1`.`Usergroup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Fahrzeugtyp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Fahrzeugtyp` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `typBezeichnung` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Ort`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Ort` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ort` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ort_UNIQUE` (`ort` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`PLZ`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`PLZ` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plz` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `plz_UNIQUE` (`plz` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Kunde`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Kunde` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Vorname` VARCHAR(255) NOT NULL,
  `Ort_id` INT NOT NULL,
  `PLZ_id` INT NOT NULL,
  `Firma` VARCHAR(255) NULL,
  `Straße` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `Ort_id`, `PLZ_id`),
  INDEX `fk_Kunde_Ort1_idx` (`Ort_id` ASC),
  INDEX `fk_Kunde_PLZ1_idx` (`PLZ_id` ASC),
  UNIQUE INDEX `kundenName` (`Name` ASC, `Vorname` ASC),
  CONSTRAINT `fk_Kunde_Ort1`
    FOREIGN KEY (`Ort_id`)
    REFERENCES `gruppe1`.`Ort` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Kunde_PLZ1`
    FOREIGN KEY (`PLZ_id`)
    REFERENCES `gruppe1`.`PLZ` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `gruppe1`.`Fahrzeugmarke`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Fahrzeugmarke` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bezeichnung` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `gruppe1`.`Fahrzeugmodell`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Fahrzeugmodell` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Fahrzeugmarke_id` INT NOT NULL,
  `Bezeichnung` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `Fahrzeugmarke_id`),
  INDEX `fk_Fahrzeugmodell_Fahrzeugmarke1_idx` (`Fahrzeugmarke_id` ASC),
  CONSTRAINT `fk_Fahrzeugmodell_Fahrzeugmarke1`
    FOREIGN KEY (`Fahrzeugmarke_id`)
    REFERENCES `gruppe1`.`Fahrzeugmarke` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Kraftstoff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Kraftstoff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Bezeichnung` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Fahrzeug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Fahrzeug` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produktionsdatum` VARCHAR(255) NULL,
  `Fahrzeugtyp_id` INT NOT NULL,
  `fahrgestellNummer` VARCHAR(255) NOT NULL,
  `Kunde_id` INT NOT NULL,
  `Fahrzeugmarke_id` INT NOT NULL,
  `Fahrzeugmodell_id` INT NOT NULL,
  `Kilometerstand` INT NULL,
  `Leistung_KW` INT NULL,
  `Kraftstoff_id` INT NOT NULL,
  `kennzeichen` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `Fahrzeugtyp_id`, `Kunde_id`, `Fahrzeugmarke_id`, `fahrgestellNummer`, `Fahrzeugmodell_id`, `Kraftstoff_id`),
  INDEX `fk_Fahrzeug_Fahrzeugtyp1_idx` (`Fahrzeugtyp_id` ASC),
  INDEX `fk_Fahrzeug_Kunde1_idx` (`Kunde_id` ASC),
  INDEX `fk_Fahrzeug_Fahrzeugmarke1_idx` (`Fahrzeugmarke_id` ASC),
  INDEX `fk_Fahrzeug_Fahrzeugmodell1_idx` (`Fahrzeugmodell_id` ASC),
  INDEX `fk_Fahrzeug_Kraftstoff1_idx` (`Kraftstoff_id` ASC),
  UNIQUE INDEX `kennzeichen_UNIQUE` (`kennzeichen` ASC),
  UNIQUE INDEX `fahrgestellNummer_UNIQUE` (`fahrgestellNummer` ASC),
  CONSTRAINT `fk_Fahrzeug_Fahrzeugtyp1`
    FOREIGN KEY (`Fahrzeugtyp_id`)
    REFERENCES `gruppe1`.`Fahrzeugtyp` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fahrzeug_Kunde1`
    FOREIGN KEY (`Kunde_id`)
    REFERENCES `gruppe1`.`Kunde` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fahrzeug_Fahrzeugmarke1`
    FOREIGN KEY (`Fahrzeugmarke_id`)
    REFERENCES `gruppe1`.`Fahrzeugmarke` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fahrzeug_Fahrzeugmodell1`
    FOREIGN KEY (`Fahrzeugmodell_id`)
    REFERENCES `gruppe1`.`Fahrzeugmodell` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fahrzeug_Kraftstoff1`
    FOREIGN KEY (`Kraftstoff_id`)
    REFERENCES `gruppe1`.`Kraftstoff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Aufgaben`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Aufgaben` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aufgabeBezeichnung` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Serviceevents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Serviceevents` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Fahrzeug_id` INT NOT NULL,
  `datum` DATETIME NULL,
  `Aufgaben_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Fahrzeug_id`, `Aufgaben_id`),
  INDEX `fk_Fahrzeug_has_Serviceevents_Fahrzeug1_idx` (`Fahrzeug_id` ASC),
  INDEX `fk_Serviceevents_Aufgaben1_idx` (`Aufgaben_id` ASC),
  CONSTRAINT `fk_Fahrzeug_has_Serviceevents_Fahrzeug1`
    FOREIGN KEY (`Fahrzeug_id`)
    REFERENCES `gruppe1`.`Fahrzeug` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Serviceevents_Aufgaben1`
    FOREIGN KEY (`Aufgaben_id`)
    REFERENCES `gruppe1`.`Aufgaben` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Komponenten`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Komponenten` (
  `id` INT NOT NULL,
  `komponentenBezeichnung` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gruppe1`.`Komponenten_has_Fahrzeug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`Komponenten_has_Fahrzeug` (
  `Komponenten_id` INT NOT NULL,
  `Fahrzeug_id` INT NOT NULL,
  PRIMARY KEY (`Komponenten_id`, `Fahrzeug_id`),
  INDEX `fk_Komponenten_has_Fahrzeug_Fahrzeug1_idx` (`Fahrzeug_id` ASC),
  INDEX `fk_Komponenten_has_Fahrzeug_Komponenten1_idx` (`Komponenten_id` ASC),
  CONSTRAINT `fk_Komponenten_has_Fahrzeug_Komponenten1`
    FOREIGN KEY (`Komponenten_id`)
    REFERENCES `gruppe1`.`Komponenten` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Komponenten_has_Fahrzeug_Fahrzeug1`
    FOREIGN KEY (`Fahrzeug_id`)
    REFERENCES `gruppe1`.`Fahrzeug` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `gruppe1` ;

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allVehicles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allVehicles` (`id` INT, `fahrgestellNummer` INT, `produktionsdatum` INT, `Kilometerstand` INT, `Leistung_KW` INT, `kennzeichen` INT, `Kraftstoff` INT, `Typ` INT, `Marke` INT, `Modell` INT, `Name` INT, `Vorname` INT, `Straße` INT, `plz` INT, `ort` INT, `firma` INT);

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allServiceevents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allServiceevents` (`id` INT, `datum` INT, `Fahrzeug_id` INT);

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allCustomers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allCustomers` (`id` INT, `Name` INT, `Vorname` INT, `ort` INT, `plz` INT, `Straße` INT, `Firma` INT);

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allVehicleTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allVehicleTypes` (`id` INT, `typBezeichnung` INT);

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allVehicleBrands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allVehicleBrands` (`id` INT, `bezeichnung` INT);

-- -----------------------------------------------------
-- Placeholder table for view `gruppe1`.`allUsergroups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gruppe1`.`allUsergroups` (`id` INT, `groupBezeichnung` INT);

-- -----------------------------------------------------
-- procedure checkLoginData
-- -----------------------------------------------------

CREATE PROCEDURE checkLoginData
(IN inUserName varchar(255),
 IN inUserPassword varchar(255) )
BEGIN
	SELECT COUNT(*), u.Name, u.Vorname, ug.writeAccess, ug.readAccess, ug.manageUser
	FROM User u
	INNER JOIN Usergroup ug
	ON u.Usergroup_id = ug.id
	WHERE u.userName = inUserName AND u.userPassword = SHA1(inUserPassword);
END;

-- -----------------------------------------------------
-- procedure getModelsToBrand
-- -----------------------------------------------------

CREATE PROCEDURE getModelsToBrand
(IN inFahrzeugmarke int)
BEGIN
	SELECT *
	FROM Fahrzeugmodell
	WHERE Fahrzeugmarke_id = id;
END ;

-- -----------------------------------------------------
-- procedure addUser
-- -----------------------------------------------------

CREATE PROCEDURE `addUser`
(IN inUserName varchar(255),
 IN inUserPassword varchar(255),
 IN inName varchar(255),
 IN inVorname varchar(255),
 IN inUsergroupId int)
BEGIN
	INSERT INTO User (userName, userPassword, Name, Vorname, Usergroup_Id)
	VALUES (inUserName, SHA1(inUserPassword), inName, inVorname, inUsergroupId);

END;

-- -----------------------------------------------------
-- procedure getVehicleData
-- -----------------------------------------------------

CREATE PROCEDURE getVehicleData
(IN inFahrgestellNummer varchar(255))
BEGIN
	SELECT f.id,
			f.fahrgestellNummer,
			f.produktionsdatum,
			f.Kilometerstand,
			f.Leistung_KW,
			ks.Bezeichnung AS Kraftstoff,
			ft.typBezeichnung AS Typ,
			fm.bezeichnung AS Marke,
			fmod.bezeichnung AS Modell,
			k.Name,
			k.Vorname,
			k.Straße,
			p.plz,
			o.ort,
			k.firma
	FROM Fahrzeug f
	INNER JOIN Fahrzeugtyp ft
	ON f.Fahrzeugtyp_id = ft.id
	INNER JOIN Fahrzeugmarke fm
	ON f.Fahrzeugmarke_id = fm.id
	INNER JOIN Fahrzeugmodell fmod
	ON f.Fahrzeugmodell_id = fmod.id
	INNER JOIN Kunde k
	ON f.Kunde_id = k.id
	INNER JOIN Ort o
	ON k.Ort_id = o.id
	INNER JOIN PLZ p
	ON k.PLZ_id = p.id
	INNER JOIN Kraftstoff ks
	ON f.Kraftstoff_id = ks.id
	WHERE f.fahrgestellNummer = inFahrgestellNummer;
END;

-- -----------------------------------------------------
-- procedure addVehicle
-- -----------------------------------------------------

CREATE PROCEDURE `addVehicle`
(IN inProdDatum varchar(255),
 IN inTyp int,
 IN inFahrgestellNummer varchar(255),
 IN inKundeId int,
 IN inMarke int,
 IN inModell int,
 in inKmStand int,
 in inLeistungKW int,
 in inKraftstoff int,
 in inKennzeichen varchar(255))
BEGIN
    INSERT INTO Fahrzeug ( produktionsdatum,
						   Fahrzeugtyp_id,
						   fahrgestellNummer, 
						   Kunde_id,
						   Fahrzeugmarke_id,
						   Fahrzeugmodell_id,
						   Kilometerstand,
						   Leistung_KW,
						   Kraftstoff_id,
						   kennzeichen )
	VALUES( inProdDatum,
			inTyp,
			inFahrgestellNummer,
		    inKundeId,
			inMarke,
			inModell,
			inKmStand,
			inLeistungKW,
			inKraftstoff,
			inKennzeichen );

END;

-- -----------------------------------------------------
-- procedure addCustomer
-- -----------------------------------------------------

CREATE PROCEDURE `addCustomer`
(IN inName varchar(255),
 IN inVorname varchar(255),
 IN inOrt varchar(255),
 IN inPLZ varchar(5),
 IN inAddress varchar(255),
 IN inFirma varchar(255) )
BEGIN

	INSERT IGNORE INTO Ort (ort)
	VALUES (inOrt);

	INSERT IGNORE INTO PLZ (plz)
	VALUES (inPLZ);

	SET @plz_id = ( SELECT p.id FROM PLZ p WHERE p.plz=inPLZ );
	SET @ort_id = ( SELECT o.id FROM Ort o WHERE o.ort=inOrt );

	INSERT INTO Kunde (Name,
					   Vorname,
					   Ort_id,
					   PLZ_id,
					   Firma,
					   Straße )
	VALUES( inName,
			inVorname,
			@ort_id,
			@plz_id,
			inFirma,
			inAddress );

END;

-- -----------------------------------------------------
-- View `gruppe1`.`allVehicles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allVehicles`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allVehicles` AS
SELECT f.id,
		f.fahrgestellNummer,
		f.produktionsdatum,
		f.Kilometerstand,
		f.Leistung_KW,
		f.kennzeichen,
		ks.Bezeichnung AS Kraftstoff,
		ft.typBezeichnung AS Typ,
		fm.bezeichnung AS Marke,
		fmod.bezeichnung AS Modell,
		k.Name,
		k.Vorname,
		k.Straße,
		p.plz,
		o.ort,
		k.firma
FROM Fahrzeug f
INNER JOIN Fahrzeugtyp ft
ON f.Fahrzeugtyp_id = ft.id
INNER JOIN Fahrzeugmarke fm
ON f.Fahrzeugmarke_id = fm.id
INNER JOIN Fahrzeugmodell fmod
ON f.Fahrzeugmodell_id = fmod.id
INNER JOIN Kunde k
ON f.Kunde_id = k.id
INNER JOIN Ort o
ON k.Ort_id = o.id
INNER JOIN PLZ p
ON k.PLZ_id = p.id
INNER JOIN Kraftstoff ks
ON f.Kraftstoff_id = ks.id;

-- -----------------------------------------------------
-- View `gruppe1`.`allServiceevents`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allServiceevents`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allServiceevents` AS
SELECT id, datum, Fahrzeug_id
FROM Serviceevents;

-- -----------------------------------------------------
-- View `gruppe1`.`allCustomers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allCustomers`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allCustomers` AS
SELECT k.id, k.Name, k.Vorname, o.ort, p.plz, k.Straße, k.Firma
FROM Kunde k
INNER JOIN Ort o
ON o.id = k.Ort_id
INNER JOIN PLZ p
ON p.id = k.PLZ_id;

-- -----------------------------------------------------
-- View `gruppe1`.`allVehicleTypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allVehicleTypes`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allVehicleTypes` AS
SELECT *
FROM Fahrzeugtyp;

-- -----------------------------------------------------
-- View `gruppe1`.`allVehicleBrands`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allVehicleBrands`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allVehicleBrands` AS
SELECT *
FROM Fahrzeugmarke;

-- -----------------------------------------------------
-- View `gruppe1`.`allUsergroups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gruppe1`.`allUsergroups`;
USE `gruppe1`;
CREATE  OR REPLACE VIEW `allUsergroups` AS
SELECT id, groupBezeichnung
FROM Usergroup;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
