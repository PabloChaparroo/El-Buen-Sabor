package com.project.El_Buen_Sabor.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@Table(name = "cliente")            //Cómo se llama la tabla
public class Cliente extends Base {

    //Atributos
   // @Column(name = "nombre")
    private String nombre;
    //@Column(name = "apellido")
    //private String apellido;
    //@Column(name = "telefono")
    //private int telefono;
    //@Column(name = "email")
    //private String email;

    /*
    //Relacion a domicilio
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Cliente_Domicilio",
            joinColumns = @JoinColumn(name = "fk_cliente"))

    private List<Domicilio> domicilios = new ArrayList<Domicilio>();


    //Relacion con pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cliente_pedido",
            joinColumns = @JoinColumn(name = "fk_cliente"))

    private List<Pedido> pedido = new ArrayList<Pedido>();
*/

}