package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.entities.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long> {

    @Query(value= "SELECT ra FROM RubroArticulo ra WHERE ra.id like '%1%' or ra.denominacion like '%1%'")
    List<RubroArticulo> search(String filtro);

    @Query(value= "SELECT ra FROM RubroArticulo ra WHERE ra.id like '%1%' or ra.denominacion like '%1%'")
    Page<RubroArticulo> search(String filtro, Pageable pageable);
}
