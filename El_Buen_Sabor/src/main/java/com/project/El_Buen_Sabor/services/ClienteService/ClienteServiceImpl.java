package com.project.El_Buen_Sabor.services.ClienteService;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            return clientes;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }

    @Override
    public List<Object[]> rankingCliente(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Object[]> clientes = clienteRepository.rankingCliente(fechaInicio, fechaFin);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<Object[]> pedidosPorFecha(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Object[]> clientes = clienteRepository.pedidosPorFecha(fechaInicio, fechaFin);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}




