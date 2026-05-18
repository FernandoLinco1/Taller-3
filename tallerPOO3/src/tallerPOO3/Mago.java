package tallerPOO3;

import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> listaDeHechizos;
	public Mago(String nombre, ArrayList<Hechizo> listaDeHechizos) {
		super();
		this.nombre = nombre;
		this.listaDeHechizos = listaDeHechizos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Hechizo> getListaDeEchizos() {
		return listaDeHechizos;
	}
	public void setListaDeEchizos(ArrayList<Hechizo> listaDeEchizos) {
		this.listaDeHechizos = listaDeEchizos;
	}
	public int sumaPuntajeHechizo() {
		int total=0;
		for(Hechizo hechizo:listaDeHechizos) {
			total+= hechizo.calcularPuntaje();
		}
		return total;
	}
	
}
