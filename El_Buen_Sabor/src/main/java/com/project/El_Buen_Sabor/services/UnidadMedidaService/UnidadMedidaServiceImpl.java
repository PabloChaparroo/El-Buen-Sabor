package com.project.El_Buen_Sabor.services.UnidadMedidaService;

import com.project.El_Buen_Sabor.entities.DetalleFactura;
import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.entities.UnidadMedida;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.UnidadMedidaRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }

    @Override
    public List<UnidadMedida> search(String filtro) throws Exception {
        try {
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro);
            return unidadMedidas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro, pageable);
            return unidadMedidas;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}
