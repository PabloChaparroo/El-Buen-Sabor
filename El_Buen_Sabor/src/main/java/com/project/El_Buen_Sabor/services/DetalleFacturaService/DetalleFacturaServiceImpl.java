package com.project.El_Buen_Sabor.services.DetalleFacturaService;

import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.DetalleFacturaRepository;
import com.project.El_Buen_Sabor.repositories.DetallePedidoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }


    @Override
    public List<DetalleFactura> search(String filtro) throws Exception {
        try {
            List<DetalleFactura> detalleFacturas = detalleFacturaRepository.search(filtro);
            return detalleFacturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleFactura> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<DetalleFactura> detalleFacturas = detalleFacturaRepository.search(filtro, pageable);
            return detalleFacturas;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }

}
