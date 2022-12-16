package com.bancopichincha.pruebatecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity extends PersonaEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idCliente;

    @Column
    private String clienteId;

    @Column
    private String contrasenia;

    @Column
    private Boolean estado;

//    TODO: Realizar las relaciones -> Un cliente es una Persona

    @OneToOne
    @JoinColumn()
    private PersonaEntity personaEntity;

}
