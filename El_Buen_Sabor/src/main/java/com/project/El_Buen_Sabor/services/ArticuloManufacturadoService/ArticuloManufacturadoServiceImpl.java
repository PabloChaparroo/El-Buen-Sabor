package com.project.El_Buen_Sabor.services.ArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.ArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }




    //Harcodeo-------------------------------------------------------
   @Override
   public ArticuloManufacturado findByDenominacion(String denominacion) {
       return articuloManufacturadoRepository.findByDenominacion(denominacion);
   }

   public void guardarArticuloManufacturado(List<ArticuloManufacturado> articulos) {
       articuloManufacturadoRepository.saveAll(articulos);
   }


    public void init() {
        try {
            List<ArticuloManufacturado> articulos = new ArrayList<>();
            //Articulos Manufacturados
            //Hamburguesa:
            ArticuloManufacturado articuloManufacturadoHamburguesa = new ArticuloManufacturado();
            articuloManufacturadoHamburguesa.setDenominacion("Hamburguesa");
            articuloManufacturadoHamburguesa.setDescripcion("Hamburguesa con queso");
            articuloManufacturadoHamburguesa.setTiempoEstimadoCocina(15.0);
            articuloManufacturadoHamburguesa.setCosto(500.0);
            articuloManufacturadoHamburguesa.setPrecioVenta(750.0);
            articulos.add(articuloManufacturadoHamburguesa);

            //Pizza
            ArticuloManufacturado articuloManufacturadoPizza = new ArticuloManufacturado();
            articuloManufacturadoPizza.setDenominacion("Pizza");
            articuloManufacturadoPizza.setDescripcion("Especial");
            articuloManufacturadoPizza.setTiempoEstimadoCocina(15.0);
            articuloManufacturadoPizza.setCosto(900.0);
            articuloManufacturadoPizza.setPrecioVenta(1599.0);
            articulos.add(articuloManufacturadoPizza);

           guardarArticuloManufacturado(articulos);

        } catch (Exception e) {
            System.out.println("No hay Articulos Manufacturados");
        }
    }
    public ArticuloManufacturado obtenerArticuloHamburguesa() {
        ArticuloManufacturado hamburguesa = articuloManufacturadoRepository.findByDenominacion("Hamburguesa");
        if (hamburguesa != null) {
            return hamburguesa;
        } else {
            throw new RuntimeException("La hamburguesa no fue encontrada en la base de datos.");
        }
    }
//--------------


            @Override
            public List<ArticuloManufacturado> search (String filtro) throws Exception {
                try {
                    List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro);
                    return articuloManufacturados;
                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }

            @Override
            public Page<ArticuloManufacturado> search (String filtro, Pageable pageable) throws Exception {
                try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro, pageable);
            return articuloManufacturados;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }

    @Override
    public List<ArticuloManufacturado> articuloManufacturado(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}



