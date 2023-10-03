package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "domicilio")
public class Domicilio extends Base {


    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private String numero;
    @Column(name = "localidad")
    private String localidad;

}
