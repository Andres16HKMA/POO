package com.ingenieria_de_software.controller;

import com.ingenieria_de_software.model.Reserva;
import com.ingenieria_de_software.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public Reserva añadirReserva(@RequestBody Reserva reserva) {
        return reservaService.añadirReserva(reserva);
    }

    @GetMapping
    public List<Reserva> obtenerTodasReservas() {
        return reservaService.obtenerTodasLasReservas();
    }

    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable int id) {
        return reservaService.obtenerReservaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        reservaService.eliminarReservaPorId(id);
    }

    @GetMapping("/{id}/precio")
    public double calcularPrecio(@PathVariable int id) {
        return reservaService.calcularPrecioReserva(id);
    }

    @PutMapping("/{id}/checkEntregado")
    public void checkEntregado(@PathVariable int id) {
        reservaService.verificarEntregaCoches(id);
    }
}
