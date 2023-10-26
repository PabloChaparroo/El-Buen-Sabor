package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long> {

    @Query(value= "SELECT um FROM UnidadMedida um WHERE um.abreviattura like '%filtro%' or um.id like '%filtro%'")
    List<UnidadMedida> search(String filtro);

    @Query(value= "SELECT um FROM UnidadMedida um WHERE um.abreviattura like '%filtro%' or um.id like '%filtro%'")

    Page<UnidadMedida> search(String filtro, Pageable pageable);
}
