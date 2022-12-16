package com.bancopichincha.pruebatecnica.service;

import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteGateway clienteGateway;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteGateway.obtenerTodosLosCLientes();
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteGateway.guardarClient(cliente);
    }


}
