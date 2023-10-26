package com.project.El_Buen_Sabor.services.DetallePedidoService;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido,Long> {
    List<DetallePedido> search(String filtro) throws Exception;
    Page<DetallePedido> search(String filtro, Pageable pageable) throws Exception;
}
