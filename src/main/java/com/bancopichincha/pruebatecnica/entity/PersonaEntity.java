package com.bancopichincha.pruebatecnica.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // UUID
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column
    private String nombre;

    @Column
    private String genero;

    @Column
    private String edad;

    @Column
    private String identificacion;

    @Column
    private String direccion;

    @Column
    private String telefono;

//    TODO: Realizar las relaciones
    @OneToOne
    @JoinColumn()
    private ClienteEntity clienteEntity;
}
