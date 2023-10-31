package com.project.El_Buen_Sabor.services.PedidoService;
import com.project.El_Buen_Sabor.entities.Pedido;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.PedidoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }



    @Override
    public List<Pedido> search(String filtro) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.search(filtro);
            return pedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<Pedido> pedidos = pedidoRepository.search(filtro, pageable);
            return pedidos;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }

    @Override
    public List<Object[]> rankingArticulo(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Object[]> pedidos = pedidoRepository.rankingArticulo(fechaInicio, fechaFin);
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
