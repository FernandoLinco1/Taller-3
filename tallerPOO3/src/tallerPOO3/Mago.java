package tallerPOO3;

import java.util.ArrayList;

public class Mago {
	
	private String nombre;
	private ArrayList<Hechizo> listaDeHechizos;
	
	public Mago(String nombre, ArrayList<Hechizo> listaDeHechizos) {
		this.nombre = nombre;
		this.listaDeHechizos = listaDeHechizos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Hechizo> getListaDeHechizos() {
		return listaDeHechizos;
	}
	public void setListaDeEchizos(ArrayList<Hechizo> listaDeEchizos) {
		this.listaDeHechizos = listaDeEchizos;
	}
	public void addListaDeEchizos(Hechizo Hechizo) {
		this.listaDeHechizos.add(Hechizo);
	}
	public void remove(int indiceBorrar) {
		listaDeHechizos.remove(indiceBorrar);
	}
	public int sumaPuntajeHechizo() {
		int total=0;
		for(Hechizo hechizo:listaDeHechizos) {
			total+= hechizo.calcularPuntaje();
		}
		return total;
	}
	
}
