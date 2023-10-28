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

    @Query(value = "SELECT * FROM Artículo_Manufacturado WHERE denominacion LIKE %:filtro% OR descripcion LIKE %:filtro%",
            nativeQuery = true)
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

  
  
  //Harcodeo
ArticuloManufacturado findByDenominacion(String denominacion);
  //----
}
