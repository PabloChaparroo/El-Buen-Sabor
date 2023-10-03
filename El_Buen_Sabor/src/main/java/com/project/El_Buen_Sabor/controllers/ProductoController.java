package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Producto;
import com.project.El_Buen_Sabor.services.ProductoService.ProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{
}
