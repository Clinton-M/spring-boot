package com.merber.springboot.service;

import com.merber.springboot.model.Pago;
import com.merber.springboot.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public Pago obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id).orElseThrow(
               // () -> new RecursoNoEncontradoException("Pago", "id", id)
                () -> new RuntimeException("Pago no encontrado")
        );
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}