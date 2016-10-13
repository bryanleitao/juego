package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Tipo;

public class Personaje {
	//atributos
	private String nombre;
	private Tipo tipo;
	
	/*corroborar si esta bien declarado, 
	lo copie de otros codigos, pero ni idea si funciona asi*/	
	private Map<String,Integer> cualidades = new HashMap<String, Integer>();
	
	public Personaje(String nombre,Tipo tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	
	//metodos
	
	public void agregarCualidad(String nombre, Integer stat){
		cualidades.put(nombre, stat);
	}
	public void modificarCualidad(String nombre, Integer stat){
		cualidades.put(nombre, stat);
	}
	public void eliminarCualidad(String nombre) {
		if (cualidades.containsKey(nombre)) {
			cualidades.remove(nombre);
		}
		else {
			System.out.println("No existe la cualidad: " + nombre);
		}
	}

	//propiedades
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Map<String,Integer> getCualidades() {
		return cualidades;
	}
	public void setCualidades(Map<String,Integer> cualidades) {
		this.cualidades = cualidades;
	}
	

}
