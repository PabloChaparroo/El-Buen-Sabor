package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Audited
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numero")
    private int numero;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "descuento")
    private double descuento;
    @Column(name = "formaPago")
    private String formaPago;
    @Column(name = "total")
    private int total;



}