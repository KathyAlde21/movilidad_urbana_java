package simulacion;
/*
 * Crear una clase Ruta que represente un recorrido urbano, con atributos como:
 *  origen, destino, distanciaKm, duracionEstimadaMin.
 */

/**
 * Clase que representa una ruta urbana para simular recorridos.
 *
 * SRP: esta clase solo almacena datos de la ruta (origen, destino, distancia y duración estimada).
 */
public class Ruta {

	private String origen;
    private String destino;
    private double distanciaKm;
    private int duracionEstimadaMin;

    /**
     * Constructor de Ruta.
     *
     * @param origen             Punto de inicio de la ruta.
     * @param destino            Punto final de la ruta.
     * @param distanciaKm        Distancia en kilómetros.
     * @param duracionEstimadaMin Duración estimada en minutos.
     */
    public Ruta(String origen, String destino, double distanciaKm, int duracionEstimadaMin) {
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.duracionEstimadaMin = duracionEstimadaMin;
    }

    /* ----------------------------------------------------------------------------- */
    // Getters y Setters
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the distanciaKm
	 */
	public double getDistanciaKm() {
		return distanciaKm;
	}

	/**
	 * @param distanciaKm the distanciaKm to set
	 */
	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}

	/**
	 * @return the duracionEstimadaMin
	 */
	public int getDuracionEstimadaMin() {
		return duracionEstimadaMin;
	}

	/**
	 * @param duracionEstimadaMin the duracionEstimadaMin to set
	 */
	public void setDuracionEstimadaMin(int duracionEstimadaMin) {
		this.duracionEstimadaMin = duracionEstimadaMin;
	}
	/* ----------------------------------------------------------------------------- */

	@Override
	public String toString() {
        return "Ruta {origen='" + origen + "', destino='" + destino + "', distanciaKm=" + distanciaKm
                + ", duracionEstimadaMin=" + duracionEstimadaMin + "}";	}
	
}
