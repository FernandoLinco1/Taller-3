package taller3;

public interface Visitor {
	public void VisitarBug(Bug bug);
	public void VisitarFeature(Feature feature);
	public void VisitarDocumentacion(Documentacion documentacion);
}
