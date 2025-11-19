package taller3;

public class Proyecto {
	private String idProyecto;
	private String nombre;
	private String responsable;
	public Proyecto(String idProyecto, String nombre, String responsable) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.responsable = responsable;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
}
