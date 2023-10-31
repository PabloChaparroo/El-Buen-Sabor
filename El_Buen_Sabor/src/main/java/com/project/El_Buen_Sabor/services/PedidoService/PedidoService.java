package com.project.El_Buen_Sabor.services.PedidoService;

import com.project.El_Buen_Sabor.entities.Pedido;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {
    List<Pedido> search(String filtro) throws Exception;
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;
    List<Object[]> rankingArticulo(Date fechaInicio, Date fechaFin) throws Exception;
}
