package com.bancopichincha.pruebatecnica.service;

import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import com.bancopichincha.pruebatecnica.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaGateway cuentaGateway;

    public List<Cuenta> obtenerTodasLasCuentas(){
        return cuentaGateway.obtenerTodasLasCuentas();
    }

    public Cuenta guardarCuenta(Integer idPersona,Cuenta cuenta) {
        return cuentaGateway.guardarCuenta(idPersona, cuenta);
    }

    public Optional<Cuenta> obtenerCuentaPorId(Integer id) {
        return cuentaGateway.obtenerCuentaPorId(id);
    }

    public void eliminarCuenta(Integer id) {
        cuentaGateway.eliminarCuentaById(id);
    }

    public Cuenta actualizarCuenta(Integer id, Cuenta cuenta) {
        return cuentaGateway.actualizarCuenta(id, cuenta);
    }
}
