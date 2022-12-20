package com.bancopichincha.pruebatecnica.controller;

import com.bancopichincha.pruebatecnica.service.MovimientoService;
import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import com.bancopichincha.pruebatecnica.service.dto.Movimiento;
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
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> obtenerTodosLosMovimientos() {
        log.info("Obteniendo Todas los movimientos");
        return ResponseEntity.ok(movimientoService.obtenerTodosLosMovimientos());
    }

    @PostMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody() Movimiento movimiento, @PathVariable() Integer id) {
        log.info("Movimiento Creado");
        return new ResponseEntity<>(movimientoService.guardarMovimiento(id, movimiento), HttpStatus.CREATED);
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<Optional<Movimiento>> obtenerMovimientoPorId(@PathVariable() Integer id) {
        log.info("Obteniendo Movimiento por ID");
        return new ResponseEntity<>(movimientoService.obtenerMovimientoPorId(id) ,HttpStatus.OK);
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable() Integer id) {
        movimientoService.eliminarMovimientoPorId(id);
        log.info("Movimiento Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> actualizarMovimiento(@PathVariable() Integer id, @RequestBody() Movimiento movimiento){
        log.info("Movimiento Actualizado");
        return new ResponseEntity<>(movimientoService.actualizarMovimiento(id, movimiento), HttpStatus.OK);
    }
}
