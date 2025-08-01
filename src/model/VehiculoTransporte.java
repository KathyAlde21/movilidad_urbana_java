package model;

/*
 * Crear una clase abstracta VehiculoTransporte que contenga al menos los siguientes atributos: 
 * - id (String)
 * - capacidadPasajeros (int)
 * - velocidadMaxima (double)
 * - ubicacionActual (String)
 * Incluir métodos abstractos como:
 * - mover(String nuevaUbicacion)
 * - realizarMantenimiento()
 */

/**
 * Clase abstracta que representa un vehículo de transporte en el sistema.
 *
 * SRP: Single Responsibility Principle - esta clase solo define propiedades y 
 * comportamientos básicos de un vehículo.
 * OCP: Open/Closed Principle - permite la extensión mediante herencia sin modificar esta clase.
 * DIP: Dependency Inversion Principle - las capas superiores dependen de esta 
 * abstracción en lugar de implementaciones concretas.
 */

public abstract class VehiculoTransporte {

    private String id;
    private int capacidadPasajeros;
    private double velocidadMaxima;
    private String ubicacionActual;

    /**
     * Constructor de VehiculoTransporte.
     *
     * @param id                   Identificador único del vehículo.
     * @param capacidadPasajeros   Número máximo de pasajeros.
     * @param velocidadMaxima      Velocidad máxima en km/h.
     * @param ubicacionActual      Ubicación actual del vehículo.
     */
    
    public VehiculoTransporte(String id, int capacidadPasajeros, double velocidadMaxima, String ubicacionActual) {
        this.id = id;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.ubicacionActual = ubicacionActual;
    }

    
    /* ----------------------------------------------------------------------------- */
    // Getters y Setters
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the capacidadPasajeros
	 */
	public int getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	/**
	 * @param capacidadPasajeros the capacidadPasajeros to set
	 */
	public void setCapacidadPasajeros(int capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}

	/**
	 * @return the velocidadMaxima
	 */
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * @param velocidadMaxima the velocidadMaxima to set
	 */
	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * @return the ubicacionActual
	 */
	public String getUbicacionActual() {
		return ubicacionActual;
	}

	/**
	 * @param ubicacionActual the ubicacionActual to set
	 */
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
	
	/* ----------------------------------------------------------------------------- */
	/**
     * Mueve el vehículo a una nueva ubicación.
     *
     * @param nuevaUbicacion Ubicación a la que se moverá el vehículo.
     */
    public abstract void mover(String nuevaUbicacion);

    /**
     * Realiza el mantenimiento específico del vehículo.
     */
    public abstract void realizarMantenimiento();
}
