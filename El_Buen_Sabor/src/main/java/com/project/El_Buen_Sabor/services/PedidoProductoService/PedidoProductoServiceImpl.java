package com.project.El_Buen_Sabor.services.PedidoProductoService;

import com.project.El_Buen_Sabor.entities.PedidoProducto;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.PedidoRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProductoServiceImpl extends BaseServiceImpl<PedidoProducto, Long> implements PedidoProductoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoProductoServiceImpl(BaseRepository<PedidoProducto, Long> baseRepository) {
        super(baseRepository);
    }
}
