package com.merber.springboot.service;

import com.merber.springboot.model.Orden;
import com.merber.springboot.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> obtenerTodasLasOrdenes() {
        return ordenRepository.findAll();
    }

    public Orden obtenerOrdenPorId(Long id) {
        return ordenRepository.findById(id).orElseThrow(
                //() -> new RecursoNoEncontradoException("Orden", "id", id)
                () -> new RuntimeException("Orden no encontrada")
                );
    }

    public Orden guardarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}