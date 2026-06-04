package tallerPOO3;

import java.util.ArrayList;

public interface Transformador {
	ArrayList<Hechizo> transHechizo(ArrayList<ArrayList<String>> matriz);
	ArrayList<Mago> transMago(ArrayList<ArrayList<String>> matriz, ArrayList<Hechizo> listaHechizo);
}
