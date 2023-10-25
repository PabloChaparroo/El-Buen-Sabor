package com.project.El_Buen_Sabor.services.ArticuloInsumoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.ArticuloInsumoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {
    @Autowired
    private  ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {

        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }



    //Harcodeo----------------------------------------------------------

    @Override
    public ArticuloInsumo findByDenominacion(String denominacion) {
        return articuloInsumoRepository.findByDenominacion(denominacion);
    }
    public void guardarArticuloInsumo(List<ArticuloInsumo> articulosInsumos) {
        articuloInsumoRepository.saveAll(articulosInsumos);
=======
    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.search(filtro);
            return articuloInsumos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.search(filtro, pageable);
            return articuloInsumos;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
    public void initArticuloInsumo() {
        try {
            List<ArticuloInsumo> articulosInsumos = new ArrayList<>();
            //Articulo insumos
            ArticuloInsumo articuloInsumoQueso = new ArticuloInsumo();
            articuloInsumoQueso.setDenominacion("Queso");
            articuloInsumoQueso.setStockActual(20.3);
            articuloInsumoQueso.setStockMinimo(5);
            articuloInsumoQueso.setPrecioCompra(2300);
            articulosInsumos.add(articuloInsumoQueso);

            ArticuloInsumo articuloInsumoLechuga = new ArticuloInsumo();
            articuloInsumoLechuga.setDenominacion("Lechuga");
            articuloInsumoLechuga.setStockActual(15.0);
            articuloInsumoLechuga.setStockMinimo(3);
            articuloInsumoLechuga.setPrecioCompra(500);
            articulosInsumos.add(articuloInsumoLechuga);

            ArticuloInsumo articuloInsumoTomate = new ArticuloInsumo();
            articuloInsumoTomate.setDenominacion("Tomate");
            articuloInsumoTomate.setStockActual(12.0);
            articuloInsumoTomate.setStockMinimo(2);
            articuloInsumoTomate.setPrecioCompra(400);
            articulosInsumos.add(articuloInsumoTomate);

            ArticuloInsumo articuloInsumoCarne = new ArticuloInsumo();
            articuloInsumoCarne.setDenominacion("Carne");
            articuloInsumoCarne.setStockActual(30.0); // Cantidad de carne en stock
            articuloInsumoCarne.setStockMinimo(10);   // Stock mínimo de carne
            articuloInsumoCarne.setPrecioCompra(1800);
            articulosInsumos.add(articuloInsumoCarne);

            ArticuloInsumo articuloInsumoPan = new ArticuloInsumo();
            articuloInsumoPan.setDenominacion("Pan");
            articuloInsumoPan.setStockActual(50.0); // Cantidad de Pan en stock
            articuloInsumoPan.setStockMinimo(10);   // Stock mínimo de pan
            articuloInsumoPan.setPrecioCompra(3);
            articulosInsumos.add(articuloInsumoPan);

            guardarArticuloInsumo(articulosInsumos);
        } catch (Exception e) {
            System.out.println("No hay Inusmos");
        }
    }
        public ArticuloInsumo obtenerArticuloInsumoQueso() {
            ArticuloInsumo queso = articuloInsumoRepository.findByDenominacion("Queso");
            if (queso != null) {
                return queso;
            } else {
                throw new RuntimeException("El queso no fue encontrada en la base de datos.");
            }
        }
    public ArticuloInsumo obtenerArticuloInsumoLechuga() {
        ArticuloInsumo lechuga = articuloInsumoRepository.findByDenominacion("Lechuga");
        if (lechuga != null) {
            return lechuga;
        } else {
            throw new RuntimeException("La lechuga no fue encontrada en la base de datos.");
        }
    }
    public ArticuloInsumo obtenerArticuloInsumoTomate() {
        ArticuloInsumo tomate = articuloInsumoRepository.findByDenominacion("Tomate");
        if (tomate != null) {
            return tomate;
        } else {
            throw new RuntimeException("La lechuga no fue encontrada en la base de datos.");
        }
    }
    public ArticuloInsumo obtenerArticuloInsumoCarne() {
        ArticuloInsumo carne = articuloInsumoRepository.findByDenominacion("Carne");
        if (carne!= null) {
            return carne;
        } else {
            throw new RuntimeException("La carne no fue encontrada en la base de datos.");
        }
    }
    public ArticuloInsumo obtenerArticuloInsumoPan() {
        ArticuloInsumo pan = articuloInsumoRepository.findByDenominacion("Pan");
        if (pan != null) {
            return pan;
        } else {
            throw new RuntimeException("El pan no fue encontrada en la base de datos.");
        }
    }
    }




