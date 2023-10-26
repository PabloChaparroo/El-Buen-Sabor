package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository<DetalleArticuloManufacturado, Long> {

    @Query(value= "SELECT da FROM DetalleArticuloManufacturado da ")
    List<DetalleArticuloManufacturado> search(String filtro);
    @Query(value= "SELECT da FROM DetalleArticuloManufacturado da")
    Page<DetalleArticuloManufacturado> search(String filtro, Pageable pageable);
}
