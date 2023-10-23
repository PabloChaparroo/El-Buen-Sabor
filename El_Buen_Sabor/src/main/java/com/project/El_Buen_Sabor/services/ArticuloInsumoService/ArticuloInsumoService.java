package com.project.El_Buen_Sabor.services.ArticuloInsumoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {


    List<ArticuloInsumo> search(String filtro) throws Exception;
}
