package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String username);

    @Query(value= "SELECT u FROM Usuario u WHERE u.nombreUsuario like '%1%' or u.rol like '%1%'")
    List<Usuario> search(String filtro);

    @Query(value= "SELECT u FROM Usuario u WHERE u.nombreUsuario like '%1%' or u.rol like '%1%'")
    Page<Usuario> search(String filtro, Pageable pageable);
}
