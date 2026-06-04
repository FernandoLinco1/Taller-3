package tallerPOO3;

public class HechizoTipoPlanta extends Hechizo{
	private int DuracionStun;
	private int CantPlantas;
	public HechizoTipoPlanta(String nombreHechizo, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		DuracionStun = duracionStun;
		CantPlantas = cantPlantas;
	}
	
	@Override
	public int calcularPuntaje() {
		//  Puntaje = Daño + (DuracionStun * CantPlanta)
		return getDaño()+(DuracionStun*CantPlantas);
	}
	@Override
	public void setCaracteristicaEspecial1(int valor) {
		DuracionStun = valor;		
	}
	@Override
	public void setCaracteristicaEspecial2(int valor) {
		CantPlantas = valor;		
	}

	@Override
	public int getCaracteristicaEspecial1() {
		// TODO Auto-generated method stub
		return DuracionStun;
	}

	@Override
	public int getCaracteristicaEspecial2() {
		// TODO Auto-generated method stub
		return CantPlantas;
	}
	
}
