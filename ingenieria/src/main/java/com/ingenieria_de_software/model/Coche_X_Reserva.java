package com.ingenieria_de_software.model;
import java.util.Date;

public class Coche_X_Reserva {

    // Atributos privados de la clase
    private int id;
    private Coche coche;
    private Reserva reserva;
    private Date fechaReserva;
    //inicializa en false
    private boolean entregado = false;

    // Constructor
    public Coche_X_Reserva(int id, Coche coche, Reserva reserva, Date fechaReserva, Boolean entregado) {
        this.id = id;
        this.coche = coche;
        this.reserva = reserva;
        this.fechaReserva = fechaReserva;
    }

    // Método para añadir un coche
    public void añadirCoche(Coche coche) {
        this.coche = coche;
    }

    // Método para remover un coche
    public void removerCoche(Coche coche) {
        if (this.coche.equals(coche)) {
            this.coche = null;  // Remover el coche asignado
        }
    }

    // Método para añadir una reserva
    public void añadirReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    // Método para remover una reserva
    public void removerReserva(Reserva reserva) {
        if (this.reserva.equals(reserva)) {
            this.reserva = null;  // Remover la reserva asignada
        }
    }

    // Métodos getter y setter para los atributos (si son necesarios)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public boolean Entregado(Coche coche) {
        // usa el metodo del coche set disponible y ponlo false
        if (this.coche.equals(coche)) {
            this.coche.setDisponible(false);
            return true;
        }
        // set el entregado de esta clase en true
        this.entregado = true;
        return false;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}