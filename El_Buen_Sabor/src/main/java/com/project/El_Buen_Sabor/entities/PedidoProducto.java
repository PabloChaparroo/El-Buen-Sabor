package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "PedidoProducto")
public class PedidoProducto extends Base {
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subTotal")
    private double subTotal;


    //Relacion con producto
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_producto")
    private Producto producto;



}