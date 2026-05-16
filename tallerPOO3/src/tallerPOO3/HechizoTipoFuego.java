package tallerPOO3;

public class HechizoTipoFuego extends Hechizo{
	private int DuracionQuemadura;
	public HechizoTipoFuego(String nombreHechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipo, daño);
		DuracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return DuracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		DuracionQuemadura = duracionQuemadura;
	}

	@Override
	public int calcularPuntaje() {
		// Puntaje = Daño*DuracionQuemadura
		return daño*DuracionQuemadura;
	}
	
}
