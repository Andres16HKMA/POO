package com.ingenieria_de_software.model;
public class Coche {

    // Atributos privados de la clase
    private int id;
    private double precio;
    private String color;
    private String matricula;
    private String modelo;
    private String marca;
    private double combustible;
    private boolean disponible;
    private Garaje garaje; // Asociación con la clase Garaje

    // Constructor
    public Coche(int id, double precio, String color, String matricula, String modelo, String marca, double combustible,Boolean disponible, Garaje garaje) {
        this.id = id;
        this.precio = precio;
        this.color = color;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.combustible = combustible;
        this.disponible = disponible;
        this.garaje = garaje;
    }

    // Método para actualizar los litros de gasolina
    public void actualizarLitrosGasolina(Double litros) {
        this.combustible += litros;
    }

    // Método para calcular el precio del alquiler
    public Double calcularPrecioAlquiler(int dias) {
        return dias * precio;  // Suponiendo que el precio es por día
    }

    // Métodos getter y setter para los atributos (si son necesarios)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

