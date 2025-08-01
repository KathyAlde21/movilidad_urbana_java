package interfaces;

/**
 * Interface para vehículos que funcionan con energía eléctrica.
 *
 * ISP: Interface Segregation Principle - define solo el método necesario para recargar.
 */
public interface Recargable {
    /**
     * Recarga la energía del vehículo al máximo.
     */
    void recargarEnergia();
}
