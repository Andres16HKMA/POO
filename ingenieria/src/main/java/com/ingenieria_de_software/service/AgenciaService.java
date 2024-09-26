package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Agencia;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    // Una lista simulada para almacenar las agencias
    private List<Agencia> agencias;

    // Constructor
    public AgenciaService() {
        this.agencias = new ArrayList<>();
    }

    // Método para añadir una agencia
    public Agencia añadirAgencia(Agencia agencia) {
        agencias.add(agencia);
        return agencia;
    }

    // Método para obtener una lista de todas las agencias
    public List<Agencia> obtenerTodasLasAgencias() {
        return agencias;
    }

    // Método para obtener una agencia por su ID
    public Agencia obtenerAgenciaPorId(int id) {
        for (Agencia agencia : agencias) {
            if (agencia.getId() == id) {
                return agencia;
            }
        }
        return null; // Devuelve null si no se encuentra la agencia con el ID dado
    }

    // Método para actualizar una agencia
    public boolean actualizarAgencia(Agencia agenciaActualizada) {
        for (int i = 0; i < agencias.size(); i++) {
            Agencia agencia = agencias.get(i);
            if (agencia.getId() == agenciaActualizada.getId()) {
                agencias.set(i, agenciaActualizada);
                return true; // Actualización exitosa
            }
        }
        return false; // No se encontró la agencia para actualizar
    }

    // Método para eliminar una agencia por su ID
    public boolean eliminarAgenciaPorId(int id) {
        return agencias.removeIf(agencia -> agencia.getId() == id);
    }

    // Método para eliminar una agencia por instancia
    public void eliminarAgencia(int id) {
        agencias.remove(id);
    }
}
