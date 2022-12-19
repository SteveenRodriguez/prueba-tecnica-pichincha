package com.bancopichincha.pruebatecnica.service.gateway;

import com.bancopichincha.pruebatecnica.service.dto.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaGateway {
    List<Cuenta> obtenerTodasLasCuentas();
    Optional<Cuenta> obtenerCuentaPorId(Integer id);
    Cuenta guardarCuenta(Integer idPersona,Cuenta cuenta);

    void eliminarCuentaById(Integer id);

    Cuenta actualizarCuenta(Integer id, Cuenta cuenta);

}
