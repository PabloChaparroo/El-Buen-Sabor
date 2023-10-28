package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.El_Buen_Sabor.entities.Cliente;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{

    @Query(
            value = "SELECT * FROM Cliente WHERE Cliente.nombre LIKE %:filtro% OR Cliente.apellido LIKE %:filtro%",
            nativeQuery=true
    )
    List<Cliente> search(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Cliente WHERE Cliente.nombre LIKE %:filtro% OR Cliente.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM CLiente",
            nativeQuery=true
    )
    Page<Cliente> searchPaged(@Param("filtro") String filtro, Pageable pageable);
}
