package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Rubro;
import com.project.El_Buen_Sabor.services.RubroService.RubroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/rubros")
public class RubroController extends BaseControllerImpl<Rubro, RubroServiceImpl>{
}
