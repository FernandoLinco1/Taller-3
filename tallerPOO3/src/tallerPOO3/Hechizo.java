package tallerPOO3;

public abstract class Hechizo {
	private String nombreHechizo;
	private String tipo;
	private int daño;
	public Hechizo(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}
	public String getNombreHechizo() {
		return nombreHechizo;
	}
	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}
	public String getTipo() {
		return tipo;
	}
    public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public abstract int calcularPuntaje();
	public abstract void setCaracteristicaEspecial1(int valor);
	public abstract void setCaracteristicaEspecial2(int valor);
	public abstract int getCaracteristicaEspecial1(); 
	public abstract int getCaracteristicaEspecial2(); 
}
