package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "producto")
public class Producto extends Base {

    //Atributos
    @Column(name = "tiempoEstimadaCocina")
    private int tiempoEstimadoCocina;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precioVenta")
    private double precioVenta;
    @Column(name = "precioCompra")
    private double precioCompra;
    @Column(name = "stockActual")
    private int stockActual;
    @Column(name = "stockMinimo")
    private int stockMinimo;
    @Column(name = "unidadMedida")
    private String unidadMedida;
    @Column(name = "receta")
    private String receta;

    private Tipo tipo;
    public enum Tipo {
        MANUFACTURADO,
        INSUMO
    }

}



