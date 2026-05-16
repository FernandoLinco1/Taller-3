package tallerPOO3;

public class HechizoTipoPlanta extends Hechizo{
	private int DuracionStun;
	private int CantPlantas;
	public HechizoTipoPlanta(String nombreHechizo, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		DuracionStun = duracionStun;
		CantPlantas = cantPlantas;
	}
	public int getDuracionStun() {
		return DuracionStun;
	}
	public void setDuracionStun(int duracionStun) {
		DuracionStun = duracionStun;
	}
	public int getCantPlantas() {
		return CantPlantas;
	}
	public void setCantPlantas(int cantPlantas) {
		CantPlantas = cantPlantas;
	}
	@Override
	public int calcularPuntaje() {
		//  Puntaje = Daño + (DuracionStun * CantPlanta)
		return daño+(DuracionStun*CantPlantas);
	}
	
}
