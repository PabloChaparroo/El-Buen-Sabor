package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "total")
    private double total;
    private Date horaEstimidaEntrega;


    //Relacion con Factura (puntero)
    @OneToOne(cascade = CascadeType.ALL)        //cascada se persiste tanto factura como pedido
    @JoinColumn(name = "factura_id")            //Es la vinculación y cómo se va a llamar
    private Factura factura;


    //Relacion con Detalle Pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default

    private List<PedidoProducto> detallesPedidos = new ArrayList<>();
}
