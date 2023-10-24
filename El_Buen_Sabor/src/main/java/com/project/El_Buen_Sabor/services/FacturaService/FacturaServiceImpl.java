package com.project.El_Buen_Sabor.services.FacturaService;

import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.entities.Factura;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.FacturaRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> search(String filtro) throws Exception {
        try {
            List<Factura> facturas = facturaRepository.search(filtro);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> search(String filtro, Pageable pageable) throws Exception {
        try {

                Page<Factura> facturas = facturaRepository.search(filtro, pageable);
            return facturas;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}
