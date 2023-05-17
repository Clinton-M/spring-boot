package com.merber.springboot.service;

import com.merber.springboot.model.Cliente;
import com.merber.springboot.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
               // () -> new RecursoNoEncontradoException("Cliente", "id", id) not implemented yet
                () -> new RuntimeException("Cliente no encontrado")

        );
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}