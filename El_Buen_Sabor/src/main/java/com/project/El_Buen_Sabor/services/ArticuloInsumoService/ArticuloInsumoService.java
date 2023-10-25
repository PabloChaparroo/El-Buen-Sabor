package com.project.El_Buen_Sabor.services.ArticuloInsumoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {





    ArticuloInsumo obtenerArticuloInsumoCarne();
    ArticuloInsumo obtenerArticuloInsumoQueso();

    ArticuloInsumo obtenerArticuloInsumoPan();
    ArticuloInsumo obtenerArticuloInsumoTomate();
    ArticuloInsumo obtenerArticuloInsumoLechuga();
    ArticuloInsumo findByDenominacion(String denominacion);
}
