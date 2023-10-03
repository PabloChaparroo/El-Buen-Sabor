package com.project.El_Buen_Sabor.controllers;

import com.project.El_Buen_Sabor.entities.Usuario;
import com.project.El_Buen_Sabor.services.UsuarioService.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
}
