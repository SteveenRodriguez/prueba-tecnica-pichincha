package com.bancopichincha.pruebatecnica.service.gateway;

import com.bancopichincha.pruebatecnica.service.MovimientoService;
import com.bancopichincha.pruebatecnica.service.dto.Movimiento;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MovimientoGateway {
    List<Movimiento> obtenerTodosLosMovimientos();

    Movimiento guardarMovimiento(Integer idPersona, Movimiento movimiento);

    Optional<Movimiento> obtenerMovimientoPorId(Integer id);

    void eliminarMovimientoPorId(Integer id);

    Movimiento actualizarMovimiento(Integer id, Movimiento movimiento);
}
