package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(value= "SELECT f FROM Factura f WHERE f.numero like '%filtro%' ")
    List<Factura> search(String filtro);

    @Query(value= "SELECT f FROM Factura f WHERE f.numero like '%filtro%' ")
    Page<Factura> search(String filtro, Pageable pageable);
}
