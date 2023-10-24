package com.project.El_Buen_Sabor;

import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElBuenSaborApplication {

	@Autowired
	private ClienteServiceImpl clienteService;



	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("--------------------ESTÁ FUNCIONANDO------------------------");
	}

		@PostConstruct
		public void init () {
			try {
				// Llama al método de inicialización del servicio
				clienteService.initClientes();

				// Llama a otros métodos de inicialización para otras entidades si es necesario
			} catch (Exception e) {
				// Maneja la excepción aquí, por ejemplo, registra el error o realiza alguna acción de recuperación.
			}
		}
	}

