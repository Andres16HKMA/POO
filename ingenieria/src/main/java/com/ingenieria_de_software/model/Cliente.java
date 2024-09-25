package com.ingenieria_de_software.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    // Atributos
    private int id;
    private int dni;
    private String nombre;
    private String direccion;
    private int telefono;
    private Cliente avalador;  // Cliente que es avalador de este cliente
    private List<Reserva> listReservas;

    // Constructor
    public Cliente(int id, int dni, String nombre, String direccion, int telefono, Cliente avalador) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.avalador = avalador;
        this.listReservas = new ArrayList<>();
    }

    // Métodos
    public void realizarReserva(Reserva reserva) {
        this.listReservas.add(reserva);
        System.out.println("Reserva realizada con éxito.");
    }

    public void cancelarReserva(int id) {
        this.listReservas.removeIf(reserva -> reserva.getId() == id);
        System.out.println("Reserva cancelada.");
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Cliente getAvalador() {
        return avalador;
    }

    public void setAvalador(Cliente avalador) {
        this.avalador = avalador;
    }

    public List<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }
}

