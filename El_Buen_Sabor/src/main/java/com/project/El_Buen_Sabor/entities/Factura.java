package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Factura")
public class Factura extends Base {

    @Column(name = "numero")
    private int numero;
    @Column(name = "fecha_facturacion")
    private Date fechaFacturacion;
    @Column(name = "identificador ")
    private Long mpPaymentID;
    @Column(name = "Id_de_pedido")
    private Long mpMerchantOrderId;
    @Column(name = "preferencia_de_pago")
    private String mpPreferentsId;
    @Column(name = "tipo_de_pago")
    private String mpPaymentType;
    @Column(name = "total_venta")
    private double totalVenta;
    @Column(name = "hora_Estimada_Entrega")
    private Date horaEstimidaEntrega;
    @Column(name = "fecha_Alta")
    private Date fechaAlta;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "fecha_Baja")
    private Date fechaBaja;

    private FormaPago formaPago;
    public enum FormaPago {
        EFECTIVO,
        MERCADO_PAGO
    }

    //Relacion con DetallePedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)    //orphanRemoval sirve para que si eliminamos un pedido tambien se eliminen los pedidosProducto asociados a ese pedido
    @JoinColumn(name = "fk_factura")

    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

}
