package modelo;

public enum Type {
	SUPERHEROE ("SUPERHEROE"),
	VILLANO ("VILLANO");

	private String description;

	private Type(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
