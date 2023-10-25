package com.project.El_Buen_Sabor.services.DomicilioService;

import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.repositories.DomicilioRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.project.El_Buen_Sabor.repositories.BaseRepository;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }
}



    @Override
    public List<Domicilio> search(String filtro) throws Exception {
        try {
            List<Domicilio> domicilios = domicilioRepository.search(filtro);
            return domicilios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<Domicilio> domicilios = domicilioRepository.search(filtro, pageable);
            return domicilios;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}

