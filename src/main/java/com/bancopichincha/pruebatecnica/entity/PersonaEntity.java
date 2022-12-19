package com.bancopichincha.pruebatecnica.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column
    private String nombre;

    @Column
    private String genero;

    @Column
    private String edad;

    @Column
    private Integer identificacion;

    @Column
    private String direccion;

    @Column
    private String telefono;

//    TODO: Realizar las relaciones
    @OneToOne(cascade = {CascadeType.ALL})
    private ClienteEntity clienteEntity;
}
