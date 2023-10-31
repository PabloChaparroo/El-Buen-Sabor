package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Pedido")
public class Pedido extends Base {

    //Atributos
    @Column(name = "fecha pedido")
    private Date fechapedido;
    @Column(name = "total")
    private double total;
    @Column(name = "horaEstimadaEntrega")
    private String horaEstimidaEntrega;
    @Column(name = "fecha Alta")
    private Date fechaAlta;
    @Column(name = "fecha modificacion")
    private Date fechaModificacion;
    @Column(name = "fechaBaja")
    private Date fechaBaja;

    private EstadoPedido estado;

    private TipoEnvio tipoEnvio;


    public enum EstadoPedido {
        PENDIENTE_PAGO,
        PAGADO,
        PREPARACION,
        PENDIENTE_ENTREGA,
        EN_CAMINO,
        CANCELADO,
        NOTA_CREDITO,
        COMPLETADO
    }

    public enum TipoEnvio {
        DELIVERY,
        TAKE_AWAY
    }

    //Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    //Relacion con Factura (puntero) 1 a 0..1
    @OneToOne(cascade = CascadeType.ALL)        //cascada se persiste tanto factura como pedido(puede ser cero)
    @JoinColumn(name = "fk_factura")            //Es la vinculación y cómo se va a llamar (fk de factura)
    private Factura factura;


    //Relacion con DetallePedido
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pedido")

    private List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();


    //Relacion con domicilio
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;



}


