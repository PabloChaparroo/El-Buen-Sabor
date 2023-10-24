package com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.DetalleArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {
    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);
        this.detalleArticuloManufacturadoRepository = detalleArticuloManufacturadoRepository;
    }

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
