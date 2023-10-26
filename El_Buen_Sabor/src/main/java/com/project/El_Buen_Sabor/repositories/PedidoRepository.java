package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value= "SELECT p FROM Pedido p WHERE p.id like '%1%' ")
    List<Pedido> search(String filtro);

    @Query(value= "SELECT p FROM Pedido p WHERE p.id like '%1%'")
    Page<Pedido> search(String filtro, Pageable pageable);
}
