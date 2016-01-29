package GUIFZAApp;

public class FahrzeugTypen {
	
	private int id;
	private String typBez;
	
	public FahrzeugTypen(int id, String typBez) {
		super();
		this.id = id;
		this.typBez = typBez;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTypBez() {
		return typBez;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return typBez;
	}
	
	

}
