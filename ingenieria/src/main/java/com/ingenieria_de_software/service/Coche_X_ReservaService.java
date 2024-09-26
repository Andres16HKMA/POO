package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Coche_X_Reserva;
import com.ingenieria_de_software.model.Coche;
import com.ingenieria_de_software.model.Reserva;
import java.util.Date;
import org.springframework.stereotype.Service;


@Service
public class Coche_X_ReservaService {

    // Lista para almacenar las asociaciones coche-reserva
    private List<Coche_X_Reserva> cochesXReserva;

    // Constructor
    public Coche_X_ReservaService() {
        this.cochesXReserva = new ArrayList<>();
    }

    // Método para añadir una nueva relación Coche-Reserva
    public Coche_X_Reserva añadirCocheXReserva(Coche_X_Reserva cocheXReserva) {
        cochesXReserva.add(cocheXReserva);
        System.out.println("Coche añadido a la reserva.");
        return cocheXReserva;
    }

    // Método para obtener todas las relaciones Coche-Reserva
    public List<Coche_X_Reserva> obtenerTodasLasCocheXReserva() {
        return cochesXReserva;
    }

    // Método para buscar una relación Coche-Reserva por ID
    public Coche_X_Reserva obtenerCocheXReservaPorId(int id) {
        for (Coche_X_Reserva cocheXReserva : cochesXReserva) {
            if (cocheXReserva.getId() == id) {
                return cocheXReserva;
            }
        }
        return null;
    }

    // Método para eliminar una relación Coche-Reserva por su ID
    public boolean eliminarCocheXReservaPorId(int id) {
        return cochesXReserva.removeIf(cocheXReserva -> cocheXReserva.getId() == id);
    }

    // Método para asignar un coche a una reserva
    public void asignarCocheAReserva(int cocheXReservaId, Coche coche, Reserva reserva, Date fechaReserva) {
        Coche_X_Reserva cocheXReserva = obtenerCocheXReservaPorId(cocheXReservaId);
        if (cocheXReserva != null) {
            cocheXReserva.setCoche(coche);
            cocheXReserva.setReserva(reserva);
            cocheXReserva.setFechaReserva(fechaReserva);
            System.out.println("Coche y reserva asignados.");
        } else {
            System.out.println("No se encontró la relación Coche-Reserva.");
        }
    }

    // Método para marcar un coche como entregado
    public void marcarCocheComoEntregado(int cocheXReservaId, Coche coche) {
        Coche_X_Reserva cocheXReserva = obtenerCocheXReservaPorId(cocheXReservaId);
        if (cocheXReserva != null && cocheXReserva.Entregado(coche)) {
            cocheXReserva.setEntregado(true);
            System.out.println("Coche marcado como entregado.");
        } else {
            System.out.println("No se pudo marcar el coche como entregado.");
        }
    }

    // Método para verificar si un coche ha sido entregado en una relación específica
    public boolean verificarEntrega(int cocheXReservaId) {
        Coche_X_Reserva cocheXReserva = obtenerCocheXReservaPorId(cocheXReservaId);
        if (cocheXReserva != null) {
            return cocheXReserva.isEntregado();
        } else {
            System.out.println("No se encontró la relación Coche-Reserva.");
            return false;
        }
    }
}
