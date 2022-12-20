package com.bancopichincha.pruebatecnica.repository;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.entity.CuentaEntity;
import com.bancopichincha.pruebatecnica.repository.crud.CuentaCrudRepository;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import com.bancopichincha.pruebatecnica.service.gateway.CuentaGateway;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Repository
public class CuentaRepository implements CuentaGateway {
    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cuenta> obtenerTodasLasCuentas() {
        List<CuentaEntity> cuentasEntity = cuentaCrudRepository.findAll();
        return cuentasEntity.stream().map(cuentaEntity -> {
            Cuenta cuenta = new Cuenta();
            cuenta.setCuentaId(cuentaEntity.getCuentaId());
            cuenta.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
            cuenta.setTipoCuenta(cuentaEntity.getTipoCuenta());
            cuenta.setSaldoInicial(cuentaEntity.getSaldoInicial());
            cuenta.setEstado(cuentaEntity.getEstado());
            cuenta.setMovimientos(cuentaEntity.getMovimientos());
            return cuenta;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Integer id) {
        return cuentaCrudRepository.findById(id)
                .map(cuentaEntity -> {
                    Cuenta cuenta = new Cuenta();
                    cuenta.setCuentaId(cuentaEntity.getCuentaId());
                    cuenta.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
                    cuenta.setTipoCuenta(cuentaEntity.getTipoCuenta());
                    cuenta.setSaldoInicial(cuentaEntity.getSaldoInicial());
                    cuenta.setEstado(cuentaEntity.getEstado());
                    cuenta.setMovimientos(cuentaEntity.getMovimientos());
                    return cuenta;
                });
    }

    @Override
    public Cuenta guardarCuenta(Integer idPersona, Cuenta cuenta) {
//        Optional<Cliente> cliente = clienteRepository.obtenerClientePorId(idPersona);
//        clienteRepository.actualizarCliente(idPersona, cliente);
        CuentaEntity cuentaEntity = new CuentaEntity();
        cuentaEntity.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaEntity.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaEntity.setEstado(cuenta.getEstado());
        cuentaEntity.setMovimientos(cuenta.getMovimientos());
        try {
            cuentaCrudRepository.save(cuentaEntity);
            return cuenta;
        }catch (Exception e){
            log.warning(e.getMessage());
            return new Cuenta();
        }

    }

    @Override
    public void eliminarCuentaById(Integer id) {
        cuentaCrudRepository.deleteById(id);
    }

    @Override
    public Cuenta actualizarCuenta(Integer id, Cuenta cuenta) {
        Cuenta encontrada = obtenerCuentaPorId(id).get();
        CuentaEntity entidad = new CuentaEntity();
        entidad.setCuentaId(cuenta.getCuentaId());
        entidad.setNumeroCuenta(cuenta.getNumeroCuenta());
        entidad.setTipoCuenta(cuenta.getTipoCuenta());
        entidad.setSaldoInicial(cuenta.getSaldoInicial());
        entidad.setEstado(cuenta.getEstado());
        entidad.setMovimientos(cuenta.getMovimientos());
        cuentaCrudRepository.save(entidad);
        return cuenta;
    }
}
