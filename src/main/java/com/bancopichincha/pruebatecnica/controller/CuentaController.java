package com.bancopichincha.pruebatecnica.controller;

import com.bancopichincha.pruebatecnica.service.CuentaService;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
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
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuentas")
    public ResponseEntity<List<Cuenta>> obtenerTodasLasCuentas() {
        log.info("Obteniendo Todas las cuentas");
        return ResponseEntity.ok(cuentaService.obtenerTodasLasCuentas());
    }

    @PostMapping("/cuentas/{id}")
    public ResponseEntity<Cuenta> guardarCuenta(@RequestBody() Cuenta cuenta, @PathVariable() Integer id) {
        log.info("Cuenta Creada");
        return new ResponseEntity<>(cuentaService.guardarCuenta(id, cuenta), HttpStatus.CREATED);
    }

    @GetMapping("/cuentas/{id}")
    public ResponseEntity<Optional<Cuenta>> obtenerClientePorId(@PathVariable() Integer id) {
        log.info("Obteniendo Cuenta por ID");
        return new ResponseEntity<>(cuentaService.obtenerCuentaPorId(id) ,HttpStatus.OK);
    }

    @DeleteMapping("/cuentas/{id}")
    public ResponseEntity<Void> eliminarCLiente(@PathVariable() Integer id) {
        cuentaService.eliminarCuenta(id);
        log.info("Cuenta Eliminada");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/cuentas/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable() Integer id, @RequestBody() Cuenta cuenta){
        log.info("Cuenta Actualizada");
        return new ResponseEntity<>(cuentaService.actualizarCuenta(id, cuenta), HttpStatus.OK);
    }
}
