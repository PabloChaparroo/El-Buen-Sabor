package com.project.El_Buen_Sabor.controllers;


import com.project.El_Buen_Sabor.entities.RubroArticulo;
import com.project.El_Buen_Sabor.services.RubroArticuloService.RubroArticuloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/rubros")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl>{
}
