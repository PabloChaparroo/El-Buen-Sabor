package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query(value= "SELECT u FROM Usuario u WHERE u.nombreUsuario like '%filtro%' or u.rol like '%filtro%'")
    List<Usuario> search(String filtro);

    @Query(value= "SELECT u FROM Usuario u WHERE u.nombreUsuario like '%filtro%' or u.rol like '%filtro%'")
    Page<Usuario> search(String filtro, Pageable pageable);
}
