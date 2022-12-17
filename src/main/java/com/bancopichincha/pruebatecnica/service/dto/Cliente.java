package com.bancopichincha.pruebatecnica.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) //sirve para no mostrar los null en una response de postman
public class Cliente extends Persona{
    private String clientId;
    private String contrasenia;
    private Boolean estado;
}
