package com.project.El_Buen_Sabor.services;

import ch.qos.logback.core.net.server.Client;
import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements BaseService<Cliente> {
    private ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> entities = clienteRepository.findAll();   //obtener de la base de datos todas las personas que tengamos registradas
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(Long id) throws Exception {
        try {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente save(Cliente entity) throws Exception {
        try {
            entity = clienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente update(Long id, Cliente entity) throws Exception {
        try {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            Cliente cliente = entityOptional.get();
            cliente = clienteRepository.save(cliente);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
        @Override
        @Transactional
        public boolean delete(Long id) throws Exception {
            try {
               if(clienteRepository.existsById(id)){
                   clienteRepository.deleteById(id);
                   return true;
               } else {
                   throw new Exception();
               }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }
}

