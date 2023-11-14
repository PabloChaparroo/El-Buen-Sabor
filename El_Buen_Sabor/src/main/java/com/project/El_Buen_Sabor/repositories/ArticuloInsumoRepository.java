package com.project.El_Buen_Sabor.repositories;


import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {


    @Query(value= "SELECT ai FROM ArticuloInsumo ai WHERE ai.denominacion LIKE %:filtro%")
    List<ArticuloInsumo> search(String filtro);
    @Query(value= "SELECT ai FROM ArticuloInsumo ai WHERE  ai.denominacion LIKE %:filtro%")
    Page<ArticuloInsumo> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT i FROM articulo_insumo i WHERE stockActual <= stockMinimo * 1.20",
            countQuery = "SELECT count(*) FROM articuloInsumo",
            nativeQuery = true)
    Page<ArticuloInsumo> getStockBajo(Pageable pageable);
  
}
