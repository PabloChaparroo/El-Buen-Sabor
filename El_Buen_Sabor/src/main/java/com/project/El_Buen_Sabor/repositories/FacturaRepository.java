package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(value= "SELECT f FROM Factura f WHERE f.numero like '%1%' ")
    List<Factura> search(String filtro);

    @Query(value= "SELECT f FROM Factura f WHERE f.numero like '%1%' ")
    Page<Factura> search(String filtro, Pageable pageable);

    @Query(
            value= "SELECT SUM(am.precioVenta) AS totalIngreso, SUM(am.costo) AS costoTotal,(SUM(am.precioVenta) - SUM(am.costo)) AS gananciaTotal FROM Factura f JOIN DetalleFactura df ON f.id = df.id JOIN ArticuloManufacturado am ON df.id = am.id WHERE f.fechaFacturacion BETWEEN :fechaInicio AND :fechaFin",
            nativeQuery = true)
    List<Factura> calculoIngresos(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
