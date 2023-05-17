package com.merber.springboot.controller;


import com.merber.springboot.model.DetalleOrden;
import com.merber.springboot.service.DetalleOrdenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-orden")
public class DetalleOrdenController {

    private final DetalleOrdenService detalleOrdenService;

    public DetalleOrdenController(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    @GetMapping("")
    public List<DetalleOrden> obtenerTodosLosDetallesOrden() {
        return detalleOrdenService.obtenerTodosLosDetallesOrden();
    }

    @GetMapping("/{id}")
    public DetalleOrden obtenerDetalleOrdenPorId(@PathVariable Long id) {
        return detalleOrdenService.obtenerDetalleOrdenPorId(id);
    }

    @PostMapping("")
    public DetalleOrden guardarDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        return detalleOrdenService.guardarDetalleOrden(detalleOrden);
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalleOrden(@PathVariable Long id) {
        detalleOrdenService.eliminarDetalleOrden(id);
    }
}