package com.bancopichincha.pruebatecnica.service.dto;

import lombok.*;

@Getter
@Setter
public class Cliente extends Persona{
    private String clientId;
    private String contrasenia;
    private Boolean estado;
}
