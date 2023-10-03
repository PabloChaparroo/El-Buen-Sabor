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
@Audited
@Builder

@Table(name = "usuario")
public class Usuario extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "rol")
    private String rol;


    //Relacion con Pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_pedido",
            joinColumns = @JoinColumn(name = "fk_usuario"))

    private List<Usuario> usuario = new ArrayList<Usuario>();
}
