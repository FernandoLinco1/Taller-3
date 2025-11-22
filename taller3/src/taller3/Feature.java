package taller3;

public class Feature  extends Tarea implements Imprecion{

	public Feature(String idProyecto, String idTarea, String tipo, String descripcion, String estado,
			String responsable, String complejidad, String fecha) {
		super(idProyecto, idTarea, tipo, descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimir(Visitor v) {
		v.VisitarFeature(this);
	}

}
