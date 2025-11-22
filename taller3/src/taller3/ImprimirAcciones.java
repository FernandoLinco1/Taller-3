package taller3;

public class ImprimirAcciones implements Visitor{

	@Override
	public void VisitarBug(Bug bug) {
		System.out.println("h");
	}

	@Override
	public void VisitarFeature(Feature feature) {
		System.out.println("j");
		
	}

	@Override
	public void VisitarDocumentacion(Documentacion documentacion) {
		System.out.println("k");
		
	}

}
