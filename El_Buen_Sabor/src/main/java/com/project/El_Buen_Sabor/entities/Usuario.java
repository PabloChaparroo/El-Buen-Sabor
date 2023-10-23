package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "Usuario")
public class Usuario extends Base {

    @Column(name = "nombre usuario")
    private String nombreUsuario;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "correo electronico")
    private String rol;
    @Column(name = "fecha Alta")
    private Date fechaAlta;
    @Column(name = "fecha modificacion")
    private Date fechaModificacion;
    @Column(name = "fechaBaja")
    private Date fechaBaja;



}