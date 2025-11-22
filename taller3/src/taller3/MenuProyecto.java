package taller3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuProyecto {
	private static Scanner lector;
	
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		Sistema sis= new Sistema(lector("usuarios.txt"),lector("proyectos.txt"),lector("tareas.txt"));
		String decision="";
		String usuario="";
		while(!usuario.equals("salir")) {
		System.out.println("Ingrese un usuario");
		System.out.print(">>> ");
		String u= lector.nextLine();
		usuario= sis.verificacionUsuario(u);
		switch(usuario) {
		case "1":
			System.out.println("Usuario valido");
			System.out.println("Ingrese contraseña");
			System.out.print(">>>");
			String c= lector.nextLine();
			String contraseña=sis.verificarContraseña(u, c);
			
			switch(contraseña) {
			case "1":
				
				System.out.println();
				decision="";
				System.out.println("Bienvenido "+u);
				System.out.println();
				while(!decision.equals("6")) {
				System.out.println("Menu administrador");
				System.out.println("1. Ver lista completa de proyectos y tareas.");
				System.out.println("2. Agregar o eliminar un proyecto.");
				System.out.println("3. Agregar o eliminar una tarea en un proyecto.");
				System.out.println("4. Asignar Prioridades con Strategy.");
				System.out.println("5. Generar reporte de proyecto.");
				System.out.println("6. Salir del sistema.");
				System.out.print(">>> ");
				decision= lector.nextLine();
				switch(decision) {
				case "1":
					for(Proyecto pro : sis.getProyectos()) {
							String proyectoID= pro.getIdProyecto();
							String proyectoN= pro.getNombre();
							System.out.println( "ID: "+proyectoID+" Proyecto: "+proyectoN+" Encargado: "+pro.getResponsable());
							for(Tarea ta : sis.getTareas()) {
								if(ta.getIdProyecto().equals(proyectoID)) {
									System.out.println("ID: "+ta.getIdTarea()+ " Tarea: "+ta.getTipo()+" Descripcion: "+ta.getDescripcion()+" Estado: "+ta.getEstado()+" Encargado: "+ta.getResponsable() +" Complejidad: "+ta.getComplejidad()+" Fecha: "+ta.getFecha());
								}
							}
							System.out.println();
						}
					break;
				case "2":
					System.out.println();
					System.out.println("1. Agregar proyecto.");
					System.out.println("2. Eliminar proyecto.");
					System.out.print(">>> ");
					decision= lector.nextLine();
					switch(decision) {
					case "1":
						System.out.println("Ingrese nombre.");
						System.out.print(">>> ");
						String nombreP= lector.nextLine();
						System.out.println("Ingrese el encargado del proyecto.");
						System.out.print(">>> ");
						String encargadoP= lector.nextLine();
						sis.addProyecto(nombreP, encargadoP);
						break;
					case "2":
						for(int i=0;i<sis.getProyectos().size();i++) {
							System.out.println((i+1)+". ID: "+sis.getProyectos().get(i).getIdProyecto()+" Proyecto: "+sis.getProyectos().get(i).getNombre()+" Encargado: "+sis.getProyectos().get(i).getResponsable());
						}
						System.out.print(">>> ");
						int proyectoBorrado= Integer.valueOf(lector.nextLine());
						sis.BorrarProyecto(proyectoBorrado);
						break;
					default:
						System.out.println("Eleccion incorrecta...");
					}
					break;
				case "3":
					System.out.println();
					System.out.println("1. Agregar proyecto.");
					System.out.println("2. Eliminar proyecto.");
					System.out.print(">>> ");
					decision= lector.nextLine();
					switch(decision) {
					case "1":
						for(int i=0;i<sis.getProyectos().size();i++) {
							System.out.println((i+1)+". ID: "+sis.getProyectos().get(i).getIdProyecto()+" Proyecto: "+sis.getProyectos().get(i).getNombre()+" Encargado: "+sis.getProyectos().get(i).getResponsable());
						}
						System.out.print(">>> ");
						String proyecto= lector.nextLine();
						System.out.println("Tipo de tarea.");
						System.out.println("1. Bug.");
						System.out.println("2. Feature.");
						System.out.println("3. Documentación.");
						System.out.print(">>> ");
						String tipo= lector.nextLine();
						System.out.println("Descripción.");
						String descripcion= lector.nextLine();
						
					break;
					
					
					}
					break;
				case "6":
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Eleccion incorrecta...");
					break;
				}
				}
				break;
			case "0":
				System.out.println();
				decision="";
				System.out.println("Bienvenido "+u);
				System.out.println();
				while(!decision.equals("5")) {
				System.out.println("Menu Colaborador");
				System.out.println("1. Ver proyectos disponibles.");
				System.out.println("2. Ver tareas asignadas.");
				System.out.println("3. Actualizar estado de una tarea.");
				System.out.println("4. Aplicar visitor sobre tareas.");
				System.out.println("5. Salir del sistema.");
				System.out.print(">>> ");
				decision= lector.nextLine();
				switch(decision) {
				case "1":
					for(Proyecto pro: sis.getProyectos()) {
						System.out.println("Proyecto: "+pro.getNombre()+" Encargado: "+pro.getResponsable());
					}
					break;
				case "2":
					 
					for(Tarea ta : sis.tareasDeColaborador(u)) {
							System.out.println("ProyectoID: "+ta.getIdProyecto()+" ID: "+ta.getIdTarea()+ " Tarea: "+ta.getTipo()+" Descripcion: "+ta.getDescripcion()+" Estado: "+ta.getEstado()+" Complejidad: "+ta.getComplejidad()+" Fecha: "+ta.getFecha());	
					}
					System.out.println();

					break;
				case "3":
					int i=1;
					for(Tarea ta : sis.tareasDeColaborador(u)) {
						System.out.println(i+". "+" ID: "+ta.getIdTarea()+ " Tarea: "+ta.getTipo()+" Estado: "+ta.getEstado());	
						i++;
					}
					System.out.print(">>> ");
					int tarea= Integer.valueOf(lector.nextLine());
					System.out.println("1. Pendiente.");
					System.out.println("2. Progreso.");
					System.out.println("3. Completada.");
					System.out.print(">>> ");
					String estado= lector.nextLine();
					i=1;
					for(Tarea ta : sis.tareasDeColaborador(u)) {
						if(tarea==i) {
							sis.cambiarEstadoTarea(ta, estado);
						}
						i++;
					}
					break;
				case "4": 
					List<Imprecion> accion= sis.accionTareas(sis.tareasDeColaborador(u));
					
					Visitor v= new ImprimirAcciones();
					for(Imprecion im: accion) {
						im.imprimir(v);
					}
					break;
				case "5":
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Eleccion incorrecta...");
					System.out.println();
					break;
				}
				}
				break;
			default:
				System.out.println("Contraseña Incorrecta");
				System.out.println();
				break;
			}
			break;
		case "0":
			System.out.println("Usuario No Valido");
			System.out.println();
			break;
		case "salir":
			System.out.println("Cerrar sistema...");
			System.out.println();
			break;
		default:
			System.out.println("Error De Sistema...");
			System.out.println();
			break;
		}
		}
	
	}
	private static  ArrayList<ArrayList<String>> lector(String texto){
		ArrayList<ArrayList<String>> matriz= new ArrayList<>();
		try {
			File arch= new File(texto);
			Scanner lec= new Scanner(arch);
			while(lec.hasNextLine()) {
				ArrayList<String> lista= new ArrayList<>();
				String linea= lec.nextLine();
				String[] partes= linea.split("\\|");
				for(String i: partes) {
					lista.add(i);
				}
				matriz.add(lista);
				
			}
			lec.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error sistema...");
		}
		return matriz;
	}
}


