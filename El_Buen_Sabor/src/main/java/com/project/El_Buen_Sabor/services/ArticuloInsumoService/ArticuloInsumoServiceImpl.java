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

    }





