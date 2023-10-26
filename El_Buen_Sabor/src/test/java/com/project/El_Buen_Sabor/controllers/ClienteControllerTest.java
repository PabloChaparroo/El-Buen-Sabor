package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import com.project.El_Buen_Sabor.services.ClienteServiceImplTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ClienteControllerTest {

    @MockBean
    private ClienteServiceImpl clienteService;
    @Autowired
    private MockMvc mockMvc;

    void testSearchString() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setNombre("Pablo");;
        cliente.setApellido("Chaparro");

        List<Cliente> listaEnviada = new ArrayList();
        listaEnviada.add(cliente);

        when(clienteService.search("Pablo")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/clientes/search")
                .param("filtro", "Pablo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect()

    }
}
