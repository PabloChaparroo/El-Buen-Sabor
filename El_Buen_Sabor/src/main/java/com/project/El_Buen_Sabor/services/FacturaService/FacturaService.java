package com.project.El_Buen_Sabor.services.FacturaService;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.entities.Factura;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaService extends BaseService<Factura,Long> {
    List<Factura> search(String filtro) throws Exception;
    Page<Factura> search(String filtro, Pageable pageable) throws Exception;

    List<Factura> calculoIngresos(String filtro) throws Exception;
}
