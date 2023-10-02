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

@Table(name = "cliente")            //Cómo se llama la tabla
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "email")
    private String email;

    //Relacion a domicilio
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    @Builder.Default

    private List<Domicilio> domicilios = new ArrayList<>();
}