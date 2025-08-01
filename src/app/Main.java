package app;

/*
 * Implementar un programa principal (main) donde:
 * - Se cree un conjunto de vehículos variados.
 * - Se creen rutas urbanas. o Se asigne cada vehículo a una ruta.
 * - Se simule su movimiento, consumo de energía o combustible y se genere 
 * un reporte final con el resumen del recorrido.
 */

import model.AutobusDiesel;
import model.TrenElectrico;
import model.ScooterElectrico;
import model.BicicletaMecanica;
import model.VehiculoTransporte;
import simulacion.Ruta;
import simulacion.SimuladorRecorrido;

/**
 * Clase principal para ejecutar simulaciones de movilidad urbana inteligente.
 *
 * SRP: esta clase solo se encarga de orquestar la creación de objetos y ejecutar la simulación.
 * DIP: depende de la abstracción VehiculoTransporte y SimuladorRecorrido, no de implementaciones concretas.
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("=== Simulador de Movilidad Urbana Inteligente ===\n");

        // Creación de vehículos (ejemplo de polimorfismo)
        VehiculoTransporte bus = new AutobusDiesel("BUS-01", 50, 80.0, "Terminal A", 80.0, 0.2);
        VehiculoTransporte tren = new TrenElectrico("TR-01", 200, 120.0, "Estación Central", 90.0, 1.5);
        VehiculoTransporte scooter = new ScooterElectrico("SC-01", 25.0, "Punto A", 60.0, 0.05);
        VehiculoTransporte bicicleta = new BicicletaMecanica("BI-01", 15.0, "Parque", 21);

        // Creación de rutas
        Ruta rutaCorta = new Ruta("Terminal A", "Plaza Principal", 5.0, 10);
        Ruta rutaMedia = new Ruta("Estación Central", "Museo de Arte", 10.0, 20);
        Ruta rutaLocal = new Ruta("Punto A", "Punto B", 2.5, 5);
        Ruta rutaRecreativa = new Ruta("Parque", "Zona Deportiva", 3.0, 8);

        // Simulador
        SimuladorRecorrido simulador = new SimuladorRecorrido();

        // Simulaciones
        simulador.simularRecorrido(bus, rutaCorta);
        simulador.simularRecorrido(tren, rutaMedia);
        simulador.simularRecorrido(scooter, rutaLocal);
        simulador.simularRecorrido(bicicleta, rutaRecreativa);

        System.out.println("=== Fin de todas las simulaciones ===");
    }
}
