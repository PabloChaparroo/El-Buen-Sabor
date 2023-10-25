package com.project.El_Buen_Sabor.services.DomicilioService;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.repositories.DomicilioRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.El_Buen_Sabor.repositories.BaseRepository;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

}