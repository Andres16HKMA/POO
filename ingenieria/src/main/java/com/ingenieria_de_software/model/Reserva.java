package com.ingenieria_de_software.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    // Atributos
    private int id;
    private Cliente cliente;
    private LocalDateTime fechaDeInicio;
    private LocalDateTime fechaFinal;
    private Agencia agencia;
    private List<Coche_X_Reserva> listCoches;

    // Constructor
    public Reserva(int id, Cliente cliente, LocalDateTime fechaDeInicio, LocalDateTime fechaFinal, Agencia agencia) {
        this.id = id;
        this.cliente = cliente;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaFinal = fechaFinal;
        this.agencia = agencia;
        this.listCoches = new ArrayList<>();
    }
    // Métodos
    // arregla este metodo calcular precio

    public double calcularPrecio() {
        double precioTotal = 0.0;
        for (Coche_X_Reserva coche : listCoches) {
            precioTotal += coche.getCoche().getPrecio();
        }
        return precioTotal;
    }

    public void checkEntregado() {
        boolean todosEntregados = true;
        for (Coche_X_Reserva coche : listCoches) {
            if (!coche.isEntregado()) {
                todosEntregados = false;
                break;
            }
        }
        if (todosEntregados) {
            System.out.println("Todos los coches han sido entregados.");
        } else {
            System.out.println("Aún quedan coches por entregar.");
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDateTime fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Coche_X_Reserva> getListCoches() {
        return listCoches;
    }

    public void setListCoches(List<Coche_X_Reserva> listCoches) {
        this.listCoches = listCoches;
    }
}

