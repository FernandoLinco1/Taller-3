package tallerPOO3;

import java.util.ArrayList;

public class SistemaImplement implements Sistema{
	//En estas listas se guardaran los datos con los que se trabajaran en todo el codigo, los Magos y los Hechizos.
	private ArrayList<Hechizo> listaHechizos;
	private ArrayList<Mago> listaMagos;
	//Para crear una clase Sistema se le debe dar 2 matrices de tipo String, los datos vienen de la lectura de los archivos Magos.txt y Hechizo.txt
	public SistemaImplement(ArrayList<ArrayList<String>> listaHechizos, ArrayList<ArrayList<String>> listaMagos) {
		//Se crea la clase TrasnformadorImplement para poder trnsformar las matrices de String en listas de objetos
		//esto se hace para trabajar de forma mas eficiente los datos ya que dependiedo de el tipo de Hechizo se tienen valores y ecuaciones diferentes.
		TrasnformadorImplement trans= new TrasnformadorImplement();
		this.listaHechizos = trans.transHechizo(listaHechizos);
		this.listaMagos = trans.transMago(listaMagos, this.listaHechizos);
	}
	//se crea una lista a partir de una comparacion entre los valores para saber cuales son los 10 mas fuertes.
	public ArrayList<Hechizo> top_10Hechizos(){
		 ArrayList<Hechizo> lista= new ArrayList<>();
		 ArrayList<Hechizo> top= new ArrayList<>();
			for(Hechizo hechizo: listaHechizos) {
				lista.add(hechizo);
			}
			for(int i=0;i<lista.size()-1;i++) {	
				for(int j=i+1;j<lista.size();j++) {
					if(lista.get(i).calcularPuntaje()<lista.get(j).calcularPuntaje()) {
						Hechizo aux= lista.get(i);
						lista.set(i, lista.get(j));
						lista.set(j, aux);
					}
				}
			}
			for(int k=0;k<10;k++) {
				top.add(lista.get(k));
			}
			return top;
		
	}
	//Se comparan todos los Magos y se guardan en una lista los 3 que tengan la suma de Hechizos mas poderosas.
	public ArrayList<Mago> top_3Magos(){
		ArrayList<Mago> lista= new ArrayList<>();
		 ArrayList<Mago> top= new ArrayList<>();
			for(Mago mago: listaMagos) {
				lista.add(mago);
			}
			for(int i=0;i<lista.size()-1;i++) {	
				for(int j=i+1;j<lista.size();j++) {
					if(lista.get(i).sumaPuntajeHechizo()<lista.get(j).sumaPuntajeHechizo()) {
						Mago aux= lista.get(i);
						lista.set(i, lista.get(j));
						lista.set(j, aux);
					}
				}
			}
			for(int k=0;k<3;k++) {
				top.add(lista.get(k));
			}
			return top;
	}
	//Se entrega la lista de Hechizos.
	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}
	//Se entrega la lista de Magos.
	public ArrayList<Mago> getListaMagos() {
		return listaMagos;
	}
	//Se agrega el nuevo Mago a la lista de Magos.
	public void addMago(String nombreMago) {
		listaMagos.add(new Mago(nombreMago, new ArrayList<>()));
	}
	//Se elimina el Mago que se encuentre en ese indice.
	public void borrarMago(int indiceBorrar) {
		listaMagos.remove(indiceBorrar);
	}
	//Se agrega el nuevo Hechizo a la lista de Hechizos.
	public void addHechizo(Hechizo hechizo) {
		listaHechizos.add(hechizo);
	}
	//Se elimina el Hechizo de la lista de Hechizos.
	public void borrarHechizo(int indiceBorrar) {
		listaHechizos.remove(indiceBorrar);
	}
	//Se modifica el nombre del Hechizo y se busca en la lista de cada Mago corregir el nombre.
	public void setNombreHechizo(int indiceModificar,String nombreHechizo) {
		String nombreAntiguo= listaHechizos.get(indiceModificar).getNombreHechizo();
		listaHechizos.get(indiceModificar).setNombreHechizo(nombreHechizo);
		for(int i=0;i<listaMagos.size();i++) {
			for(int j=0;j<listaMagos.get(i).getListaDeHechizos().size();j++) {
				if(nombreAntiguo.equals(listaMagos.get(i).getListaDeHechizos().get(j).getNombreHechizo())) {
					setNombreHechizoMago(j, i, nombreHechizo);
				}
			}
		}
	}
	//Se modifica el daño del Hechizo y se busca en la lista de cada Mago corregir el daño.
	public void setDañoHechizo(int indiceModificar,int nuevoDaño) {
		listaHechizos.get(indiceModificar).setDaño(nuevoDaño);
		for(int i=0;i<listaMagos.size();i++) {
			for(int j=0;j<listaMagos.get(i).getListaDeHechizos().size();j++) {
				if(listaHechizos.get(indiceModificar).getNombreHechizo().equals(listaMagos.get(i).getListaDeHechizos().get(j).getNombreHechizo())) {
					setDañoHechizoMago(j, i, nuevoDaño);
				}
			}
		}
	}
	//Se modifica el CaracteristicaEspecial1 del Hechizo y se busca en la lista de cada Mago corregir el CaracteristicaEspecial1.
	public void setCaracteristicaEspecial1(int indiceModificar,int valor) {
		listaHechizos.get(indiceModificar).setCaracteristicaEspecial1(valor);
		for(int i=0;i<listaMagos.size();i++) {
			for(int j=0;j<listaMagos.get(i).getListaDeHechizos().size();j++) {
				if(listaHechizos.get(indiceModificar).getNombreHechizo().equals(listaMagos.get(i).getListaDeHechizos().get(j).getNombreHechizo())) {
					setCaracteristicaEspecial1Mago(j, i, valor);
				}
			}
		}
	}
	//Se modifica el CaracteristicaEspecial2 del Hechizo y se busca en la lista de cada Mago corregir el CaracteristicaEspecial2.
	public void setCaracteristicaEspecial2(int indiceModificar,int valor) {
		listaHechizos.get(indiceModificar).setCaracteristicaEspecial2(valor);
		for(int i=0;i<listaMagos.size();i++) {
			for(int j=0;j<listaMagos.get(i).getListaDeHechizos().size();j++) {
				if(listaHechizos.get(indiceModificar).getNombreHechizo().equals(listaMagos.get(i).getListaDeHechizos().get(j).getNombreHechizo())) {
					setCaracteristicaEspecial2Mago(j, i, valor);
				}
			}
		}
	}
	//Se modifica el nombre del Mago en la lista.
	public void setNombreMago(int indiceModificarMago,String nombreMago) {
		listaMagos.get(indiceModificarMago).setNombre(nombreMago);
	}
	//Se le agrega un Hechizo a la lista del Mago.
	public void addHechizoMago(Hechizo hechizo,int indiceModificarMago) {
		listaMagos.get(indiceModificarMago).addListaDeEchizos(hechizo);
	}
	//Se borra un Hechizo de la lista del Mago.
	public void borrarHechizoMago(int indiceBorrar,int indiceModificarMago) {
		listaMagos.get(indiceModificarMago).remove(indiceBorrar);
	}
	//Estos metodos la utilizan los set de Hechizos para corregir los datos dentro de las listas de los Magos.
	public void setNombreHechizoMago(int indiceModificar,int indiceModificarMago,String nombreHechizo) {
		listaMagos.get(indiceModificarMago).getListaDeHechizos().get(indiceModificar).setNombreHechizo(nombreHechizo);
	}
	public void setDañoHechizoMago(int indiceModificar,int indiceModificarMago,int nuevoDaño) {
		listaMagos.get(indiceModificarMago).getListaDeHechizos().get(indiceModificar).setDaño(nuevoDaño);
	}
	public void setCaracteristicaEspecial1Mago(int indiceModificar,int indiceModificarMago,int valor) {
		listaMagos.get(indiceModificarMago).getListaDeHechizos().get(indiceModificar).setCaracteristicaEspecial1(valor);
	}
	public void setCaracteristicaEspecial2Mago(int indiceModificar,int indiceModificarMago,int valor) {
		listaMagos.get(indiceModificarMago).getListaDeHechizos().get(indiceModificar).setCaracteristicaEspecial2(valor);
	}
	}
