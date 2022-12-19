package com.bancopichincha.pruebatecnica.repository.crud;

import com.bancopichincha.pruebatecnica.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaCrudRepository extends JpaRepository<CuentaEntity, Integer> {
}
