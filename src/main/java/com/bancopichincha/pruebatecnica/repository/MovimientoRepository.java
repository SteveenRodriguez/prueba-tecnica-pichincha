package com.bancopichincha.pruebatecnica.repository;

import com.bancopichincha.pruebatecnica.entity.MovimientoEntity;
import com.bancopichincha.pruebatecnica.repository.crud.MovimientoCrudRepository;
import com.bancopichincha.pruebatecnica.service.MovimientoService;
import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import com.bancopichincha.pruebatecnica.service.dto.Movimiento;
import com.bancopichincha.pruebatecnica.service.gateway.MovimientoGateway;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Repository
public class MovimientoRepository implements MovimientoGateway {
    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;

    //TODO: inyectar clases necesarias

    @Override
    public List<Movimiento> obtenerTodosLosMovimientos() {
        List<MovimientoEntity> movimientoEntities = movimientoCrudRepository.findAll();
        return movimientoEntities.stream().map(movimientoEntity -> {
            Movimiento movimiento = new Movimiento();
            movimiento.setIdMovimiento(movimientoEntity.getIdMovimiento());
            movimiento.setFecha(movimientoEntity.getFecha());
            movimiento.setTipoMovimiento(movimientoEntity.getTipoMovimiento());
            movimiento.setValor(movimientoEntity.getValor());
            movimiento.setSaldo(movimientoEntity.getSaldo());
            return movimiento;
        }).collect(Collectors.toList());
    }

    @Override
    public Movimiento guardarMovimiento(Integer idPersona, Movimiento movimiento) {
        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setFecha(movimiento.getFecha());
        movimientoEntity.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoEntity.setValor(movimiento.getValor());
        movimientoEntity.setSaldo(movimiento.getSaldo());
        try {
            movimientoCrudRepository.save(movimientoEntity);
            return movimiento;
        }catch (Exception e) {
            log.warning(e.getMessage());
            return new Movimiento();
        }
    }

    @Override
    public Optional<Movimiento> obtenerMovimientoPorId(Integer id) {
        return movimientoCrudRepository.findById(id).map(movimientoEntity -> {
            Movimiento movimiento = new Movimiento();
            movimiento.setIdMovimiento(movimientoEntity.getIdMovimiento());
            movimiento.setFecha(movimientoEntity.getFecha());
            movimiento.setTipoMovimiento(movimientoEntity.getTipoMovimiento());
            movimiento.setValor(movimientoEntity.getValor());
            movimiento.setSaldo(movimientoEntity.getSaldo());
            return movimiento;
        });
    }

    @Override
    public void eliminarMovimientoPorId(Integer id) {
        movimientoCrudRepository.deleteById(id);
    }

    @Override
    public Movimiento actualizarMovimiento(Integer id, Movimiento movimiento) {
        Movimiento encontrado = obtenerMovimientoPorId(id).get();
        MovimientoEntity entidad = new MovimientoEntity();
        entidad.setIdMovimiento(movimiento.getIdMovimiento());
        entidad.setFecha(movimiento.getFecha());
        entidad.setTipoMovimiento(movimiento.getTipoMovimiento());
        entidad.setValor(movimiento.getValor());
        entidad.setSaldo(movimiento.getSaldo());
        movimientoCrudRepository.save(entidad);
        return movimiento;
    }


}
