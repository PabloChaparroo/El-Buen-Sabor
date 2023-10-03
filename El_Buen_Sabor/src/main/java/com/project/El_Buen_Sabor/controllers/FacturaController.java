package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Factura;
import com.project.El_Buen_Sabor.services.FacturaService.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{
}
