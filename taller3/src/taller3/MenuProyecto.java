package taller3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuProyecto {
	private static Scanner lector;
	
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		Sistema sis= new Sistema(lector("usuarios.txt"),lector("proyectos.txt"),lector("tareas.txt"));
		String decision="";
		while(!decision.equals("6") && !decision.equals("5")) {
		System.out.println("Ingrese un usuario");
		System.out.print(">>> ");
		String u= lector.nextLine();
		String usuario= sis.verificacionUsuario(u);
		switch(usuario) {
		case "1":
			System.out.println("Usuario valido");
			System.out.println("Ingrese contraseña");
			System.out.print(">>>");
			String c= lector.nextLine();
			String contraseña=sis.verificarContraseña(u, c);
			
			switch(contraseña) {
			case "1":
				ArrayList<Proyecto> proyectos= sis.getProyectos();
				ArrayList<Tarea>	tareas= sis.getTareas();
				ArrayList<Usuario> usuarios= sis.getUsuarios();
				System.out.println();
				System.out.println("Bienvenido "+u);
				System.out.println();
				while(!decision.equals("6") && !decision.equals("5")) {
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
	
					for(Proyecto pro : proyectos) {
							String proyectoID= pro.getIdProyecto();
							String proyectoN= pro.getNombre();
							System.out.println( "ID: "+proyectoID+" Proyecto: "+proyectoN+" a cargo de: "+pro.getResponsable());
							for(Tarea ta : tareas) {
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
						
						break;
					default:
						System.out.println("Eleccion incorrecta...");
					}
					
					
					
					break;
				case "6":
					System.out.println("Cerrando sistema...");
					break;
				default:
					System.out.println("Eleccion incorrecta...");
					break;
				}
				}
				break;
			case "0":
				System.out.println("Bienvenido "+u);
				while(!decision.equals("6") && !decision.equals("5")) {
				System.out.println("Menu Colaborador");
				System.out.println("1. Ver proyectos disponibles.");
				System.out.println("2. Ver tareas asignadas.");
				System.out.println("3. Actualizar estado de una tarea.");
				System.out.println("4. Aplicar visitor sobre tareas.");
				System.out.println("5. Salir del sistema.");
				System.out.print(">>> ");
				decision= lector.nextLine();
				switch(decision) {
				case "5":
					System.out.println("Cerrando sistema...");
					break;
				default:
					System.out.println("Eleccion incorrecta...");
					break;
				}
				}
				break;
			default:
				System.out.println("Contraseña Incorrecta");
				break;
			}
			break;
		case "0":
			System.out.println("Usuario No Valido");
			System.out.println();
			break;
		default:
			System.out.println("Error De Sistema...");
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


