package com.project.El_Buen_Sabor.services.ClienteService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.services.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {
    List<Cliente> search(String filtro) throws Exception;
    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
    List<Cliente> rankingCliente(Date fechaInicio,Date fechaFin) throws Exception;
    List<Cliente> pedidosPorFecha(Date fechaInicio,Date fechaFin) throws Exception;
}
