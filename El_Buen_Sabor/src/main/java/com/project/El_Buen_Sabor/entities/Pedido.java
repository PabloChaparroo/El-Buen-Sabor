package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pedido")
public class Pedido extends Base {

    //Atributos
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "total")
    private double total;
    @Column(name = "horaEstimadaEntrega")
    private Date horaEstimidaEntrega;

    private EstadoPedido estado;

    private TipoEnvio tipoEnvio;

    public enum EstadoPedido {
        INICIADO,
        PREPARACION,
        ENTREGADO
    }

    public enum TipoEnvio {
        DELIVERY,
        RETIRA
    }


    //Relacion con Factura (puntero) 1 a 0..1
    @OneToOne(cascade = CascadeType.ALL)        //cascada se persiste tanto factura como pedido(puede ser cero)
    @JoinColumn(name = "fk_factura")            //Es la vinculación y cómo se va a llamar (fk de factura)
    private Factura factura;


    //Relacion con PedidoProducto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)    //orphanRemoval sirve para que si eliminamos un pedido tambien se eliminen los pedidosProducto asociados a ese pedido
    @JoinTable(
            name = "pedido_pedidoProducto",
            joinColumns = @JoinColumn(name = "fk_pedido"))

    private List<PedidoProducto> pedidoProductos = new ArrayList<PedidoProducto>();


    //Relacion con domicilio
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;
}
