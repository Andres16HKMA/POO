package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Coche;
import com.ingenieria_de_software.model.Coche_X_Reserva;
import com.ingenieria_de_software.service.Coche_X_ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cochesXReserva")
public class Coche_X_ReservaController {

    @Autowired
    private Coche_X_ReservaService cocheXReservaService;

    @PostMapping
    public Coche_X_Reserva añadirCocheXReserva(@RequestBody Coche_X_Reserva cocheXReserva) {
        return cocheXReservaService.añadirCocheXReserva(cocheXReserva);
    }

    @GetMapping
    public List<Coche_X_Reserva> obtenerTodosCochesXReserva() {
        return cocheXReservaService.obtenerTodasLasCocheXReserva();
    }

    @GetMapping("/{id}")
    public Coche_X_Reserva obtenerCocheXReservaPorId(@PathVariable int id) {
        return cocheXReservaService.obtenerCocheXReservaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCocheXReserva(@PathVariable int id) {
        cocheXReservaService.eliminarCocheXReservaPorId(id);
    }

    @PutMapping("/{id}/entregado")
    public void marcarComoEntregado(@PathVariable int id, @RequestBody Coche coche) {
        cocheXReservaService.marcarCocheComoEntregado(id, coche);
    }

    @GetMapping("/{id}/entregado")
    public boolean verificarEntrega(@PathVariable int id) {
        return cocheXReservaService.verificarEntrega(id);
    }
}
