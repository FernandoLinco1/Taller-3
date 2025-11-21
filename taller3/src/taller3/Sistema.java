package taller3;
import java.util.ArrayList;
import java.util.Iterator;
public class Sistema {
	
	private ArrayList<Usuario> usuarios= new ArrayList<>();
	private ArrayList<Proyecto> proyectos= new ArrayList<>();
	private ArrayList<Tarea> tareas= new ArrayList<>();
	public Sistema(ArrayList<ArrayList<String>> usuarios, ArrayList<ArrayList<String>> proyectos, ArrayList<ArrayList<String>> tareas) {
		this.usuarios=lecturaU(usuarios);
		this.proyectos=lecturaP(proyectos);
		this.tareas=lecturaT(tareas);
		
		asignarTareas();
		
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void addProyecto(String nombreP, String encargadoP) {
		int cont=0;
		for(int i=0;i<proyectos.size();i++) {
			cont=i;
		}
		cont= cont+2;
		
		if(cont<10) {
		  String id= "PR00"+String.valueOf(cont);
		  proyectos.add(new Proyecto(id,nombreP,encargadoP));		
		}else if(cont<100) {
			  String id= "PR0"+String.valueOf(cont);
			  proyectos.add(new Proyecto(id,nombreP,encargadoP));		
			}else if(cont>=100) {
				  String id= "PR"+String.valueOf(cont);
				  proyectos.add(new Proyecto(id,nombreP,encargadoP));		
				}
		
		
	}
	
	public void BorrarProyecto(int proyectoBorrado) {
		
		for(int i=0;i<proyectos.size();i++) {
			if(proyectoBorrado==(i+1)) {
				String proyecto= proyectos.get(i).getIdProyecto();
				 tareas.removeIf(t -> t.getIdProyecto().equals(proyecto));
				    proyectos.removeIf(p -> p.getIdProyecto().equals(proyecto ));
				    String proyectoBor= proyecto;
				    for(Proyecto pro: proyectos ) {
				    	String[] partes= proyectoBor.split("R");
				    	String[] partes0= pro.getIdProyecto().split("R");
				    	if(Integer.valueOf(partes[1])<Integer.valueOf(partes0[1])) {
				    		
				 		String aux= pro.getIdProyecto();
				    		pro.setIdProyecto(proyectoBor);
				    		proyectoBor= aux;
				    		for(Tarea ta: tareas) {
				    			if(proyectoBor.equals(ta.getIdProyecto())) {
				    				ta.setIdProyecto(pro.getIdProyecto());	
				    			}
				    		}
				    	}
				    }
			}
		}
		
		
	    for(int i=0;i<tareas.size();i++) {
	    	int n=i+1;
	    	if(n<10) {
	    		tareas.get(i).setIdTarea("T00"+n);
	    	}else if(n<100) {
	    		tareas.get(i).setIdTarea("T0"+n);
	    	}else if(n>=100) {
	    		tareas.get(i).setIdTarea("T"+n);
	    	}
	    }
	}
	public String verificacionUsuario(String usuario) {
		for(Usuario u: usuarios) {
			if(u.getNombreUsuario().equals(usuario)) {
				return "1";
			}
		}
		return "0";
		
	} 
	
	public String verificarContraseña(String usuario, String contraseña) {
		for(Usuario u: usuarios) {
			if(u.getNombreUsuario().equals(usuario)) {
				if(u.getContraseña().equals(contraseña)) {
					if(u.getRol().equals("Administrador")) {
						return "1";
					}
					else if(u.getRol().equals("Colaborador")) {
						return "0";		
					}
				}
			}
			
		}
		return "";
	}
	
	private ArrayList<Usuario> lecturaU(ArrayList<ArrayList<String>> usuarios){
		ArrayList<Usuario> lista= new ArrayList<>();
		for(ArrayList<String> i: usuarios) {
			lista.add(new Usuario(i.get(0),i.get(1),i.get(2)));
		}
		return lista;
	}
	
	private ArrayList<Proyecto> lecturaP(ArrayList<ArrayList<String>> proyectos){
		ArrayList<Proyecto> lista= new ArrayList<>();
		for(ArrayList<String> i: proyectos) {
			lista.add(new Proyecto(i.get(0),i.get(1),i.get(2)));
		}
		return lista;
	}
	
	private ArrayList<Tarea> lecturaT(ArrayList<ArrayList<String>> tareas){
		ArrayList<Tarea> lista= new ArrayList<>();
		for(ArrayList<String> i: tareas) {
			lista.add(new Tarea(i.get(0),i.get(1),i.get(2),i.get(3),i.get(4),i.get(5),i.get(6),i.get(7)));
		}
		return lista;
	}
	
	// codigo para buscar y conectar las tareas con los colaboradores asignados
	
	public Usuario buscarUsuario(String nombre) {
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equalsIgnoreCase(nombre)) {
				return u;
			}
		}
		return null;
	}
	private void asignarTareas() {
		for (Tarea tarea : tareas) {
			String nombreResponsable = tarea.getResponsable();
			Usuario responsable = buscarUsuario(nombreResponsable);
			if (responsable != null) {
				responsable.añadirTarea(tarea);
			}
		}
	}
		

	
	
	
	
	
	
	
	
	
}

