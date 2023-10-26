package com.project.El_Buen_Sabor.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "Rubro_Artículo")
public class RubroArticulo extends Base {


    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "fecha Alta")
    private Date fechaAlta;
    @Column(name = "fecha modificacion")
    private Date fechaModificacion;
    @Column(name = "fechaBaja")
    private Date fechaBaja;

    @ManyToOne
    private RubroArticulo rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroArticulo> subRubros;


}
