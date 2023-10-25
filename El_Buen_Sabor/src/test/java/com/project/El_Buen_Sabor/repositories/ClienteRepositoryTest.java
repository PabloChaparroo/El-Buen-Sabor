package com.project.El_Buen_Sabor.repositories;

import com.project.El_Buen_Sabor.entities.Cliente;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ClienteRepository personaRepository;

    @Test
    void testSearchString(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Pablo");
        cliente.setApellido("Chaparro");

        List<Cliente> listaEnviada = new ArrayList();
        listaEnviada.add(cliente);

        entityManager.persist(cliente);
        entityManager.flush();

        assertEquals(listaEnviada, personaRepository.searchNative("Pablo"));
        assertEquals(listaEnviada, personaRepository.searchNative("Chaparro"));

    }


}
