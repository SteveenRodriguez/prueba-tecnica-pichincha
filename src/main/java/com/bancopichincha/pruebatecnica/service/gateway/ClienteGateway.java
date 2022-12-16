package com.bancopichincha.pruebatecnica.service.gateway;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;

import java.util.List;

public interface ClienteGateway {
    List<Cliente> obtenerTodosLosCLientes();

    Cliente guardarClient(Cliente cliente);
}
