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
public class Rubro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    //Relacion con Producto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "idRubro")     //Es PrimaryKey
    @Builder.Default

    private List<Producto> productos = new ArrayList<>();
    public void agregarProducto(Producto pro){
        productos.add(pro);
    }




}
