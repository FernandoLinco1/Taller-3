package tallerPOO3;
//Nombre: Fernando Javier Lincopan Araya
//Rut: 21.860.800-0
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class App {
public static Scanner lector;
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		System.out.println("");
	}
	
	public static ArrayList<ArrayList<String>> lecturaMatriz(String texto){
		ArrayList<ArrayList<String>> matriz= new ArrayList<>();
		
		try {
			File arch= new File(texto);
			lector= new Scanner(arch);
			while(lector.hasNextLine()) {
				ArrayList<String> lista= new ArrayList<>();
				String linea= lector.nextLine();
				String[] partes= linea.split("[;|]");
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

}
