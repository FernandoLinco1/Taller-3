package tallerPOO3;

public class HechizoTipoAgua extends Hechizo {
	private int CantidadHeal;
	private int PresionDelAgua;
	public HechizoTipoAgua(String nombreHechizo, String tipo, int daño, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipo, daño);
		CantidadHeal = cantidadHeal;
		PresionDelAgua = presionDelAgua;
	}
	public int getCantidadHeal() {
		return CantidadHeal;
	}
	public void setCantidadHeal(int cantidadHeal) {
		CantidadHeal = cantidadHeal;
	}
	public int getPresionDelAgua() {
		return PresionDelAgua;
	}
	public void setPresionDelAgua(int presionDelAgua) {
		PresionDelAgua = presionDelAgua;
	}
	@Override
	public int calcularPuntaje() {
		//Puntaje = (Daño+CantidadHeal+PresionDeAgua)*2
		return (daño+CantidadHeal+PresionDelAgua)*2;
	}
	
}
