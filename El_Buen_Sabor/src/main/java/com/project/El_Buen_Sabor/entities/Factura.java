package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "factura")
public class Factura extends Base {

    @Column(name = "numero")
    private int numero;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "descuento")
    private double descuento;
    @Column(name = "total")
    private int total;

    private FormaPago formaPago;
    public enum FormaPago {
        EFECIVO,
        MERCADOPAGO,
        DEBITO
    }



}