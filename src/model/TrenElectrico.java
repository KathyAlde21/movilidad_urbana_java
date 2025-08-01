package model;

import interfaces.EstadisticasOperativas;
import interfaces.Recargable;

/**
 * Clase concreta que representa un tren eléctrico.
 *
 * SRP: esta clase gestiona únicamente la lógica específica de un tren eléctrico.
 * LSP: un TrenElectrico puede sustituir a un VehiculoTransporte sin alterar el funcionamiento.
 * OCP: permite agregar nuevos tipos de vehículos eléctricos sin modificar esta clase.
 */
public class TrenElectrico extends VehiculoTransporte implements Recargable, EstadisticasOperativas {

	private double nivelBateria;     // porcentaje de carga (%)
    private double consumoKwhPorKm;  // consumo energético en kWh por km

    /* ----------------------------------------------------------------------------- */
    /**
     * Constructor de TrenElectrico.
     *
     * @param id                  Identificador único del tren.
     * @param capacidadPasajeros  Capacidad máxima de pasajeros.
     * @param velocidadMaxima     Velocidad máxima en km/h.
     * @param ubicacionActual     Ubicación inicial del tren.
     * @param nivelBateria        Nivel inicial de batería (%).
     * @param consumoKwhPorKm     Consumo energético en kWh por km.
     */
    public TrenElectrico(String id, int capacidadPasajeros, double velocidadMaxima,
                         String ubicacionActual, double nivelBateria, double consumoKwhPorKm) {
        super(id, capacidadPasajeros, velocidadMaxima, ubicacionActual);
        this.nivelBateria = nivelBateria;
        this.consumoKwhPorKm = consumoKwhPorKm;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Desplaza el tren a una nueva ubicación.
     */
    @Override
    public void mover(String nuevaUbicacion) {
        System.out.println("Tren eléctrico " + getId() + " se desplaza de " 
                           + getUbicacionActual() + " a " + nuevaUbicacion + ".");
        setUbicacionActual(nuevaUbicacion);
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Recarga la batería del tren.
     */
    @Override
    public void recargarEnergia() {
        System.out.println("Recargando batería del tren " + getId() + " al 100%.");
        this.nivelBateria = 100.0;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Realiza el mantenimiento específico del tren.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.println("Realizando revisión de vías y sistemas del tren " + getId() + ".");
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Calcula el consumo energético del tren por km.
     *
     * @return consumo en kWh.
     */
    @Override
    public double calcularConsumoEnergetico() {
        double consumo = consumoKwhPorKm * 1; // cálculo simplificado por 1 km
        System.out.println("Consumo energía tren " + getId() + ": " + consumo + " kWh.");
        return consumo;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Genera un reporte de uso del tren.
     *
     * @return resumen de ubicación y nivel de batería.
     */
    @Override
    public String generarReporteUso() {
        return "Reporte Tren " + getId() + ": ubicación=" + getUbicacionActual() 
               + ", nivel batería=" + nivelBateria + "%";
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
