package tallerPOO3;

public class HechizoTipoTierra extends Hechizo{
	private int MejoraDefensa;
	public HechizoTipoTierra(String nombreHechizo, String tipo, int daño, int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		MejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return MejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		MejoraDefensa = mejoraDefensa;
	}

	@Override
	public int calcularPuntaje() {
		//  Puntaje = (Daño*MejoraDefensa)/2
		return (getDaño()*MejoraDefensa)/2;
	}
	
}
