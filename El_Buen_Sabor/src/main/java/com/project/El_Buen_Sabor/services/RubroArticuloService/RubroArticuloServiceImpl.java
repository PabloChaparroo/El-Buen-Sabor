package com.project.El_Buen_Sabor.services.RubroArticuloService;

import com.project.El_Buen_Sabor.entities.RubroArticulo;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.RubroArticuloRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroArticuloRepository) {
        super(baseRepository);
        this.rubroArticuloRepository = rubroArticuloRepository;
    }


    @Override
    public List<RubroArticulo> search(String filtro) throws Exception {
        try {
            List<RubroArticulo> rubroArticulos = rubroArticuloRepository.search(filtro);
            return rubroArticulos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<RubroArticulo> rubroArticulos = rubroArticuloRepository.search(filtro, pageable);
            return rubroArticulos;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
