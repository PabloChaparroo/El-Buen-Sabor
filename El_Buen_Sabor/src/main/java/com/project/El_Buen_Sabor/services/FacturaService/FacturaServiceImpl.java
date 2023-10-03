package com.project.El_Buen_Sabor.services.FacturaService;

import com.project.El_Buen_Sabor.entities.Factura;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.FacturaRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }
}
