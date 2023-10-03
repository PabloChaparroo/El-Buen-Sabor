package com.project.El_Buen_Sabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

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
@Audited
@Table(name = "rubro")
public class Rubro extends Base {

    //Atributo
    @Column(name = "denominacion")
    private String denominacion;





    //Relacion con Producto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(
            name = "rubro_producto",
            joinColumns = @JoinColumn(name = "fk_rubro"))

    private List<Producto> productos = new ArrayList<Producto>();




}
