package tallerPOO3;
//Nombre: Fernando Javier Lincopan Araya
//Rut: 21.860.800-0
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class App {
//Creamos la variable lector de tipo Scanner que se ocupara en el codigo para registrar las respuestas del usuario y leer los archivos.
private static Scanner lector;
//La variable sistema de tipo Sistema, esta clase nos sirve para modificar los datos ya que la clase App no puede tener acceso directo
//los datos solo pueden ser manipulados por Sistema.
private static SistemaImplement sistema= new SistemaImplement(lecturaMatriz("Hechizos.txt") , lecturaMatriz("Magos.txt"));
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		System.out.println("Bienvenido al menu de los magos."+"\r\n");
		String decision="";
		while(!decision.equals("3")) {
			System.out.println("1. Menu Administrador"+"\r\n"+"2. Menu Analista"+"\r\n"+"3. Salir"+"\r\n");
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
						eleccionAdministrador1();
						break;
					case "2":
						eleccionAdministrador2();
						break;
					case "3":
						eleccionAdministrador3();
						break;
					case "4":
						eleccionAdministrador4();
						break;
					case "5":
						eleccionAdministrador5();
						break;
					case "6":
						eleccionAdministrador6();
						break;
					case "7":
						System.out.println("\r\n"+"Cerrando menu..."+"\r\n");
						break;
					default:
						System.out.println("\r\n"+"Error ingrese un valor valido.");
						break;
					}
				}GuardarArchivosNuevos();
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
						System.out.println("\r\n"+"Error ingrese un valor valido.");
						break;
					}
				}
				break;
			case "3":
				GuardarArchivosNuevos();
				System.out.println("\r\n"+"Cerrando sistema...");
				break;
			default:
				System.out.println("\r\n"+"Error ingrese un valor valido.");
				break;
			}
		}
	}
	//Este metodo funciona para crear las matrices de tipo String leyendo los distintos txt.
	private static ArrayList<ArrayList<String>> lecturaMatriz(String texto){
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
	//Se imprimen los mejores Hechizos registrados hasta ese momento.
	private static void eleccionAnalisis1() {
		ArrayList<Hechizo> top= sistema.top_10Hechizos();
		int i=1;
		System.out.println("\r\n"+"Top 10 Mejores Hechizos:");
		for(Hechizo hechizo:top) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
	}
	//Se imprimen los mejores Magos hasta el momento.
	private static void eleccionAnalisis2() {
		ArrayList<Mago> top= sistema.top_3Magos();
		int i=1;
		System.out.println("\r\n"+"Top 3 Mejores Magos:");
		for(Mago mago:top) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
	}
	//Se imprimen todos los Hechizos que existan hasta el momento.
	private static void eleccionAnalisis3() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Todos los Hechizos:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
	}
	//Se imprimen todos los magos que existen hasta el momento.
	private static void eleccionAnalisis4() {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		int i=1;
		System.out.println("\r\n"+"Todos los Magos:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
	}
	//Se imprimen todos los Hechizos con sus puntuaciones que existan hasta el momento.
	private static void eleccionAnalisis5() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Todos los Hechizos:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo()+" Puntaje: "+hechizo.calcularPuntaje());
			i++;
		}
	}
	//Se imprimen todos los Magos con sus puntuaciones que existan hasta el momento.
	private static void eleccionAnalisis6() {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		int i=1;
		System.out.println("\r\n"+"Todos los Magos:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre()+" Puntaje: "+mago.sumaPuntajeHechizo());
			i++;
		}
	}
	//Ingresar el nombre del nuevo Mago y verifica si ya no existe, si pasa la verificacion se agregara el nuevo mago a la lista del Sistema.
	private static void eleccionAdministrador1() {
		System.out.println("\r\n"+"Crear nuevo Mago");
		System.out.print("Ingrese el nombre del mago: ");
		String nombreMago= lector.nextLine();
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		boolean existe= false;
		for(Mago mago:listaMagos) {
			if(mago.getNombre().equals(nombreMago)) {
				existe= true;
			}
		}
		if(existe) {
			System.out.println("\r\n"+"Error ya existe este Mago.");
		}else {
			sistema.addMago(nombreMago);
			System.out.println("\r\n"+"Mago creado exitosamente!!");
		}
	}
	//Permite modificar cualquier Mago de la lista de Sistema: 1. Nombre 2. Agregar Hechizo 3. Eliminar Hechizo
	//si la decision es agregar o eliminar llamara a sus respectivos metodos addHechizoMago y borrarHechizoMago que haran realemntel trabajo de 
	// Darle a sistema los nuevos datos.
	private static void eleccionAdministrador2() {
		int i=1;
		ArrayList<Mago> listaMagos=sistema.getListaMagos();
		System.out.println("\r\n"+"Modificar Mago:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceModificarMago= Integer.parseInt(lector.nextLine())-1;
			if(indiceModificarMago<0 || indiceModificarMago>=listaMagos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				System.out.println("\r\n"+"Que desea modificar: "+"\r\n"+"1. Nombre"+"\r\n"+"2. Agregar Hechizo"+"\r\n"+"3. Eliminar Hechizo");
				System.out.print("Ingrese opcion: ");
				String decision= lector.nextLine();
				switch(decision) {
				 case "1":
					 System.out.print("Ingrese nuevo nombre: ");
					 String nombreMago= lector.nextLine();
					 if(existeMago(nombreMago)) {
						 System.out.println("\r\n"+"Error ya existe este Mago.");
					 }else {
						sistema.setNombreMago(indiceModificarMago, nombreMago);
						System.out.println("\r\n"+"Modificacion exitosa!!");
					 }
					 break;
				 case "2":
					 addHechizoMago(indiceModificarMago);
					 break;
				 case "3":
					 borrarHechizoMago(listaMagos.get(indiceModificarMago).getListaDeHechizos(), indiceModificarMago);
					 break;
				 default:
					 System.out.println("\r\n"+"Error ingrese un valor valido.");
					break;
				}
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Selecciona un Mago de la lista para eliminarlo.
	private static void eleccionAdministrador3() {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		int i=1;
		System.out.println("\r\n"+"Eliminacion de Mago:");
		for(Mago mago:listaMagos) {
			System.out.println(i+") "+mago.getNombre());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceBorrar= Integer.parseInt(lector.nextLine())-1;
			if(indiceBorrar<0 && indiceBorrar>=listaMagos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				sistema.borrarMago(indiceBorrar);
				System.out.println("\r\n"+"Se a borrado exitosamente!!");
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Para crear un Hechizo se necesita crear un nombre, ingresar que tipo de Hechizo sera, su daño y su caracteristicas especiales, este Hechizo 
	//Se ingresa a la lista de Hechizos.
	private static void eleccionAdministrador4() {
		System.out.println("\r\n"+"Crear nuevo Hechizo");
		System.out.print("Ingrese el nombre del hechizo: ");
		String nombreHechizo= lector.nextLine();
		if(existeHechizo(nombreHechizo,sistema.getListaHechizos())) {
			System.out.println("\r\n"+"Error ya existe este Hechizo.");
		}else {
			System.out.println("\r\n"+"Tipo de hechizo:"+"\r\n"+"1. Fuego"+"\r\n"+"2. Tierra"+"\r\n"+"3. Planta"+"\r\n"+"4. Agua");
			System.out.print("Ingrese opcion: ");
			String elemento= lector.nextLine();
			int daño;
			System.out.print("Ingrese daño: ");
			switch(elemento) {
			case "1":
				try {
					daño= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Duracion Quemadura: ");
					int duracionQuemadura= Integer.parseInt(lector.nextLine());
					sistema.addHechizo(new HechizoTipoFuego(nombreHechizo,"Fuego", daño, duracionQuemadura));
					System.out.println("\r\n"+"Hechizo creado exitosamente!!");
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido.");
				}
				break;
			case "2":
				try {
					daño= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Mejora Defensa: ");
					int mejoraDefensa= Integer.parseInt(lector.nextLine());
					sistema.addHechizo(new HechizoTipoTierra(nombreHechizo,"Tierra", daño, mejoraDefensa));
					System.out.println("\r\n"+"Hechizo creado exitosamente!!");
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido.");
				}
				break;
			case "3":
				System.out.print("Ingrese daño: ");
				try {
					daño= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Duracion Stuneo: ");
					int duracionStun= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Cantidad Plantas: ");
					int cantPlantas= Integer.parseInt(lector.nextLine());
					sistema.addHechizo(new HechizoTipoPlanta(nombreHechizo,"Planta", daño, duracionStun, cantPlantas));
					System.out.println("\r\n"+"Hechizo creado exitosamente!!");
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido.");
				}
				break;
			case "4":
				System.out.print("Ingrese daño: ");
				try {
					daño= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Cantidad Heal: ");
					int cantidadHeal= Integer.parseInt(lector.nextLine());
					System.out.print("Ingrese Presion del Agua: ");
					int presionDelAgua= Integer.parseInt(lector.nextLine());
					sistema.addHechizo(new HechizoTipoAgua(nombreHechizo,"Agua", daño, cantidadHeal, presionDelAgua));
					System.out.println("\r\n"+"Hechizo creado exitosamente!!");
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido.");
				}
				break;
			default:
				System.out.println("\r\n"+"Error ingrese un valor valido.");
				break;
			}
		}
		
	}
	//se selecciona el Hechizo a modificar y los datos se mandan al metodo modificarHechizo
	private static void eleccionAdministrador5() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Modificar Hechizo:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceModificar= Integer.parseInt(lector.nextLine())-1;
			if(indiceModificar<0 || indiceModificar>=listaHechizos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				String tipo= listaHechizos.get(indiceModificar).getTipo();
				switch(tipo) {
				case "Fuego":
					System.out.println("\r\n"+"Que desea modificar: "+"\r\n"+"1. Nombre"+"\r\n"+"2. Daño"+"\r\n"+"3. Duracion Quemadura");
					ModificadorHechizo(tipo, indiceModificar);
					break;
				case "Tierra":
					System.out.println("\r\n"+"Que desea modificar: "+"\r\n"+"1. Nombre"+"\r\n"+"2. Daño"+"\r\n"+"3. Mejora Defensa");
					 ModificadorHechizo(tipo, indiceModificar);
					break;
				case "Planta":
					System.out.println("\r\n"+"Que desea modificar: "+"\r\n"+"1. Nombre"+"\r\n"+"2. Daño"+"\r\n"+"3. Duracion Stuneo"+"\r\n"+"4. Cantidad Plantas");
					ModificadorHechizo(tipo, indiceModificar);
					break;
				case "Agua":
					System.out.println("\r\n"+"Que desea modificar: "+"\r\n"+"1. Nombre"+"\r\n"+"2. Daño"+"\r\n"+"3. Cantidad Heal"+"\r\n"+"4. Presion del Agua");
					ModificadorHechizo(tipo, indiceModificar);
					break;
				}
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Selecciona un Hechizo y se elemininara de la lista de Hechizos y la lista de Magos.
	private static void eleccionAdministrador6() {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Eliminacion de Hechizo:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceBorrar= Integer.parseInt(lector.nextLine())-1;
			if(indiceBorrar<0 && indiceBorrar>=listaHechizos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				sistema.borrarHechizo(indiceBorrar);
				System.out.println("\r\n"+"Se a borrado exitosamente!!");
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Se utiliza para verificar si existe el Hechizo con anterioridad.
	private static boolean existeHechizo(String nombreHechizo,ArrayList<Hechizo> listaHechizos) {
		boolean existe= false;
		for(Hechizo hechizo: listaHechizos) {
			if(hechizo.getNombreHechizo().equals(nombreHechizo)) {
				existe= true;
			}
		}
		return existe;
	}
	//Se utiliza para verificar si exite el nombre de ese mago con anterioridad.
	private static boolean existeMago(String nombreMago) {
		ArrayList<Mago> listaMagos= sistema.getListaMagos();
		boolean existe= false;
		for(Mago mago: listaMagos) {
			if(mago.getNombre().equals(nombreMago)) {
				existe= true;
			}
		}
		return existe;
	}
	//Permite modificar cualquier Hechizo de la lista Sistema y de los Hechizos de los Magos, Permitiendo modificar:
	//su nombre, daño y sus caracteristicas especiales dependiendo del tipo de Hechizo.
	private static void ModificadorHechizo(String tipo, int indiceModificar) {
		System.out.print("Ingrese opcion: ");
		String decision= lector.nextLine();
		try {
		 switch(decision) {
		 case "1":
			 System.out.print("Ingrese nuevo nombre: ");
			 String nombreHechizo= lector.nextLine();
			 if(existeHechizo(nombreHechizo,sistema.getListaHechizos())) {
				 System.out.println("\r\n"+"Error ya existe este Hechizo.");
			 }else {
				sistema.setNombreHechizo(indiceModificar, nombreHechizo); 
				System.out.println("\r\n"+"Modificacion exitosa!!");
			 }
			 break;
		 case "2":
			 System.out.print("Ingrese nuevo Daño: ");
			 int nuevoDaño= Integer.parseInt(lector.nextLine());
			 sistema.setDañoHechizo(indiceModificar, nuevoDaño);
			 System.out.println("\r\n"+"Modificacion exitosa!!");
			 break;
		 case "3":
			 if(tipo.equals("Fuego")) {
				 System.out.print("Ingrese nueva Duracion Quemadura: "); 
			 }else if(tipo.equals("Tierra")){
				 System.out.print("Ingrese nueva Mejora Defensa: "); 
			 }else if(tipo.equals("Planta")) {
				 System.out.print("Ingrese nueva Duracion Stuneo: "); 
			 }else if(tipo.equals("Agua")){
				 System.out.print("Ingrese nueva Cantidad Heal: "); 
			 }
			 int valor= Integer.parseInt(lector.nextLine());
			 sistema.setCaracteristicaEspecial1(indiceModificar, valor);
			 System.out.println("\r\n"+"Modificacion exitosa!!");
			 break;
		 case "4":
			 if(!tipo.equals("Fuego") && !tipo.equals("Tierra")) {
			 if(tipo.equals("Planta")) {
				 System.out.print("Ingrese nueva Cantidad Plantas: "); 
			 }else if(tipo.equals("Agua")){
				 System.out.print("Ingrese nueva Presion del Agua: "); 
			 }
			 int valor2= Integer.parseInt(lector.nextLine());
			 sistema.setCaracteristicaEspecial2(indiceModificar, valor2);
			 System.out.println("\r\n"+"Modificacion exitosa!!");
			 }else if(tipo.equals("Fuego") || tipo.equals("Tierra")) {
				 System.out.println("\r\n"+"Error ingrese un valor valido.");
			 }
			 break;
		 default:
			 System.out.println("\r\n"+"Error ingrese un valor valido.");
			 break;
		 }
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Agrega correctamente el Hechizo a la lista de Hechizos de el Mago
	private static void addHechizoMago(int indiceModificarMago) {
		ArrayList<Hechizo> listaHechizos= sistema.getListaHechizos();
		int i=1;
		System.out.println("\r\n"+"Todos los Hechizos:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo()+" Puntaje: "+hechizo.calcularPuntaje());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceModificar= Integer.parseInt(lector.nextLine())-1;
			if(indiceModificar<0 && indiceModificar>=listaHechizos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				sistema.addHechizoMago(listaHechizos.get(indiceModificar), indiceModificarMago);
				System.out.println("\r\n"+"Modificacion exitosa!!");
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
	}
	//Borra correctamente el Hechizo a la lista de Hechizos de el Mago
	private static void borrarHechizoMago(ArrayList<Hechizo> listaHechizos,int indiceModificarMago) {
		if(listaHechizos.size()!=0) {
		int i=1;
		System.out.println("\r\n"+"Eliminacion de Hechizo:");
		for(Hechizo hechizo:listaHechizos) {
			System.out.println(i+") "+hechizo.getNombreHechizo());
			i++;
		}
		System.out.print("Ingrese opcion: ");
		try {
			int indiceBorrar= Integer.parseInt(lector.nextLine())-1;
			if(indiceBorrar<0 && indiceBorrar>=listaHechizos.size()) {
				System.out.println("\r\n"+"Error ingrese un valor valido.");
			}else {
				sistema.borrarHechizoMago(indiceBorrar, indiceModificarMago);
				System.out.println("\r\n"+"Se a borrado exitosamente!!");
			}
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido.");
		}
		}else if(listaHechizos.size()==0) {
			System.out.println("\r\n"+"Error el Mago no tiene Hechizos.");
		}
	}
	//Al cerrar el codigo se llama a las listas para guardar en sus respectivos txt los nuevos datos agregados.
	private static void GuardarArchivosNuevos() {
		 ArrayList<Mago> listaMago= sistema.getListaMagos();
		 ArrayList<Hechizo> listaHechizo= sistema.getListaHechizos();
		
		 try{
			 FileWriter escritorMago = new FileWriter("Magos.txt");
	            
	            for (int i=0;i<listaMago.size();i++) {
	            	escritorMago.write(listaMago.get(i).getNombre()+";"); 
	            	int tope= listaMago.get(i).getListaDeHechizos().size();
	            	if(tope>1) {
	                for(int j=0;j<tope;j++) {
	                	if(i==listaMago.size()-1 && j==(tope-1) ) {
	                		escritorMago.write(listaMago.get(i).getListaDeHechizos().get(j).getNombreHechizo()); 
	                	}else if(j!=(tope-1)) {
	                		 escritorMago.write(listaMago.get(i).getListaDeHechizos().get(j).getNombreHechizo()+"|");  
	                	 }else{
	                		escritorMago.write(listaMago.get(i).getListaDeHechizos().get(j).getNombreHechizo()+"\n"); 
	                	 }
	                }
	            	}else {
	            		escritorMago.write("\n");
	            	}
	            }
	        escritorMago.close();     
	        FileWriter escritorHechizo = new FileWriter("Hechizos.txt");
	        
	            for (Hechizo hechizo : listaHechizo) {
	            	if(hechizo.getCaracteristicaEspecial2()==0) {
	            		escritorHechizo.write(hechizo.getNombreHechizo()+";"+hechizo.getTipo()+";"+hechizo.getDaño()+";"+hechizo.getCaracteristicaEspecial1()+"\n"); 
	            	}else { 
	            		escritorHechizo.write(hechizo.getNombreHechizo()+";"+hechizo.getTipo()+";"+hechizo.getDaño()+";"+hechizo.getCaracteristicaEspecial1()+","+hechizo.getCaracteristicaEspecial2()+"\n"); 
	            	}
	            }   
	            escritorHechizo.close();
	            
	        } catch (Exception e) {
	            System.out.println("Error al escribir en el archivo.");
	        }
	}
}
