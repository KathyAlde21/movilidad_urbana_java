package simulacion;
/*
 * Crear una clase SimuladorRecorrido que reciba vehículos y rutas, y que simule
 *  el movimiento de los vehículos, registrando el consumo y actualizando la ubicación.
 */
import model.VehiculoTransporte;
import interfaces.Combustible;
import interfaces.EstadisticasOperativas;
import interfaces.Recargable;

/**
 * Clase encargada de simular recorridos de vehículos sobre rutas.
 *
 * SRP: esta clase solo gestiona la simulación (movimiento, cálculo de consumo y generación de reportes).
 * DIP: depende de las abstracciones EstadisticasOperativas, Combustible y Recargable.
 */

public class SimuladorRecorrido {
	/**
     * Simula el recorrido de un vehículo en una ruta dada.
     *
     * @param vehiculo Vehículo a simular.
     * @param ruta     Ruta urbana que recorrerá el vehículo.
     */
    public void simularRecorrido(VehiculoTransporte vehiculo, Ruta ruta) {
        System.out.println("\n--- Iniciando simulación de recorrido ---");
        System.out.println("Vehículo: " + vehiculo.getId());
        System.out.println("Ruta: " + ruta.toString());

        // Mover el vehículo a la ubicación final de la ruta
        vehiculo.mover(ruta.getDestino());

        // Calcular consumo unitario (por km)
        double consumoUnitario = ((EstadisticasOperativas) vehiculo).calcularConsumoEnergetico();
        double consumoTotal = consumoUnitario * ruta.getDistanciaKm();

        // Mostrar tipo de energía/combustible
        String unidad = "";
        if (vehiculo instanceof Combustible) {
            unidad = " litros";
        } else if (vehiculo instanceof Recargable) {
            unidad = " kWh";
        }

        System.out.println("Consumo total estimado: " + consumoTotal + unidad);

        // Generar y mostrar reporte de uso
        String reporte = ((EstadisticasOperativas) vehiculo).generarReporteUso();
        System.out.println(reporte);
        System.out.println("--- Fin simulación ---\n");
    }
}
