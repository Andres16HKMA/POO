package com.ingenieria_de_software.service;

import java.util.ArrayList;
import java.util.List;
import com.ingenieria_de_software.model.Cliente;
import com.ingenieria_de_software.model.Reserva;

public class ClienteService {

    // Lista simulada para almacenar los clientes
    private List<Cliente> clientes;

    // Constructor
    public ClienteService() {
        this.clientes = new ArrayList<>();
    }

    // Método para añadir un cliente
    public Cliente añadirCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Devuelve null si no se encuentra el cliente con el ID dado
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId() == clienteActualizado.getId()) {
                clientes.set(i, clienteActualizado);
                return true; // Actualización exitosa
            }
        }
        return false; // No se encontró el cliente para actualizar
    }

    // Método para eliminar un cliente por su ID
    public boolean eliminarClientePorId(int id) {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Método para realizar una reserva
    public void realizarReserva(int idCliente, Reserva reserva) {
        Cliente cliente = obtenerClientePorId(idCliente);
        if (cliente != null) {
            cliente.realizarReserva(reserva);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Método para cancelar una reserva por ID de reserva
    public void cancelarReserva(int idCliente, int idReserva) {
        Cliente cliente = obtenerClientePorId(idCliente);
        if (cliente != null) {
            cliente.cancelarReserva(idReserva);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}

