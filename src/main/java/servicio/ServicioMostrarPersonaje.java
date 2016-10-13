package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import dao.DaoPersonaje;
import modelo.Personaje;
import modelo.Tipo;

public class ServicioMostrarPersonaje implements IServicioMostrarPersonaje{
	
	private ArrayList<Personaje> personajes;
	
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

	/*Iterator<Entry<Long, Double>> it = productos.entrySet().iterator();
	Entry<Long, Double> producto;
	while (it.hasNext()) {
		producto = it.next();
		System.out.println("Producto: " + producto.getKey() 
				+ " - Precio: " + producto.getValue());
	}
	*/
	public void Listar(Tipo value) {
		// TODO Auto-generated method stub
		
	}

	public void Crear(Personaje personaje) {
		
		DP.AgregarPersonaje(personaje);
	}

}
