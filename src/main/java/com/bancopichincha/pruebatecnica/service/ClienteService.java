package com.bancopichincha.pruebatecnica.service;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteGateway clienteGateway;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteGateway.obtenerTodosLosCLientes();
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteGateway.obtenerClientePorId(id);
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteGateway.guardarClient(cliente);
    }

    public void eliminarCliente(Integer id) {
        clienteGateway.eliminarCliente(id);
    }

    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        return clienteGateway.actualizarCliente(id, cliente);
    }
}
