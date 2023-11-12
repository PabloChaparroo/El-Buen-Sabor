package com.project.El_Buen_Sabor.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Usuario")
public class Usuario extends Base implements UserDetails {

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "fecha_Alta")
    private Date fechaAlta;
    @Column(name = "fecha_Modificacion")
    private Date fechaModificacion;
    @Column(name = "fecha_Baja")
    private Date fechaBaja;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public enum Rol {
        DELYVERY,
        ADMINISTRADOR,
        COCINERO,
        CLIENTE;


    }
}