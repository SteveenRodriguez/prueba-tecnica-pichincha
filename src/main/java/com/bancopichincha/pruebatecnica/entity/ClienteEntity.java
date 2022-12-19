package com.bancopichincha.pruebatecnica.entity;

import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "cliente_id")
    private String clienteId;

    @Column
    private String contrasenia;

    @Column
    private Boolean estado;

    @Column
    private Cuenta[] cuentas;

//    TODO: Realizar las relaciones -> Un cliente es una Persona

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_persona")
    private PersonaEntity personaEntity;

}
