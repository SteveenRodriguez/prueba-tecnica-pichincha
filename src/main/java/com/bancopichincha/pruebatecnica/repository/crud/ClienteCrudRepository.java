package com.bancopichincha.pruebatecnica.repository.crud;

import com.bancopichincha.pruebatecnica.entity.ClienteEntity;
import com.bancopichincha.pruebatecnica.service.dto.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteCrudRepository extends JpaRepository<ClienteEntity, Integer> {
}
