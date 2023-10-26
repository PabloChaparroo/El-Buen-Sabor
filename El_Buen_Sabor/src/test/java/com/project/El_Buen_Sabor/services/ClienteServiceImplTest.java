package com.project.El_Buen_Sabor.services;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceImplTest {

    @MockBean
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteServiceImpl clienteService;

    @Test
    void testSearchString(){

        Cliente cliente = new Cliente();
        cliente.setNombre("Pablo");
        cliente.setApellido("Chaparro");

        List<Cliente> listaEnviada = new ArrayList();
        listaEnviada.add(cliente);

        when(clienteRepository.search("pablo")).thenReturn(listaEnviada);

        try {
            assertEquals(listaEnviada, clienteService.search("Pablo"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}