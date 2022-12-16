package com.bancopichincha.pruebatecnica.repository.crud;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteCrudRepository extends JpaRepository<ClienteEntity, Integer> {
}
