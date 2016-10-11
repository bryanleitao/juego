package modelo;

public enum Tipo {
	HEROE ("HEROE"),
	VILLANO ("VILLANO");
	
	private String descripcion;

	private Tipo(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
