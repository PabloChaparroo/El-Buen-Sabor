package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
@Table(name = "detallePedido")
public class PedidoProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private double subTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Producto producto;



}