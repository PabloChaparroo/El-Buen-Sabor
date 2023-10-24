package com.project.El_Buen_Sabor.services.ArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.ArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.entities.*;

import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }






    }
