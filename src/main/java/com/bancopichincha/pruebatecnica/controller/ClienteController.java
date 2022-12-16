package com.bancopichincha.pruebatecnica.controller;

import com.bancopichincha.pruebatecnica.service.ClienteService;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody() Cliente cliente){
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }
}
