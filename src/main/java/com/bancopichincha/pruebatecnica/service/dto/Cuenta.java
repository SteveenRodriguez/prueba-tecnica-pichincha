package com.bancopichincha.pruebatecnica.service.dto;

import lombok.*;

@Getter
@Setter
public class Cuenta {
    private Integer id;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
}
