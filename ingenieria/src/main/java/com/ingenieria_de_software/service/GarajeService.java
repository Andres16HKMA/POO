package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Coche;
import com.ingenieria_de_software.model.Garaje;

public class GarajeService {

    // Lista para almacenar los garajes
    private List<Garaje> garajes;

    // Constructor
    public GarajeService() {
        this.garajes = new ArrayList<>();
    }

    // Método para añadir un garaje
    public Garaje añadirGaraje(Garaje garaje) {
        garajes.add(garaje);
        return garaje;
    }

    // Método para obtener todos los garajes
    public List<Garaje> obtenerTodosLosGarajes() {
        return garajes;
    }

    // Método para obtener un garaje por su ID
    public Garaje obtenerGarajePorId(int id) {
        for (Garaje garaje : garajes) {
            if (garaje.getId() == id) {
                return garaje;
            }
        }
        return null;  // Devuelve null si no se encuentra el garaje
    }

    // Método para eliminar un garaje por su ID
    public boolean eliminarGarajePorId(int id) {
        return garajes.removeIf(garaje -> garaje.getId() == id);
    }

    // Método para añadir un coche a un garaje específico
    public void añadirCocheAGaraje(int garajeId, Coche coche) {
        Garaje garaje = obtenerGarajePorId(garajeId);
        if (garaje != null) {
            garaje.añadirCoche(coche);
        } else {
            System.out.println("Garaje no encontrado.");
        }
    }

    // Método para remover un coche de un garaje específico
    public void removerCocheDeGaraje(int garajeId, Coche coche) {
        Garaje garaje = obtenerGarajePorId(garajeId);
        if (garaje != null) {
            garaje.removerCoche(coche);
        } else {
            System.out.println("Garaje no encontrado.");
        }
    }

    // Método para obtener todos los coches en un garaje específico
    public List<Coche> obtenerCochesDeGaraje(int garajeId) {
        Garaje garaje = obtenerGarajePorId(garajeId);
        if (garaje != null) {
            return garaje.getCoches();
        }
        System.out.println("Garaje no encontrado.");
        return null;
    }

    // Método para actualizar la dirección de un garaje
    public boolean actualizarDireccionGaraje(int id, String nuevaDireccion) {
        Garaje garaje = obtenerGarajePorId(id);
        if (garaje != null) {
            garaje.setDireccion(nuevaDireccion);
            return true;
        }
        return false;
    }
}
