package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    @Query(value= "SELECT d FROM Domicilio d WHERE d.numero like '%1%' or d.localidad like '%1%'")
    List<Domicilio> search(String filtro);

    @Query(value= "SELECT d FROM Domicilio d WHERE d.numero like '%filtro%' or d.localidad like '%filtro%'")
    Page<Domicilio> search(String filtro, Pageable pageable);
}
