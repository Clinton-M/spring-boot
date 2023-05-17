package com.merber.springboot.service;

import com.merber.springboot.model.DetalleOrden;
import com.merber.springboot.repository.DetalleOrdenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenService {
    private final DetalleOrdenRepository detalleOrdenRepository;

    public DetalleOrdenService(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    public List<DetalleOrden> obtenerTodosLosDetallesOrden() {
        return detalleOrdenRepository.findAll();
    }

    public DetalleOrden obtenerDetalleOrdenPorId(Long id) {
        return detalleOrdenRepository.findById(id).orElseThrow(
               // () -> new RecursoNoEncontradoException("Detalle Orden", "id", id)
                () -> new RuntimeException("Detalle Orden no encontrado")
        );
    }

    public DetalleOrden guardarDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    public void eliminarDetalleOrden(Long id) {
        detalleOrdenRepository.deleteById(id);
    }
}