package com.bancopichincha.pruebatecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class ClienteEntity extends PersonaEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
//    private Integer idCliente;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String clienteId;

    @Column
    private String contrasenia;

    @Column
    private Boolean estado;

//    TODO: Realizar las relaciones -> Un cliente es una Persona

//    @OneToOne
//    @JoinColumn(name = "idPersona")
//    private PersonaEntity personaEntity;

}
