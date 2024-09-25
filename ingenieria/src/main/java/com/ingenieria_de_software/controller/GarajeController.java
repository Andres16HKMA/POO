package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Garaje;
import com.ingenieria_de_software.service.GarajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garajes")
public class GarajeController {

    @Autowired
    private GarajeService garajeService;

    @PostMapping
    public Garaje añadirGaraje(@RequestBody Garaje garaje) {
        return garajeService.añadirGaraje(garaje);
    }

    @GetMapping
    public List<Garaje> obtenerTodosGarajes() {
        return garajeService.obtenerTodosLosGarajes();
    }

    @GetMapping("/{id}")
    public Garaje obtenerGarajePorId(@PathVariable int id) {
        return garajeService.obtenerGarajePorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarGaraje(@PathVariable int id) {
        garajeService.eliminarGarajePorId(id);
    }
}
