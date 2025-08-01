package model;

/*
 * Cada clase debe implementar sus propias versiones de mover y realizarMantenimiento,
 * con lógicas diferentes según el tipo de transporte.
 */

import interfaces.Combustible;
import interfaces.EstadisticasOperativas;
/**
 * Clase concreta que representa un autobús diésel.
 *
 * SRP: esta clase se encarga únicamente del comportamiento específico de un autobús diésel.
 * LSP: un AutobusDiesel puede sustituir a un VehiculoTransporte sin alterar el correcto funcionamiento del sistema.
 * OCP: se pueden agregar nuevos tipos de vehículos sin modificar esta clase.
 */

public class AutobusDiesel extends VehiculoTransporte implements Combustible, EstadisticasOperativas {

    private double nivelCombustible;      // litros disponibles
    private double consumoLitrosPorKm;    // litros consumidos por km

    /* ----------------------------------------------------------------------------- */
    /**
     * Constructor de AutobusDiesel.
     *
     * @param id                  Identificador único del autobús.
     * @param capacidadPasajeros  Capacidad máxima de pasajeros.
     * @param velocidadMaxima     Velocidad máxima en km/h.
     * @param ubicacionActual     Ubicación inicial del autobús.
     * @param nivelCombustible    Nivel inicial de combustible en litros.
     * @param consumoLitrosPorKm  Consumo estimado en litros por km.
     */
    public AutobusDiesel(String id, int capacidadPasajeros, double velocidadMaxima,
                         String ubicacionActual, double nivelCombustible, double consumoLitrosPorKm) {
        super(id, capacidadPasajeros, velocidadMaxima, ubicacionActual);
        this.nivelCombustible = nivelCombustible;
        this.consumoLitrosPorKm = consumoLitrosPorKm;
    }

    /**
     * Mueve el autobús a una nueva ubicación.
     * SRP: solo gestiona el cambio de ubicación.
     *
     * @param nuevaUbicacion Nueva ubicación del autobús.
     */
    @Override
    public void mover(String nuevaUbicacion) {
        System.out.println("Autobús " + getId() + " se mueve de " + getUbicacionActual() + " a " + nuevaUbicacion + ".");
        setUbicacionActual(nuevaUbicacion);
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Reposta combustible al autobús.
     * ISP: separa la lógica de repostaje de otras responsabilidades.
     */
    @Override
    public void repostarCombustible() {
        System.out.println("Repostando combustible del autobús " + getId() + " al nivel máximo.");
        this.nivelCombustible = 100.0; // suposición de tanque de 100 litros
    }
    
    /* ----------------------------------------------------------------------------- */
    /**
     * Realiza el mantenimiento específico del autobús.
     */
    @Override
    public void realizarMantenimiento() {
        System.out.println("Realizando mantenimiento preventivo del autobús " + getId() + ".");
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Calcula el consumo de combustible.
     * DIP: las capas superiores usan esta abstracción para obtener datos de consumo.
     *
     * @return Consumo estimado en litros (por km).
     */
    @Override
    public double calcularConsumoEnergetico() {
        double consumo = consumoLitrosPorKm * 1; // cálculo simplificado para 1 km
        System.out.println("Consumo estimado del autobús " + getId() + ": " + consumo + " litros.");
        return consumo;
    }

    /* ----------------------------------------------------------------------------- */
    /**
     * Genera un reporte de uso del autobús.
     *
     * @return String con el resumen de la ubicación y nivel de combustible.
     */
    @Override
    public String generarReporteUso() {
        return "Reporte Autobús " + getId() + ": ubicación actual = " + getUbicacionActual() +
               ", nivel combustible = " + nivelCombustible + " litros.";
    }

    /* ----------------------------------------------------------------------------- */
    // Getters y Setters
	/**
	 * @return the nivelCombustible
	 */
	public double getNivelCombustible() {
		return nivelCombustible;
	}

	/**
	 * @param nivelCombustible the nivelCombustible to set
	 */
	public void setNivelCombustible(double nivelCombustible) {
		this.nivelCombustible = nivelCombustible;
	}

	/**
	 * @return the consumoLitrosPorKm
	 */
	public double getConsumoLitrosPorKm() {
		return consumoLitrosPorKm;
	}

	/**
	 * @param consumoLitrosPorKm the consumoLitrosPorKm to set
	 */
	public void setConsumoLitrosPorKm(double consumoLitrosPorKm) {
		this.consumoLitrosPorKm = consumoLitrosPorKm;
	}
}
