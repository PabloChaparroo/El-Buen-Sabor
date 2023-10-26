package com.project.El_Buen_Sabor.services.DetalleFacturaService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaService  extends BaseService<DetalleFactura, Long> {

    List<DetalleFactura> search(String filtro) throws Exception;
    Page<DetalleFactura> search(String filtro, Pageable pageable) throws Exception;
}

