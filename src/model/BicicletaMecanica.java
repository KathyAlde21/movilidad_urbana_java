package model;

/*
 * Cada clase debe implementar sus propias versiones de mover y realizarMantenimiento,
 * con lógicas diferentes según el tipo de transporte.
 */

import interfaces.EstadisticasOperativas;

/**
 * Clase concreta que representa una bicicleta mecánica.
 *
 * SRP: esta clase gestiona únicamente la lógica específica de una bicicleta mecánica.
 * LSP: una BicicletaMecanica puede sustituir a un VehiculoTransporte sin alterar el funcionamiento.
 * OCP: permite agregar nuevos tipos de vehículos mecánicos sin modificar esta clase.
 */
public class BicicletaMecanica extends VehiculoTransporte implements EstadisticasOperativas {

    private int numeroCambios;  // número de velocidades de la bicicleta
	
    /**
     * Constructor de BicicletaMecanica.
     *
     * @param id                  Identificador único de la bicicleta.
     * @param velocidadMaxima     Velocidad máxima en km/h.
     * @param ubicacionActual     Ubicación inicial de la bicicleta.
     * @param numeroCambios       Número de cambios (gears) disponibles.
     */
    public BicicletaMecanica(String id, double velocidadMaxima,
                             String ubicacionActual, int numeroCambios) {
        super(id, 1, velocidadMaxima, ubicacionActual);
        this.numeroCambios = numeroCambios;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Mueve la bicicleta a una nueva ubicación.
     */
    @Override
    public void mover(String nuevaUbicacion) {
        System.out.println("Bicicleta " + getId() + " rueda de "
                           + getUbicacionActual() + " a " + nuevaUbicacion + ".");
        setUbicacionActual(nuevaUbicacion);
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Realiza el mantenimiento específico de la bicicleta mecánica.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.println("Ajustando frenos y lubricando cadena de la bicicleta " + getId() + ".");
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Calcula el consumo energético de la bicicleta.
     *
     * @return siempre 0, ya que no consume energía externa.
     */
    @Override
    public double calcularConsumoEnergetico() {
        System.out.println("Consumo energético bicicleta " + getId() + ": 0 kWh (mecánica). ");
        return 0.0;
    }
    
    /* ----------------------------------------------------------------------------- */
    /**
     * Genera un reporte de uso de la bicicleta.
     *
     * @return resumen de ubicación y número de cambios.
     */
    @Override
    public String generarReporteUso() {
        return "Reporte Bicicleta " + getId() + ": ubicación=" + getUbicacionActual()
               + ", cambios=" + numeroCambios;
    }

    /* ----------------------------------------------------------------------------- */
    // Getters y Setters
	/**
	 * @return the numeroCambios
	 */
	public int getNumeroCambios() {
		return numeroCambios;
	}

	/**
	 * @param numeroCambios the numeroCambios to set
	 */
	public void setNumeroCambios(int numeroCambios) {
		this.numeroCambios = numeroCambios;
	}
}
