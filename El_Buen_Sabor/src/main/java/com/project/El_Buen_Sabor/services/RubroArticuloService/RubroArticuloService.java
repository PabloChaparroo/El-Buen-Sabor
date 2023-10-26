package com.project.El_Buen_Sabor.services.RubroArticuloService;

import com.project.El_Buen_Sabor.entities.RubroArticulo;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloService extends BaseService<RubroArticulo, Long> {
    List<RubroArticulo> search(String filtro) throws Exception;
    Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception;
}
