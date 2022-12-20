package com.bancopichincha.pruebatecnica.service.dto;

import lombok.*;

@Getter
@Setter
public class Movimiento {
    private Integer idMovimiento;
    private String fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;
}
