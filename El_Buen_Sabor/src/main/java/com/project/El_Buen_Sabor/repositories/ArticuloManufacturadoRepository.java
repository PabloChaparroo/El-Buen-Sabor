package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    @Query(value= "SELECT * FROM Artículo_Manufacturado am WHERE am.denominacion LIKE '%1%'",
            nativeQuery = true)
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query(value= "SELECT * FROM Artículo_Manufacturado am WHERE am.denominacion LIKE '%1%'", nativeQuery = true)
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable);

    @Query(
                    "SELECT am.denominacion AS nombre_artículo, COUNT(dp.id) AS cantidad_pedidos " +
                    "FROM ArticuloManufacturado am " +
                    "JOIN DetallePedido dp ON am.id = dp.id " +
                    "JOIN Pedido p ON dp.id = p.id " +
                    "WHERE p.fechapedido BETWEEN :fechaInicio AND :fechaFin " +
                    "GROUP BY am.denominacion " +
                    "ORDER BY cantidad_pedidos DESC"
            )
    List<Object[]> RankingArticuloManufacturado(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
