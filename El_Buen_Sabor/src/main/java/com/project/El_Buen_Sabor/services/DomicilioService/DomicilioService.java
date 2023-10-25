package com.project.El_Buen_Sabor.services.DomicilioService;

import com.project.El_Buen_Sabor.entities.Domicilio;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long> {
    List<Domicilio> search(String filtro) throws Exception;
    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
