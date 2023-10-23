package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.UnidadMedida;
import com.project.El_Buen_Sabor.services.UnidadMedidaService.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//permite el acceso desde distintos clientes
@RequestMapping(path = "api/v1/unidadMedidas")
public class UnidadMedidaController extends  BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl> {
}
