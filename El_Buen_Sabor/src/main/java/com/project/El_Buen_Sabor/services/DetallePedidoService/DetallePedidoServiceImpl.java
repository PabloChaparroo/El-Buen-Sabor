package com.project.El_Buen_Sabor.services.DetallePedidoService;

import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.DetallePedidoRepository;
import com.project.El_Buen_Sabor.repositories.PedidoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {

        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
        public List<DetallePedido> search(String filtro) throws Exception {
            try {
                List<DetallePedido> detallePedidos = detallePedidoRepository.search(filtro);
                return detallePedidos;
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
    }

    @Override
    public Page<DetallePedido> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<DetallePedido> detallePedidos = detallePedidoRepository.search(filtro, pageable);
                return detallePedidos;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}
