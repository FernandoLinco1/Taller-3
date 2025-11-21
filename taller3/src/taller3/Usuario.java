package taller3;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombreUsuario;
	private String contraseña;
	private String rol;
	private List<Tarea> tareasAsignadas;
	public Usuario(String nombreUsuario, String contraseña, String rol) {
		
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.rol = rol;
		this.tareasAsignadas = new ArrayList<>();
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void añadirTarea(Tarea tarea) {
		this.tareasAsignadas.add(tarea);
	}
	public List<Tarea> getTareasAsignadas() {
		return tareasAsignadas;
	}
	
}

