package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}