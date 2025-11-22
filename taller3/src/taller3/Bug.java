package taller3;

public class Bug extends Tarea implements Imprecion {

	public Bug(String idProyecto, String idTarea, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(idProyecto, idTarea, tipo, descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

	
	public void imprimir(Visitor v) {
		v.VisitarBug(this);
		
	}

}
