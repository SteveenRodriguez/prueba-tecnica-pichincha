package com.bancopichincha.pruebatecnica.service.gateway;

import com.bancopichincha.pruebatecnica.service.dto.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    List<Cliente> obtenerTodosLosCLientes();
    Optional<Cliente> obtenerClientePorId(Integer id);
    Cliente guardarClient(Cliente cliente);

    void eliminarCliente(Integer id);

    Cliente actualizarCliente(Integer id, Cliente cliente);
}
