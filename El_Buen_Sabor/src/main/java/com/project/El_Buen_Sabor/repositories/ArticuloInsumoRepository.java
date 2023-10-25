package com.project.El_Buen_Sabor.repositories;


import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {

    ArticuloInsumo findByDenominacion(String denominacion);

}
