package tallerPOO3;
//Nombre: Fernando Javier Lincopan Araya
//Rut: 21.860.800-0
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class App {
private static Scanner lector;
private static SistemaImplement sistema= new SistemaImplement(lecturaMatriz("Hechizos.txt") , lecturaMatriz("Magos.txt"));
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		System.out.println("Bienvenido al menu de los magos.");
		String decision="";
		while(!decision.equals("3")) {
			System.out.println("\r\n"+"1. Menu Administrador"+"\r\n"+"2. Menu Analista"+"\r\n"+"3. Salir"+"\r\n");
			System.out.print("Ingrese opcion: ");
			decision= lector.nextLine();
			switch(decision) {
			case "1":
				System.out.println("\r\n"+"Bienvenido al menu administrador.");
				String decisionAdmin="";
				while(!decisionAdmin.equals("7")) {
					System.out.println("\r\n"+"1. Agregar Mago\r\n"+ "2. Modificar Mago\r\n"+ "3. Eliminar Mago\r\n"+ "4. Agregar Hechizo\r\n"+ "5. Modificar Hechizo\r\n"+ "6. Eliminar Hechizo"+"\r\n"+"7. Salir"+"\r\n");
					System.out.print("Ingrese opcion: ");
					decisionAdmin= lector.nextLine();
					switch(decisionAdmin) {
					case "1":
						break;
					case "2":
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						break;
					case "6":
						break;
					case "7":
						System.out.println("\r\n"+"Cerrando menu..."+"\r\n");
						break;
					default:
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
						break;
					}
				}
				break;
			case "2":
				System.out.println("\r\n"+"Bienvenido al menu analista.");
				String decisionAnalisis="";
				while(!decisionAnalisis.equals("7")) {
					System.out.println("\r\n"+"1. Top 10 Mejores Hechizos\r\n"+ "2. Top 3 Mejores Magos\r\n"+ "3. Mostrar todos los Hechizos\r\n"+ "4. Mostrar todos los magos\r\n"+ "5. Mostrar todos los Hechizos junto a su puntuacion\r\n"+ "6. Mostrar todos los magos junto a su puntuacion"+"\r\n"+"7. Salir"+"\r\n");
					System.out.print("Ingrese opcion: ");
					decisionAnalisis= lector.nextLine();
					switch(decisionAnalisis) {
					case "1":
						eleccionAnalisis1();
						break;
					case "2":
						eleccionAnalisis2();
						break;
					case "3":
						eleccionAnalisis3();
						break;
					case "4":
						eleccionAnalisis4();
						break;
					case "5":
						eleccionAnalisis5();
						break;
					case "6":
						eleccionAnalisis6();
						break;
					case "7":
						System.out.println("\r\n"+"Cerrando menu..."+"\r\n");
						break;
					default:
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
						break;
					}
				}
				break;
			case "3":
				System.out.println("\r\n"+"Cerrando sistema...");
				break;
			default:
				System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
				break;
			}
		}
	}
	
	public static ArrayList<ArrayList<String>> lecturaMatriz(String texto){
		ArrayList<ArrayList<String>> matriz= new ArrayList<>();
		
		try {
			File arch= new File(texto);
			lector= new Scanner(arch);
			while(lector.hasNextLine()) {
				ArrayList<String> lista= new ArrayList<>();
				String linea= lector.nextLine();
				String[] partes= linea.split("[;|,]");
				for( String p:partes) {
					lista.add(p);
				}
				matriz.add(lista);
			}
			lector.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error no se a encontrado el archivo.");
		}
		
		
		
		return matriz;
	}
	public static void eleccionAnalisis1() {
		ArrayList<Hechizo> top= sistema.top_10Hechizos();
		int i=1;
		System.out.println("\r\n"+"Top 10 Mejores Hechizos:");
		for(Hechizo hechizo:top) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
	}
	public static void eleccionAnalisis2() {
		ArrayList<Mago> top= sistema.top_3Magos();
		int i=1;
		System.out.println("\r\n"+"Top 3 Mejores Magos:");
		for(Mago mago:top) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
	}
	public static void eleccionAnalisis3() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Todos los Hechizos:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
	}
	public static void eleccionAnalisis4() {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		int i=1;
		System.out.println("\r\n"+"Todos los Magos:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
	}
	public static void eleccionAnalisis5() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Todos los Hechizos:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo()+" Puntaje: "+hechizo.calcularPuntaje());
			i++;
		}
	}
	public static void eleccionAnalisis6() {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		int i=1;
		System.out.println("\r\n"+"Todos los Magos:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre()+" Puntaje: "+mago.sumaPuntajeHechizo());
			i++;
		}
	}
	
}
