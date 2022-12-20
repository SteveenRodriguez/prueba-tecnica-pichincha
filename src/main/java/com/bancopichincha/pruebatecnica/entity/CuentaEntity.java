package com.bancopichincha.pruebatecnica.entity;

import com.bancopichincha.pruebatecnica.service.dto.Cuenta;
import com.bancopichincha.pruebatecnica.service.dto.Movimiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Integer cuentaId;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private Double saldoInicial;

    @Column
    private Boolean estado;

//    @OneToMany
//    @JoinColumn(name = "cuenta_id")
    @Column
    private Movimiento[] movimientos;

    //    TODO: Realizar las relaciones 1 cliente puede tener muchas cuentas
//    @ManyToOne
//    @JoinColumn(name = "id_Persona")
//    private PersonaEntity personaEntity;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;
}
