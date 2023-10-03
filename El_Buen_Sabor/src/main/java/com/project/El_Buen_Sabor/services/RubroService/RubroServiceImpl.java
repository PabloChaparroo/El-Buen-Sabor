package com.project.El_Buen_Sabor.services.RubroService;

import com.project.El_Buen_Sabor.entities.Rubro;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.RubroRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;
    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository) {
        super(baseRepository);
    }
}
