package com.bancopichincha.pruebatecnica.repository;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.repository.crud.ClienteCrudRepository;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.gateway.ClienteGateway;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Log
@Repository
public class ClienteRepository implements ClienteGateway {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<Cliente> obtenerTodosLosCLientes() {
        List<ClienteEntity> clientesEntity = clienteCrudRepository.findAll();
        return clientesEntity.stream().map(clienteEntity -> {
            Cliente cliente = new Cliente();
            cliente.setIdPersona(clienteEntity.getIdPersona());
            cliente.setClientId(clienteEntity.getClienteId());
            cliente.setContrasenia(clienteEntity.getContrasenia());
            cliente.setEstado(clienteEntity.getEstado());
            cliente.setNombre(clienteEntity.getNombre());
            cliente.setGenero(clienteEntity.getGenero());
            cliente.setEdad(clienteEntity.getEdad());
            cliente.setIdentificacion(clienteEntity.getIdentificacion());
            cliente.setDireccion(clienteEntity.getDireccion());
            cliente.setTelefono(clienteEntity.getTelefono());
            cliente.setCuentas(clienteEntity.getCuentas());
            return cliente;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteCrudRepository.findById(id)
                .map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    cliente.setIdPersona(clienteEntity.getIdPersona());
                    cliente.setClientId(clienteEntity.getClienteId());
                    cliente.setContrasenia(clienteEntity.getContrasenia());
                    cliente.setEstado(clienteEntity.getEstado());
                    cliente.setNombre(clienteEntity.getNombre());
                    cliente.setGenero(clienteEntity.getGenero());
                    cliente.setEdad(clienteEntity.getEdad());
                    cliente.setIdentificacion(clienteEntity.getIdentificacion());
                    cliente.setDireccion(clienteEntity.getDireccion());
                    cliente.setTelefono(clienteEntity.getTelefono());
                    cliente.setCuentas(clienteEntity.getCuentas());
                    return cliente;
                });
    }

    @Override
    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        var encontrado = obtenerClientePorId(id).get();
        encontrado.setNombre(cliente.getNombre());
        return encontrado;
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteCrudRepository.deleteById(id);
    }

    public Cliente guardarClient(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
//        clienteEntity.setIdPersona(cliente.getIdPersona());
        clienteEntity.setClienteId(UUID.randomUUID().toString());
        clienteEntity.setContrasenia(cliente.getContrasenia());
        clienteEntity.setEstado(cliente.getEstado());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setGenero(cliente.getGenero());
        clienteEntity.setEdad(cliente.getEdad());
        clienteEntity.setIdentificacion(cliente.getIdentificacion());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setCuentas(cliente.getCuentas());
        try {
            clienteCrudRepository.save(clienteEntity);
            return cliente;
        } catch (Exception e) {
            log.warning(e.getMessage());
            return new Cliente();
        }
    }
}
