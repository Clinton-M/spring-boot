package com.merber.springboot.controller;


import com.merber.springboot.model.Factura;
import com.merber.springboot.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("")
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaService.obtenerTodasLasFacturas();
    }

    @GetMapping("/{id}")
    public Factura obtenerFacturaPorId(@PathVariable Long id) {
        return facturaService.obtenerFacturaPorId(id);
    }

    @PostMapping("")
    public Factura guardarFactura(@RequestBody Factura factura) {
        return facturaService.guardarFactura(factura);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
    }
}