package com.project.El_Buen_Sabor.services.UnidadMedidaService;

import com.project.El_Buen_Sabor.entities.Factura;
import com.project.El_Buen_Sabor.entities.UnidadMedida;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaService extends BaseService<UnidadMedida, Long> {
    List<UnidadMedida> search(String filtro) throws Exception;
    Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception;
}
