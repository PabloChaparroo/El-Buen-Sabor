package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long>{

    @Query(value= "SELECT df FROM DetalleFactura df WHERE df.id like '%1%'")
    List<DetalleFactura> search(String filtro);
    @Query(value= "SELECT df FROM DetalleFactura df WHERE df.id like '%1%'")
    Page<DetalleFactura> search(String filtro, Pageable pageable);
}
