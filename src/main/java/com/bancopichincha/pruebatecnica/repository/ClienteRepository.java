package com.bancopichincha.pruebatecnica.repository;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.repository.crud.ClienteCrudRepository;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.gateway.ClienteGateway;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Repository
public class ClienteRepository implements ClienteGateway {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<Cliente> obtenerTodosLosCLientes() {
        var clientesEntity = clienteCrudRepository.findAll();
        return clientesEntity.stream().map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    cliente.setClientId(clienteEntity.getClienteId());
                    cliente.setContrasenia(clienteEntity.getContrasenia());
                    cliente.setEstado(clienteEntity.getEstado());
                    cliente.setNombre(clienteEntity.getNombre());
                    cliente.setGenero(clienteEntity.getGenero());
                    cliente.setEdad(clienteEntity.getEdad());
                    cliente.setIdentificacion(clienteEntity.getIdentificacion());
                    cliente.setDireccion(clienteEntity.getDireccion());
                    cliente.setTelefono(clienteEntity.getTelefono());
                   return cliente;
                }).collect(Collectors.toList());
    }

    @Override
    public Cliente guardarClient(Cliente cliente) {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setClienteId(cliente.getClientId());
        clienteEntity.setContrasenia(cliente.getContrasenia());
        clienteEntity.setEstado(cliente.getEstado());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setGenero(cliente.getGenero());
        clienteEntity.setEdad(cliente.getEdad());
        clienteEntity.setIdentificacion(cliente.getIdentificacion());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setTelefono(cliente.getTelefono());

        try {
            clienteCrudRepository.save(clienteEntity);
            return cliente;
        }catch (Exception e) {
            log.warning(e.getMessage());
            return new Cliente();
        }


    }


}
