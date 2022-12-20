package com.bancopichincha.pruebatecnica.service;

import com.bancopichincha.pruebatecnica.service.dto.Movimiento;
import com.bancopichincha.pruebatecnica.service.gateway.MovimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoGateway movimientoGateway;

    public List<Movimiento> obtenerTodosLosMovimientos(){
        return movimientoGateway.obtenerTodosLosMovimientos();
    }

    public Movimiento guardarMovimiento(Integer idPersona, Movimiento movimiento){
        return movimientoGateway.guardarMovimiento(idPersona, movimiento);
    }

    public Optional<Movimiento> obtenerMovimientoPorId(Integer id) {
        return movimientoGateway.obtenerMovimientoPorId(id);
    }

    public void eliminarMovimientoPorId(Integer id){
        movimientoGateway.eliminarMovimientoPorId(id);
    }

    public Movimiento actualizarMovimiento(Integer id, Movimiento movimiento) {
        return movimientoGateway.actualizarMovimiento(id, movimiento);
    }
}
