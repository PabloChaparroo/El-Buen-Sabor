package com.project.El_Buen_Sabor.services.UsuarioService;

import com.project.El_Buen_Sabor.entities.UnidadMedida;
import com.project.El_Buen_Sabor.entities.Usuario;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {
    List<Usuario> search(String filtro) throws Exception;
    Page<Usuario> search(String filtro, Pageable pageable) throws Exception;

    public String registrarAdministrador(String nombre, String contrasena) throws Exception;
}
