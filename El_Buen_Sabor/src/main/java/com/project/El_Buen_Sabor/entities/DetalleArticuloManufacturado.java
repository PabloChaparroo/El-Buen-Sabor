package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Detalle_Artículo_Manufacturado")
public class DetalleArticuloManufacturado extends Base{

    @Column(name = "cantidad")
    private double cantidad;




    //Relacion con Articulo Insumo
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_detalleArticuloManufacturado")

    private List<ArticuloInsumo> articuloInsumos = new ArrayList<ArticuloInsumo>();


    //Relacion con articulo manufacturado
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_detalleArticuloManufacturado")
    private ArticuloManufacturado articuloManufacturado;

}
