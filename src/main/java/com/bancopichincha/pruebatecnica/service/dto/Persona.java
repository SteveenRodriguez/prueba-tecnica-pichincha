package com.bancopichincha.pruebatecnica.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
public class Persona {
    private Integer idPersona;
    private String nombre;
    private String genero;
    private String edad;
    private Integer identificacion;
    private String direccion;
    private String telefono;
}
