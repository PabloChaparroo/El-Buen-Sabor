package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.DetallePedido;
import com.project.El_Buen_Sabor.services.DetallePedidoService.DetallePedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/pedidoproductos")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{
}
