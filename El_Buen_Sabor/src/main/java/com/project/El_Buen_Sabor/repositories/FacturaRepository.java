package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}