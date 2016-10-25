package modelo;

/**
 * Esta clase define un enum. Para distinguir los personajes segun el tipo, ya sean SUPERHEROES o VILLANOS.
 * @author Bryan
 */

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
