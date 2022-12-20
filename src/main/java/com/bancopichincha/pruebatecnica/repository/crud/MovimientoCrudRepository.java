package com.bancopichincha.pruebatecnica.repository.crud;

import com.bancopichincha.pruebatecnica.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoCrudRepository extends JpaRepository<MovimientoEntity, Integer> {
}
