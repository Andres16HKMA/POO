package com.ingenieria_de_software.model;
import java.util.ArrayList;
import java.util.List;

public class Garaje {

    // Atributos
    private int id;
    private String direccion;
    private List<Coche> coches;

    // Constructor
    public Garaje(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.coches = new ArrayList<>();
    }

    // Métodos
    public void añadirCoche(Coche coche) {
        if (coche != null && !coches.contains(coche)) {
            coches.add(coche);
            System.out.println("Coche añadido al garaje.");
        } else {
            System.out.println("El coche ya está en el garaje o es inválido.");
        }
    }

    public void removerCoche(Coche coche) {
        if (coches.remove(coche)) {
            System.out.println("Coche removido del garaje.");
        } else {
            System.out.println("El coche no estaba en el garaje.");
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}
