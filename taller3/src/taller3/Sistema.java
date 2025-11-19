package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Sistema {
	
	private ArrayList<Usuario> usuarios= new ArrayList<>();
	private ArrayList<Proyecto> proyectos= new ArrayList<>();
	private ArrayList<Tarea> tareas= new ArrayList<>();
	public Sistema(String usuarios, String proyectos, String tareas) {
		this.usuarios=lecturaU(usuarios);
		this.proyectos=lecturaP(proyectos);
		this.tareas=lecturaT(tareas);
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
	
	
	
	
	
	
	
	
	private ArrayList<Usuario> lecturaU(String texto) {
		ArrayList<Usuario> lista= new ArrayList<>();
		try {
			File arch= new File(texto);
			Scanner lec= new Scanner(arch);
			while(lec.hasNextLine()) {
				String linea= lec.nextLine();
				String[] partes= linea.split("\\|");
				Usuario clase= new Usuario(partes[0],partes[1],partes[2]);
				lista.add(clase);
			}
			lec.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("no se a encotrado el archivo");
		}
		return lista;
	}
	
	private ArrayList<Proyecto> lecturaP(String texto) {
		ArrayList<Proyecto> lista= new ArrayList<>();
		try {
			File arch= new File(texto);
			Scanner lec= new Scanner(arch);
			while(lec.hasNextLine()) {
				String linea= lec.nextLine();
				String[] partes= linea.split("\\|");
				Proyecto clase= new Proyecto(partes[0],partes[1],partes[2]);
				lista.add(clase);
			}
			lec.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("no se a encotrado el archivo");
		}
		return lista;
	}
	
	private ArrayList<Tarea> lecturaT(String texto) {
		ArrayList<Tarea> lista= new ArrayList<>();
		try {
			File arch= new File(texto);
			Scanner lec= new Scanner(arch);
			while(lec.hasNextLine()) {
				String linea= lec.nextLine();
				String[] partes= linea.split("\\|");
				Tarea clase= new Tarea(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5],partes[6],partes[7]);
				lista.add(clase);
			}
			lec.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("no se a encotrado el archivo");
		}
		return lista;
	}
	
}

