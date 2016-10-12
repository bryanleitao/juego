package modelo;

public enum Tipo {
	SUPERHEROE ("SUPERHEROE"),
	VILLANO ("VILLANO");
	
	private String descripcion;

	private Tipo(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
