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

    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "fecha_Alta")
    private Date fechaAlta;
    @Column(name = "fecha_Modificacion")
    private Date fechaModificacion;
    @Column(name = "fecha_Baja")
    private Date fechaBaja;

    private Rol rol;

    public enum Rol {
        DELYVERY,
        ADMINISTRADOR,
        COCINERO,
        CLIENTE

    }
}