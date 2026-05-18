package tallerPOO3;

import java.util.ArrayList;

public class SistemaImplement {
	ArrayList<Hechizo> listaHechizos;
	ArrayList<Mago> listaMagos;
	public SistemaImplement(ArrayList<ArrayList<String>> listaHechizos, ArrayList<ArrayList<String>> listaMagos) {
		TrasnformadorImplement trans= new TrasnformadorImplement();
		this.listaHechizos = trans.transHechizo(listaHechizos);
		this.listaMagos = trans.transMago(listaMagos, this.listaHechizos);
	}
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
	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}
	public ArrayList<Mago> getListaMagos() {
		return listaMagos;
	}
	
	}
