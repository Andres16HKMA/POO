package com.ingenieria_de_software.model;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Agencia {

    // Atributos privados de la clase
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Reserva> listReservas;

    // Constructor
    public Agencia(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listReservas = new ArrayList<>();
    }

    public Agencia(JSONObject jsonObj) {
        //TODO Auto-generated constructor stub
    }

    // Método para añadir una reserva
    public void añadirReserva(Reserva reserva) {
        listReservas.add(reserva);
    }

    // Método para remover una reserva
    public void removerReserva(Reserva reserva) {
        listReservas.remove(reserva);
    }

    // Métodos getter y setter para los atributos (si son necesarios)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }
}