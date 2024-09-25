package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Coche;
import com.ingenieria_de_software.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @PostMapping
    public Coche añadirCoche(@RequestBody Coche coche) {
        return cocheService.añadirCoche(coche);
    }

    @GetMapping
    public List<Coche> obtenerTodosCoches() {
        return cocheService.obtenerTodosLosCoches();
    }

    @GetMapping("/{id}")
    public Coche obtenerCochePorId(@PathVariable int id) {
        return cocheService.obtenerCochePorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCoche(@PathVariable int id) {
        cocheService.eliminarCochePorId(id);
    }

    @PutMapping("/{id}/gasolina")
    public void actualizarGasolina(@PathVariable int id, @RequestParam double litros) {
        cocheService.actualizarLitrosGasolina(id, litros);
    }

    @GetMapping("/{id}/precioAlquiler")
    public double calcularPrecioAlquiler(@PathVariable int id, @RequestParam int dias) {
        return cocheService.calcularPrecioAlquiler(id, dias);
    }
}

