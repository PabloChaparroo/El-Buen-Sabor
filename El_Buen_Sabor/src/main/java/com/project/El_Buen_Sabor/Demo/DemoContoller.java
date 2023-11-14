package com.project.El_Buen_Sabor.Demo;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoContoller {
    @PostMapping (value = "Cliente")
    public String welcome(){
        return "Bienvenido from secure endpoint";
    }

    @PostMapping (value = "Admin")
    public String welcomeAdmin(){
        return "Bienvenido from secure endpoint ADMIN";
    }

   @PostMapping (value = "Delibery")
    public String welcomeDelibery(){return "Bienvenido from secure Delibery";}

    @PostMapping (value = "Cocinero")
    public String welcomeCocinero(){
        return "Bienvenido from secure Cocinero";
    }
}
