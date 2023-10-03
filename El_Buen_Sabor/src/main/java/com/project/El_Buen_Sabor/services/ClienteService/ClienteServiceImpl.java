package com.project.El_Buen_Sabor.services.ClienteService;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }



}




