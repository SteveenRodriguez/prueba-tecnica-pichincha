package com.bancopichincha.pruebatecnica.service.dto;

import lombok.*;

@Getter
@Setter
public class Persona {
    private Integer id;
    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
