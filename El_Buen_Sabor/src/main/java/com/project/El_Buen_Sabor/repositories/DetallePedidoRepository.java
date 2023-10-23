package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.entities.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {

    @Query(value= "SELECT dp FROM DetallePedido dp ")
    List<DetallePedido> search(String filtro);
    @Query(value= "SELECT dp FROM DetallePedido dp ")
    Page<DetallePedido> search(String filtro, Pageable pageable);
}
