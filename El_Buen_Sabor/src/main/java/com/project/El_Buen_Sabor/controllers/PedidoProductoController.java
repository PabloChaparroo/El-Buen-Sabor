package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.PedidoProducto;
import com.project.El_Buen_Sabor.services.PedidoProductoService.PedidoProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/pedidoproductos")
public class PedidoProductoController extends BaseControllerImpl<PedidoProducto, PedidoProductoServiceImpl>{
}
