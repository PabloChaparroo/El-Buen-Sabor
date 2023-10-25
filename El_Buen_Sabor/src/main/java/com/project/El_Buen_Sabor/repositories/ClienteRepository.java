package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.El_Buen_Sabor.entities.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{

    @Query(value= "SELECT c FROM Cliente c WHERE c.nombre LIKE '%1%' OR c.apellido LIKE '%1%'")
    List<Cliente> search(String filtro);
    @Query(value= "SELECT c FROM Cliente c WHERE c.nombre LIKE '%1%' OR c.apellido LIKE '%1%'")
    Page<Cliente> search(String filtro, Pageable pageable);
}
