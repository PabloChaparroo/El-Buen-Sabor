package com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.DetalleArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {
    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);
        this.detalleArticuloManufacturadoRepository = detalleArticuloManufacturadoRepository;
    }
}
