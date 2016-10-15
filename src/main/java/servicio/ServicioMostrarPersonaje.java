package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map.Entry;

import dao.DaoPersonaje;
import modelo.Personaje;
import modelo.Tipo;

public class ServicioMostrarPersonaje implements IServicioMostrarPersonaje{
	
	private List<Personaje> personajes;
	
	private DaoPersonaje DP = new DaoPersonaje();
	
	public ServicioMostrarPersonaje(){
		personajes = DP.TraerPersonajes();
	}
	
	public void Listar() {
		for(Personaje p: DP.TraerPersonajes()){
			System.out.println(p.getNombre() + " :" + p.getTipo());
			
			Iterator<Entry<String, Integer>> it = p.getCualidades().entrySet().iterator();
			Entry<String, Integer> cualidades;
			while (it.hasNext()) {
				cualidades = it.next();
				System.out.println("\t " + cualidades.getKey() + " - : " + cualidades.getValue());
			}
		}
	}

	public void Listar(Tipo value) {
		for(Personaje p: DP.TraerPersonajes()){
			if(p.getTipo() == value){
				System.out.println(p.getNombre() + " :" + p.getTipo());
				
				Iterator<Entry<String, Integer>> it = p.getCualidades().entrySet().iterator();
				Entry<String, Integer> cualidades;
				while (it.hasNext()) {
					cualidades = it.next();
					System.out.println("\t " + cualidades.getKey() + " - : " + cualidades.getValue());
				}
			}
			
		}
	}
	
	//traigo el personaje q busco por nombre q le paso por parametro
	public Personaje TraerPersonaje(String nombre){
		return DP.TraerPersonaje(nombre);
	}
	
	//paso por parametro el objeto personaje y lo muestro: nombre, tipo y cualidades
	public void MostrarPersonaje(Personaje p){
		System.out.println(p.getNombre() + " :" + p.getTipo());
		
		Iterator<Entry<String, Integer>> it = p.getCualidades().entrySet().iterator();
		Entry<String, Integer> cualidades;
		while (it.hasNext()) {
			cualidades = it.next();
			System.out.println("\t " + cualidades.getKey() + " - : " + cualidades.getValue());
		}
	}

	public void Crear(Personaje personaje) {
		
		DP.AgregarPersonaje(personaje);
	}

}
