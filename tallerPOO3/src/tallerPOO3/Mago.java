package tallerPOO3;

import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> listaDeEchizos;
	public Mago(String nombre, ArrayList<Hechizo> listaDeEchizos) {
		super();
		this.nombre = nombre;
		this.listaDeEchizos = listaDeEchizos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Hechizo> getListaDeEchizos() {
		return listaDeEchizos;
	}
	public void setListaDeEchizos(ArrayList<Hechizo> listaDeEchizos) {
		this.listaDeEchizos = listaDeEchizos;
	}
	
}
