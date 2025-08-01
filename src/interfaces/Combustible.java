package interfaces;

/**
 * Interface para vehículos que funcionan con combustible (gasolina o diésel).
 *
 * ISP: esta interfaz separa la responsabilidad de repostar combustible.
 */
public interface Combustible {
    /**
     * Reposta combustible al vehículo.
     */
    void repostarCombustible();
}
