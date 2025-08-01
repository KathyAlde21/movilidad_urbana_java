package interfaces;

/**
 * Interface para la generación de estadísticas operativas de un vehículo.
 *
 * DIP: las capas superiores dependen de esta abstracción para calcular consumos y reportes.
 */
public interface EstadisticasOperativas {
    /**
     * Calcula el consumo energético o de combustible en función de parámetros internos.
     *
     * @return consumo estimado (kWh o litros).
     */
    double calcularConsumoEnergetico();

    /**
     * Genera un reporte de uso (distancia recorrida, tiempo, consumo).
     *
     * @return String con el resumen del reporte.
     */
    String generarReporteUso();
}
