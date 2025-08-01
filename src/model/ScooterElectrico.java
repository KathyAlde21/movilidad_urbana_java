package model;

/*
 * Cada clase debe implementar sus propias versiones de mover y realizarMantenimiento,
 * con lógicas diferentes según el tipo de transporte.
 */

import interfaces.EstadisticasOperativas;
import interfaces.Recargable;

/**
 * Clase concreta que representa un scooter eléctrico.
 *
 * SRP: esta clase gestiona únicamente la lógica específica de un scooter eléctrico.
 * LSP: un ScooterElectrico puede sustituir a un VehiculoTransporte sin alterar el comportamiento del sistema.
 * OCP: permite agregar nuevos vehículos eléctricos sin modificar esta clase.
 */
public class ScooterElectrico extends VehiculoTransporte implements Recargable, EstadisticasOperativas {

    private double nivelBateria;       // porcentaje de carga (%).
    private double consumoKwhPorKm;    // consumo energético en kWh por kilómetro.

    /* ----------------------------------------------------------------------------- */
    /**
     * Constructor de ScooterElectrico.
     *
     * @param id               Identificador único del scooter.
     * @param velocidadMaxima  Velocidad máxima en km/h.
     * @param ubicacionActual  Ubicación inicial del scooter.
     * @param nivelBateria     Nivel inicial de batería (%).
     * @param consumoKwhPorKm  Consumo energético en kWh por km.
     */
    public ScooterElectrico(String id, double velocidadMaxima, String ubicacionActual,
                            double nivelBateria, double consumoKwhPorKm) {
        super(id, 1, velocidadMaxima, ubicacionActual);
        this.nivelBateria = nivelBateria;
        this.consumoKwhPorKm = consumoKwhPorKm;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Mueve el scooter a una nueva ubicación.
     */
    @Override
    public void mover(String nuevaUbicacion) {
        System.out.println("Scooter " + getId() + " se desliza de " + getUbicacionActual() + " a " + nuevaUbicacion + ".");
        setUbicacionActual(nuevaUbicacion);
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Recarga la batería del scooter al máximo.
     */
    @Override
    public void recargarEnergia() {
        System.out.println("Recargando batería del scooter " + getId() + " al 100%. ");
        this.nivelBateria = 100.0;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Realiza el mantenimiento específico del scooter.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.println("Realizando revisión de frenos y luces del scooter " + getId() + ".");
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Calcula el consumo energético del scooter por km.
     *
     * @return Consumo en kWh para 1 km.
     */
    @Override
    public double calcularConsumoEnergetico() {
        double consumo = consumoKwhPorKm * 1;
        System.out.println("Consumo energético scooter " + getId() + ": " + consumo + " kWh.");
        return consumo;
    }
    
    /* ----------------------------------------------------------------------------- */
    /**
     * Genera un reporte de uso del scooter.
     *
     * @return Resumen de ubicación y nivel de batería.
     */
    @Override
    public String generarReporteUso() {
        return "Reporte Scooter " + getId() + ": ubicación=" + getUbicacionActual() +
               ", nivel batería=" + nivelBateria + "%";
    }

    /* ----------------------------------------------------------------------------- */
    // Getters y Setters
	/**
	 * @return the nivelBateria
	 */
	public double getNivelBateria() {
		return nivelBateria;
	}

	/**
	 * @param nivelBateria the nivelBateria to set
	 */
	public void setNivelBateria(double nivelBateria) {
		this.nivelBateria = nivelBateria;
	}

	/**
	 * @return the consumoKwhPorKm
	 */
	public double getConsumoKwhPorKm() {
		return consumoKwhPorKm;
	}

	/**
	 * @param consumoKwhPorKm the consumoKwhPorKm to set
	 */
	public void setConsumoKwhPorKm(double consumoKwhPorKm) {
		this.consumoKwhPorKm = consumoKwhPorKm;
	}
}
