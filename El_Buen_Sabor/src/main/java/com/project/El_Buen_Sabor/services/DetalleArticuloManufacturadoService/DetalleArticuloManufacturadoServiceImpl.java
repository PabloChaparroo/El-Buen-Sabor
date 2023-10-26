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



    public void intitDetalleArticuloManufacturado() {
        try {


            ArticuloManufacturado articuloManufacturadoHamburguesa = articuloManufacturadoService.obtenerArticuloHamburguesa();
            ArticuloInsumo articuloInsumoCarne = articuloInsumoService.obtenerArticuloInsumoCarne();
            ArticuloInsumo articuloInsumoPan = articuloInsumoService.obtenerArticuloInsumoPan();
            ArticuloInsumo articuloInsumoQueso = articuloInsumoService.obtenerArticuloInsumoQueso();
            ArticuloInsumo articuloInsumoLechuga = articuloInsumoService.obtenerArticuloInsumoLechuga();
            ArticuloInsumo articuloInsumoTomate = articuloInsumoService.obtenerArticuloInsumoTomate();
            List<DetalleArticuloManufacturado> detalles = new ArrayList<>();

            //Cantidades de insumos para una hamburguesa
            DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaCarne = new DetalleArticuloManufacturado();
            detalleArticuloManufacturadoHamburguesaCarne.setCantidad(300); // Cantidad de carne gramos
            detalleArticuloManufacturadoHamburguesaCarne.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalleArticuloManufacturadoHamburguesaCarne.setArticuloInsumo(articuloInsumoCarne);
            detalles.add(detalleArticuloManufacturadoHamburguesaCarne);


            DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPan = new DetalleArticuloManufacturado();
            detalleArticuloManufacturadoHamburguesaPan.setCantidad(2);
            detalleArticuloManufacturadoHamburguesaPan.setArticuloInsumo(articuloInsumoPan);
            detalleArticuloManufacturadoHamburguesaPan.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalles.add(detalleArticuloManufacturadoHamburguesaPan);

            DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaLechuga = new DetalleArticuloManufacturado();
            detalleArticuloManufacturadoHamburguesaLechuga.setCantidad(230);
            detalleArticuloManufacturadoHamburguesaLechuga.setArticuloInsumo(articuloInsumoLechuga);
            detalleArticuloManufacturadoHamburguesaLechuga.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalles.add(detalleArticuloManufacturadoHamburguesaLechuga);

            DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaTomate = new DetalleArticuloManufacturado();
            detalleArticuloManufacturadoHamburguesaTomate.setCantidad(200); //200 gramos de tomate
            detalleArticuloManufacturadoHamburguesaTomate.setArticuloInsumo(articuloInsumoTomate);
            detalleArticuloManufacturadoHamburguesaTomate.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalles.add(detalleArticuloManufacturadoHamburguesaTomate);

            DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaQueso = new DetalleArticuloManufacturado();
            detalleArticuloManufacturadoHamburguesaQueso.setCantidad(150);
            detalleArticuloManufacturadoHamburguesaQueso.setArticuloInsumo(articuloInsumoQueso);
            detalleArticuloManufacturadoHamburguesaQueso.setArticuloManufacturado(articuloManufacturadoHamburguesa);
            detalles.add(detalleArticuloManufacturadoHamburguesaQueso);


            guardarDetallesArticuloManufacturado(detalles);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se encontró el artículo manufacturado");
        }
    }
//---------------------------------------------------------------------------
          
          
      
                 
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




