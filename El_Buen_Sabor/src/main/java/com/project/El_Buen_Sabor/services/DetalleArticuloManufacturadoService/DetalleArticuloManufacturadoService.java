package com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleArticuloManufacturadoService extends BaseService<DetalleArticuloManufacturado, Long> {

    List<DetalleArticuloManufacturado> search(String filtro) throws Exception;
    Page<DetalleArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;
}
