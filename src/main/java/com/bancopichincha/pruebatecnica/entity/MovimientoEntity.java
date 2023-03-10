package com.bancopichincha.pruebatecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class MovimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Column
    private String fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column
    private Double valor;

    @Column
    private Double saldo;
    //    TODO: Realizar las relaciones
//    @ManyToOne
//    @JoinColumn(name = "cuenta_id")
//    private CuentaEntity cuentaEntity;
}
