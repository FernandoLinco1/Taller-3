package tallerPOO3;

public class HechizoTipoFuego extends Hechizo{
	private int DuracionQuemadura;
	public HechizoTipoFuego(String nombreHechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipo, daño);
		DuracionQuemadura = duracionQuemadura;
	}
	@Override
	public int calcularPuntaje() {
		// Puntaje = Daño*DuracionQuemadura
		return getDaño()*DuracionQuemadura;
	}
	@Override
	public void setCaracteristicaEspecial1(int valor) {
		DuracionQuemadura = valor;		
	}
	@Override
	public void setCaracteristicaEspecial2(int valor) {}
	@Override
	public int getCaracteristicaEspecial1() {
		// TODO Auto-generated method stub
		return DuracionQuemadura;
	}
	@Override
	public int getCaracteristicaEspecial2() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
