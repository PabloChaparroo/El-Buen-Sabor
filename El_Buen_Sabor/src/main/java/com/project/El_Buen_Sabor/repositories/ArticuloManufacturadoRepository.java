package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    @Query(value= "SELECT * FROM Artículo_Manufacturado am WHERE am.denominacion LIKE '%1%'",
            nativeQuery = true)
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query(value= "SELECT * FROM Artículo_Manufacturado am WHERE am.denominacion LIKE '%1%'", nativeQuery = true)
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable);

    @Query(
            value= "SELECT am FROM ArticuloManufacturado am JOIN DetallePedido dp ON am.id=dp.id JOIN Pedido p ON dp.id=p.id WHERE p.fechaPedido BETWEEN '2023-01-01' AND '2023-10-01' ORDER BY dp.cantidad DESC",
            nativeQuery = true)
    List<ArticuloManufacturado> articuloManufacturado(@Param("filtro")String filtro);

}
