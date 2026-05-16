package tallerPOO3;

import java.util.ArrayList;

public class TrasnformadorImplement {

	public ArrayList<Hechizo> transHechizo(ArrayList<ArrayList<String>> matriz){
		ArrayList<Hechizo> listaHechizo= new ArrayList<>();
		for(ArrayList<String> lista: matriz) {
			if(lista.get(1).equals("Fuego")) {
				listaHechizo.add(new HechizoTipoFuego(lista.get(0) , lista.get(1),Integer.parseInt(lista.get(2)), Integer.parseInt(lista.get(3))));	
			}else if(lista.get(1).equals("Tierra")) {
				listaHechizo.add(new HechizoTipoTierra(lista.get(0) , lista.get(1),Integer.parseInt(lista.get(2)), Integer.parseInt(lista.get(3))));
			}else if(lista.get(1).equals("Planta")) {
				listaHechizo.add(new HechizoTipoPlanta(lista.get(0) , lista.get(1),Integer.parseInt(lista.get(2)), Integer.parseInt(lista.get(3)),Integer.parseInt(lista.get(4))));
			}else if(lista.get(1).equals("Agua")) {
				listaHechizo.add(new HechizoTipoAgua(lista.get(0) , lista.get(1),Integer.parseInt(lista.get(2)), Integer.parseInt(lista.get(3)),Integer.parseInt(lista.get(4))));
			}
		}
		
		
		
		return listaHechizo;
	}
	public ArrayList<Mago> transMago(ArrayList<ArrayList<String>> matriz, ArrayList<Hechizo> listaHechizo){
		ArrayList<Mago> listaMago= new ArrayList<>();
		
		for(ArrayList<String> lista: matriz) {
			ArrayList<Hechizo> listaHechizoMago= new ArrayList<>();
			String nombre=lista.get(0);
			for(int i=1;i<lista.size();i++) {
				for(Hechizo hechizo: listaHechizo) {
					if(hechizo.getNombreHechizo().equals(lista.get(i))) {
						listaHechizoMago.add(hechizo);
					}
				}
			}
			listaMago.add(new Mago(nombre, listaHechizoMago));
			
		}
		return listaMago;
	}
}
