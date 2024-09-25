package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Cliente;
import com.ingenieria_de_software.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente añadirCliente(@RequestBody Cliente cliente) {
        return clienteService.añadirCliente(cliente);
    }

    @GetMapping
    public List<Cliente> obtenerTodosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {
        return clienteService.obtenerClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id) {
        clienteService.eliminarClientePorId(id);
    }
}
