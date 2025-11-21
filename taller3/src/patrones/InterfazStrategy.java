package patrones;

public interface InterfazStrategy {
	/**
	 * Ordena la lista de Tareas para la estrategia elegida (Fecha, impacto o complejidad).
	 * @param la variable "tareas" es la lista de tareas a ordenar.
	 */
	void orderarTareas(List<Tarea> tareas);
}
