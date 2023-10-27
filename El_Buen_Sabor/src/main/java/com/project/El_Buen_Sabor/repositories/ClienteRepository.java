package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.El_Buen_Sabor.entities.Cliente;

import java.util.Date;
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

//    @Query(
//            value= "SELECT Cliente.nombre, COUNT(Pedido.id) AS cantidad_pedidos FROM Cliente JOIN Pedido ON Cliente.id = Pedido.id WHERE Pedido.fechapedido BETWEEN :fechaInicio AND :fechaFin GROUP BY Cliente.id ORDER BY cantidad_pedidos DESC",
//            nativeQuery = true)
//    List<Cliente> rankingCliente(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
@Query(value= "SELECT c.nombre AS cliente_nombre, COUNT(p.id) AS cantidad_pedidos " +
        "FROM Cliente c JOIN Pedido p ON c.id = p.id " +
        "WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin " +
        "GROUP BY c.id " +
        "ORDER BY cantidad_pedidos DESC", nativeQuery = true)
List<Cliente> rankingCliente(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query(
            value= "SELECT c.nombre AS cliente_nombre FROM Cliente c JOIN Pedido p ON c.id = p.id WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin ORDER BY p.fechaPedido DESC",
            nativeQuery = true)
    List<Cliente> pedidosPorFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
