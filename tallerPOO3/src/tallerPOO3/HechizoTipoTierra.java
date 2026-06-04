package tallerPOO3;

public class HechizoTipoTierra extends Hechizo{
	private int MejoraDefensa;
	public HechizoTipoTierra(String nombreHechizo, String tipo, int daño, int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		MejoraDefensa = mejoraDefensa;
	}
	@Override
	public int calcularPuntaje() {
		//  Puntaje = (Daño*MejoraDefensa)/2
		return (getDaño()*MejoraDefensa)/2;
	}
	@Override
	public void setCaracteristicaEspecial1(int valor) {
		MejoraDefensa = valor;
		
	}
	@Override
	public void setCaracteristicaEspecial2(int valor) {}
	@Override
	public int getCaracteristicaEspecial1() {
		// TODO Auto-generated method stub
		return MejoraDefensa;
	}
	@Override
	public int getCaracteristicaEspecial2() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
