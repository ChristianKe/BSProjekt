package FZAControl;


public class User {
	
	private int id;
	private String name;
	private String vorname;
	private String anmeldeNamen;	
	private boolean writeAccess;
	private boolean readAccess;
	private boolean manageUser;

	public User(String name, String vorname, String anmeldeNamen, boolean writeAccess, boolean readAccess, boolean manageUser ) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.anmeldeNamen = anmeldeNamen;
		this.writeAccess = writeAccess;
		this.readAccess = readAccess;
		this.manageUser = manageUser;
	}



	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}


	public String getAnmeldeNamen() {
		return anmeldeNamen;
	}

	public int getId() {
		return id;
	}



	public boolean isWriteAccess() {
		return writeAccess;
	}



	public void setWriteAccess(boolean writeAccess) {
		this.writeAccess = writeAccess;
	}



	public boolean isReadAccess() {
		return readAccess;
	}



	public void setReadAccess(boolean readAccess) {
		this.readAccess = readAccess;
	}



	public boolean isManageUser() {
		return manageUser;
	}



	public void setManageUser(boolean manageUser) {
		this.manageUser = manageUser;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setVorname(String vorname) {
		this.vorname = vorname;
	}



	public void setAnmeldeNamen(String anmeldeNamen) {
		this.anmeldeNamen = anmeldeNamen;
	}





	
	

}
