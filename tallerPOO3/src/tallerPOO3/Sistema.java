package tallerPOO3;

import java.util.ArrayList;

public interface Sistema {
	ArrayList<Hechizo> top_10Hechizos();
	ArrayList<Mago> top_3Magos();
	ArrayList<Hechizo> getListaHechizos();
	ArrayList<Mago> getListaMagos();
	void addMago(String nombreMago);
	void borrarMago(int indiceBorrar);
	void addHechizo(Hechizo hechizo);
	void borrarHechizo(int indiceBorrar);
	void setNombreHechizo(int indiceModificar,String nombreHechizo);
	void setDañoHechizo(int indiceModificar,int nuevoDaño);
	void setCaracteristicaEspecial1(int indiceModificar,int valor);
	void setCaracteristicaEspecial2(int indiceModificar,int valor);
	void setNombreMago(int indiceModificarMago,String nombreMago);
	void addHechizoMago(Hechizo hechizo,int indiceModificarMago);
	void borrarHechizoMago(int indiceBorrar,int indiceModificarMago);
	void setNombreHechizoMago(int indiceModificar,int indiceModificarMago,String nombreHechizo);
	void setDañoHechizoMago(int indiceModificar,int indiceModificarMago,int nuevoDaño);
	void setCaracteristicaEspecial1Mago(int indiceModificar,int indiceModificarMago,int valor);
	void setCaracteristicaEspecial2Mago(int indiceModificar,int indiceModificarMago,int valor);
	

}
