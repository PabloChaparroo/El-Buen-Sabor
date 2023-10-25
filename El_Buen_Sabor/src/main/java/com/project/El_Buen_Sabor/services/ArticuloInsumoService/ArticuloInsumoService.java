package com.project.El_Buen_Sabor.services.ArticuloInsumoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

List<ArticuloInsumo> search(String filtro) throws Exception;
    Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception;


//Harcodeo
    ArticuloInsumo obtenerArticuloInsumoCarne();
    ArticuloInsumo obtenerArticuloInsumoQueso();

    ArticuloInsumo obtenerArticuloInsumoPan();
    ArticuloInsumo obtenerArticuloInsumoTomate();
    ArticuloInsumo obtenerArticuloInsumoLechuga();
    ArticuloInsumo findByDenominacion(String denominacion);
//-------
    
}
