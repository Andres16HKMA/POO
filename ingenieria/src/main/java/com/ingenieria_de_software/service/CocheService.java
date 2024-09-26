package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Coche;
import org.springframework.stereotype.Service;


@Service
public class CocheService {

    // Lista simulada para almacenar los coches
    private List<Coche> coches;

    // Constructor
    public CocheService() {
        this.coches = new ArrayList<>();
    }

    // Método para añadir un coche
    public Coche añadirCoche(Coche coche) {
        coches.add(coche);
        return coche;
    }

    // Método para obtener todos los coches
    public List<Coche> obtenerTodosLosCoches() {
        return coches;
    }

    // Método para obtener un coche por su ID
    public Coche obtenerCochePorId(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                return coche;
            }
        }
        return null;  // Devuelve null si no se encuentra el coche con el ID dado
    }

    // Método para actualizar un coche
    public boolean actualizarCoche(Coche cocheActualizado) {
        for (int i = 0; i < coches.size(); i++) {
            Coche coche = coches.get(i);
            if (coche.getId() == cocheActualizado.getId()) {
                coches.set(i, cocheActualizado);
                return true;  // Actualización exitosa
            }
        }
        return false;  // No se encontró el coche para actualizar
    }

    // Método para eliminar un coche por su ID
    public boolean eliminarCochePorId(int id) {
        return coches.removeIf(coche -> coche.getId() == id);
    }

    // Método para calcular el precio de alquiler de un coche
    public Double calcularPrecioAlquiler(int id, int dias) {
        Coche coche = obtenerCochePorId(id);
        if (coche != null) {
            return coche.calcularPrecioAlquiler(dias);
        }
        System.out.println("Coche no encontrado.");
        return null;
    }

    // Método para actualizar los litros de gasolina de un coche
    public void actualizarLitrosGasolina(int id, double litros) {
        Coche coche = obtenerCochePorId(id);
        if (coche != null) {
            coche.actualizarLitrosGasolina(litros);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    // Método para verificar si un coche está disponible
    public boolean estaDisponible(int id) {
        Coche coche = obtenerCochePorId(id);
        if (coche != null) {
            return coche.isDisponible();
        }
        System.out.println("Coche no encontrado.");
        return false;
    }

    // Método para marcar un coche como disponible/no disponible
    public void marcarComoDisponible(int id, boolean disponible) {
        Coche coche = obtenerCochePorId(id);
        if (coche != null) {
            coche.setDisponible(disponible);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }
}
