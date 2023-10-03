package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Pedido;
import com.project.El_Buen_Sabor.services.PedidoService.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
}
