package taller3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuProyecto {
	private static Scanner lector;
	private static String decision;
	private static String contraseña;
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		Sistema sis= new Sistema("usuarios.txt","proyectos.txt","tareas.txt");
		decision="";
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
			contraseña=sis.verificarContraseña(u, c);
			switch(contraseña) {
			case "1":
				System.out.println("Bienvenido "+u);
				while(!decision.equals("6") && !decision.equals("5")) {
				System.out.println("Menu administrador");
				System.out.println("1. Ver lista completa de proyectos y tareas.");
				System.out.println("2. Agregar o eliminar un proyecto.");
				System.out.println("3. Agregar o eliminar una tarea en un proyecto.");
				System.out.println("4. Asignar Prioridades.");
				System.out.println("5. Generar reporte de proyecto.");
				System.out.println("6. Salir del sistema.");
				System.out.print(">>> ");
				decision= lector.nextLine();
				switch(decision) {
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

}


