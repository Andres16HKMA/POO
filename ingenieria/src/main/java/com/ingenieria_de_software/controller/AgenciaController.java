package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Agencia;
import com.ingenieria_de_software.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/public/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @PostMapping
    public Agencia añadirAgencia(@RequestBody Agencia agencia) {
        return agenciaService.añadirAgencia(agencia);
    }

    @GetMapping
    public List<Agencia> obtenerTodasAgencias() {
        return agenciaService.obtenerTodasLasAgencias();
    }

    @GetMapping("/{id}")
    public Agencia obtenerAgenciaPorId(@PathVariable int id) {
        return agenciaService.obtenerAgenciaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAgencia(@PathVariable int id) {
        agenciaService.eliminarAgencia(id);
    }
}
