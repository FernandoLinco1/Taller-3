package tallerPOO3;

public class HechizoTipoAgua extends Hechizo {
	private int CantidadHeal;
	private int PresionDelAgua;
	public HechizoTipoAgua(String nombreHechizo, String tipo, int daño, int cantidadHeal, int presionDelAgua) {
		super(nombreHechizo, tipo, daño);
		CantidadHeal = cantidadHeal;
		PresionDelAgua = presionDelAgua;
	}
	@Override
	public int calcularPuntaje() {
		//Puntaje = (Daño+CantidadHeal+PresionDeAgua)*2
		return (getDaño()+CantidadHeal+PresionDelAgua)*2;
	}
	@Override
	public void setCaracteristicaEspecial1(int valor) {
		CantidadHeal =valor;
		
	}
	@Override
	public void setCaracteristicaEspecial2(int valor) {
		PresionDelAgua = valor;
		
	}
	@Override
	public int getCaracteristicaEspecial1() {
		// TODO Auto-generated method stub
		return CantidadHeal;
	}
	@Override
	public int getCaracteristicaEspecial2() {
		// TODO Auto-generated method stub
		return PresionDelAgua;
	}
	
	
}
