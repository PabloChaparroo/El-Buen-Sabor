package com.project.El_Buen_Sabor.services.ArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {

    List<ArticuloManufacturado> buscarPorFiltro(String filtro);


    //Harcodeo------------
    ArticuloManufacturado obtenerArticuloHamburguesa();
    ArticuloManufacturado findByDenominacion(String denominacion);
    //-------------

}
