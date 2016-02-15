package GUIFZAApp;

public class Fahrzeug
{
	private int     mId;
    private String  mFahrgestellnummer;
    private String  mProduktionsdatum;
    private int     mKilometerstand;
    private int     mLeistung;
    private String  mKennzeichen;
    private String  mKraftstoff;
    private String  mTyp;
    private String  mMarke;
    private String  mModell;
    private String  mKundenName;
    private String  mKundenVorname;
    private String  mKundenStreet;
    private String  mKundenPLZ;
    private String  mKundenOrt;
    private String  mKundenFirma;
    
    
    public Fahrzeug(int Id ,String fahrgestellnummer,
                     String produktionsdatum,
                     int kilometerstand,
                     int leistung,
                     String kennzeichen,
                     String kraftstoff,
                     String typ,
                     String marke,
                     String modell,
                     String kundenName,
                     String kundenVorname,
                     String kundenStreet,
                     String kundenPLZ,
                     String kundenOrt,
                     String kundenFirma )
    {
        
        mFahrgestellnummer = fahrgestellnummer;
        mProduktionsdatum = produktionsdatum;
        mKilometerstand = kilometerstand;
        mLeistung = leistung;
        mKennzeichen = kennzeichen;
        mKraftstoff = kraftstoff;
        mTyp = typ;
        mMarke = marke;
        mModell = modell;
        mKundenName = kundenName;
        mKundenVorname = kundenVorname;
        mKundenStreet = kundenStreet;
        mKundenPLZ = kundenPLZ;
        mKundenOrt = kundenOrt;
        mKundenFirma = kundenFirma;
    }


    public String getmFahrgestellnummer() {
        return mFahrgestellnummer;
    }


    public String getmProduktionsdatum() {
        return mProduktionsdatum;
    }


    public int getmKilometerstand() {
        return mKilometerstand;
    }


    public int getmLeistung() {
        return mLeistung;
    }


    public String getmKennzeichen() {
        return mKennzeichen;
    }


    public String getmKraftstoff() {
        return mKraftstoff;
    }


    public String getmTyp() {
        return mTyp;
    }


    public String getmMarke() {
        return mMarke;
    }


    public String getmModell() {
        return mModell;
    }


    public String getmKundenName() {
        return mKundenName;
    }


    public String getmKundenVorname() {
        return mKundenVorname;
    }


    public String getmKundenStreet() {
        return mKundenStreet;
    }


    public String getmKundenPLZ() {
        return mKundenPLZ;
    }


    public String getmKundenOrt() {
        return mKundenOrt;
    }


    public String getmKundenFirma() {
        return mKundenFirma;
    }

	
	

}
