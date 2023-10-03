package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Cliente;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")//permite el acceso desde distintos clientes
@RequestMapping(path = "api/v1/clientes")

public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

}
