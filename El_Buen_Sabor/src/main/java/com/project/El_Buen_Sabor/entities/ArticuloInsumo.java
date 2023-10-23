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

@Table(name = "Artículo_Insumo")
public class ArticuloInsumo extends Base{
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "url imagen")
    private String urlImagen;
    @Column(name = "stock actual")
    private double stockActual;
    @Column(name = "stock minimo")
    private double stockMinimo;
    @Column(name = "precio compra")
    private double precioCompra;
    @Column(name = "fecha Alta")
    private Date fechaAlta;
    @Column(name = "fecha modificacion")
    private Date fechaModificacion;
    @Column(name = "fechaBaja")
    private Date fechaBaja;



    //Relacion con Unidad Medida
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_unidadMedida")
    private UnidadMedida unidadMedida;

    //Relacion con Rubro Articulo
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_rubroArticulo")
    private RubroArticulo rubroArticulo;
}
