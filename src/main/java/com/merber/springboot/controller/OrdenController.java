package com.merber.springboot.controller;

import com.merber.springboot.model.Orden;
import com.merber.springboot.service.OrdenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping("")
    public List<Orden> obtenerTodasLasOrdenes() {
        return ordenService.obtenerTodasLasOrdenes();
    }

    @GetMapping("/{id}")
    public Orden obtenerOrdenPorId(@PathVariable Long id) {
        return ordenService.obtenerOrdenPorId(id);
    }

    @PostMapping("")
    public Orden guardarOrden(@RequestBody Orden orden) {
        return ordenService.guardarOrden(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
    }
}
