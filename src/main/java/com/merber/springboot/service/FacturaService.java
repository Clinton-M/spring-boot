package com.merber.springboot.service;

import com.merber.springboot.model.Factura;
import com.merber.springboot.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id).orElseThrow(
               // () -> new RecursoNoEncontradoException("Factura", "id", id)
                () -> new RuntimeException("Factura no encontrada")
        );
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}