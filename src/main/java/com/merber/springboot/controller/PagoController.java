package com.merber.springboot.controller;

import com.merber.springboot.model.Pago;
import com.merber.springboot.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("")
    public List<Pago> obtenerTodosLosPagos() {
        return pagoService.obtenerTodosLosPagos();
    }

    @GetMapping("/{id}")
    public Pago obtenerPagoPorId(@PathVariable Long id) {
        return pagoService.obtenerPagoPorId(id);
    }

    @PostMapping("")
    public Pago guardarPago(@RequestBody Pago pago) {
        return pagoService.guardarPago(pago);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
    }
}