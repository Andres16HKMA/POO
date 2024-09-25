package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Reserva; // Ensure this import statement is correct and the Reserva class exists in the specified package
import com.ingenieria_de_software.model.Coche_X_Reserva;
import com.ingenieria_de_software.model.Cliente;
import com.ingenieria_de_software.model.Agencia;
import java.time.LocalDateTime;

public class ReservaService {

    // Lista para almacenar las reservas
    private List<Reserva> reservas;

    // Constructor
    public ReservaService() {
        this.reservas = new ArrayList<>();
    }

    // Método para añadir una reserva
    public Reserva añadirReserva(Reserva reserva) {
        reservas.add(reserva);
        return reserva;
    }

    // Método para obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        return reservas;
    }

    // Método para obtener una reserva por su ID
    public Reserva obtenerReservaPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    // Método para eliminar una reserva por su ID
    public boolean eliminarReservaPorId(int id) {
        return reservas.removeIf(reserva -> reserva.getId() == id);
    }

    // Método para agregar un coche a una reserva
    public void añadirCocheAReserva(int reservaId, Coche_X_Reserva cocheXReserva) {
        Reserva reserva = obtenerReservaPorId(reservaId);
        if (reserva != null) {
            reserva.getListCoches().add(cocheXReserva);
            System.out.println("Coche añadido a la reserva.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    // Método para calcular el precio total de una reserva
    public double calcularPrecioReserva(int reservaId) {
        Reserva reserva = obtenerReservaPorId(reservaId);
        if (reserva != null) {
            return reserva.calcularPrecio();
        } else {
            System.out.println("Reserva no encontrada.");
            return 0.0;
        }
    }

    // Método para verificar si todos los coches han sido entregados
    public void verificarEntregaCoches(int reservaId) {
        Reserva reserva = obtenerReservaPorId(reservaId);
        if (reserva != null) {
            reserva.checkEntregado();
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    // Método para crear una nueva reserva
    public Reserva crearNuevaReserva(int id, Cliente cliente, LocalDateTime fechaDeInicio, LocalDateTime fechaFinal, Agencia agencia) {
        Reserva nuevaReserva = new Reserva(id, cliente, fechaDeInicio, fechaFinal, agencia);
        añadirReserva(nuevaReserva);
        return nuevaReserva;
    }

}
