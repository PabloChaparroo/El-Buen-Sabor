package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value= "SELECT p FROM Pedido p WHERE p.id like '%1%' ")
    List<Pedido> search(String filtro);

    @Query(value= "SELECT p FROM Pedido p WHERE p.id like '%1%'")
    Page<Pedido> search(String filtro, Pageable pageable);

    @Query("SELECT am.id AS articulo_manufacturado_id, am.denominacion AS articulo_manufacturado_denominacion, " +
            "       COUNT(dp.id) AS cantidad_pedidos" +
            " FROM Pedido p" +
            " JOIN DetallePedido dp ON p.id = dp.id " +
            " JOIN ArticuloManufacturado am ON dp.id = am.id" +
            " WHERE p.fechapedido BETWEEN :fechaInicio AND :fechaFin" +
            " GROUP BY am.id, am.denominacion" +
            " ORDER BY cantidad_pedidos DESC")
    List<Object[]> rankingArticulo(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
