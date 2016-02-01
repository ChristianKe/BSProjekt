package FZAControl;

/*
 * User. 
 */
public class User {
	
	private String	name;
	private String	vorname;
	private String	anmeldeNamen;	
	private boolean	writeAccess;
	private boolean readAccess;
	private boolean manageUser;

	/*
	 * create new user with data
	 */
	public User( String name,
			     String vorname,
			     String anmeldeNamen,
			     boolean writeAccess,
			     boolean readAccess,
			     boolean manageUser ) {
		this.name = name;
		this.vorname = vorname;
		this.anmeldeNamen = anmeldeNamen;
		this.writeAccess = writeAccess;
		this.readAccess = readAccess;
		this.manageUser = manageUser;
	}

	/***************************************************************************
	 * getter functions
	 **************************************************************************/
	// user name
	public String getName() {
		return name;
	}

	// user vorname
	public String getVorname() {
		return vorname;
	}

	// anmeldename
	public String getAnmeldeNamen() {
		return anmeldeNamen;
	}

	// write access
	public boolean isWriteAccess() {
		return writeAccess;
	}

	// read access
	public boolean isReadAccess() {
		return readAccess;
	}

	// manage users
	public boolean isManageUser() {
		return manageUser;
	}

// TODO ???
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setVorname(String vorname) {
//		this.vorname = vorname;
//	}
//	public void setAnmeldeNamen(String anmeldeNamen) {
//		this.anmeldeNamen = anmeldeNamen;
//	}
//	public void setWriteAccess(boolean writeAccess) {
//		this.writeAccess = writeAccess;
//	}
//	public void setReadAccess(boolean readAccess) {
//		this.readAccess = readAccess;
//	}
//	public void setManageUser(boolean manageUser) {
//		this.manageUser = manageUser;
//	}
}
