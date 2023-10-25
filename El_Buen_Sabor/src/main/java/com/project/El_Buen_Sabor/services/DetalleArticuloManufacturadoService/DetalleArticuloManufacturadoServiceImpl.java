package com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService;



import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.DetalleArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoService;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoService;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {

    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;



    @Autowired
    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);
        this.detalleArticuloManufacturadoRepository = detalleArticuloManufacturadoRepository;
    }


    //Harcodeo------------------------------------------------------------
    @Autowired
       private ArticuloManufacturadoService articuloManufacturadoService;
    @Autowired
    private ArticuloInsumoService articuloInsumoService;

    public void guardarDetallesArticuloManufacturado(List<DetalleArticuloManufacturado> detalles) {
        detalleArticuloManufacturadoRepository.saveAll(detalles);

    }



    //public void intitDetalleArticuloManufacturado() {
    //    try {
    //        ArticuloManufacturado articuloManufacturadoHamburguesa = articuloManufacturadoService.obtenerArticuloHamburguesa();
    //        ArticuloInsumo articuloInsumoCarne = articuloInsumoService.obtenerArticuloInsumoCarne();
    //        ArticuloInsumo articuloInsumoPan = articuloInsumoService.obtenerArticuloInsumoPan();
    //        ArticuloInsumo articuloInsumoQueso = articuloInsumoService.obtenerArticuloInsumoQueso();
    //        ArticuloInsumo articuloInsumoLechuga = articuloInsumoService.obtenerArticuloInsumoLechuga();
    //        ArticuloInsumo articuloInsumoTomate = articuloInsumoService.obtenerArticuloInsumoTomate();
    //        List<DetalleArticuloManufacturado> detalles = new ArrayList<>();




          
      
                 
    @Override
    public List<DetalleArticuloManufacturado> search(String filtro) throws Exception {
        try {
            List<DetalleArticuloManufacturado> detalleArticuloManufacturados = detalleArticuloManufacturadoRepository.search(filtro);
            return detalleArticuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<DetalleArticuloManufacturado> detalleArticuloManufacturados = detalleArticuloManufacturadoRepository.search(filtro, pageable);
            return detalleArticuloManufacturados;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}




