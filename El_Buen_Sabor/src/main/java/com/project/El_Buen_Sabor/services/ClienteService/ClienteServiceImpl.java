package com.project.El_Buen_Sabor.services.ClienteService;


import com.project.El_Buen_Sabor.entities.*;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import com.project.El_Buen_Sabor.repositories.DetallePedidoRepository;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoService;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoService;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchPaged(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public List<Cliente> rankingCliente(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.rankingCliente(fechaInicio, fechaFin);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Cliente> pedidosPorFecha(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.pedidosPorFecha(fechaInicio, fechaFin);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}



