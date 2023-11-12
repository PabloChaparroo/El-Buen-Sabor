package com.project.El_Buen_Sabor.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoContoller {
    @PostMapping (value = "demoUser")
    public String welcome(){
        return "Bienvenido from secure endpoint";
    }

    @PostMapping (value = "demoAdmin")
    public String welcomeAdmin(){
        return "Bienvenido from secure endpoint ADMIN";
    }
}
