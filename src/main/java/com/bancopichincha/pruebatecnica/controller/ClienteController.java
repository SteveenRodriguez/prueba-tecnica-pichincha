package com.bancopichincha.pruebatecnica.controller;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.service.ClienteService;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Log
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        log.info("Obteniendo todos los clientes");
        return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody() Cliente cliente){
        log.info("Cliente creado");
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable() Integer id, @RequestBody() Cliente cliente){
        log.info("Cliente Actualizado");
        return new ResponseEntity<>(clienteService.actualizarCliente(id, cliente), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> eliminarCLiente(@PathVariable() Integer id) {
        clienteService.eliminarCliente(id);
        log.info("Cliente Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Optional<Cliente>> obtenerClientePorId(@PathVariable() Integer id) {
        log.info("Obteniendo cliente por ID");
        return new ResponseEntity<>(clienteService.obtenerClientePorId(id) ,HttpStatus.OK);
    }


}
