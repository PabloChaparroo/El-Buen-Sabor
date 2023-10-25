package com.project.El_Buen_Sabor;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoServiceImpl;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoServiceImpl;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService.DetalleArticuloManufacturadoServiceImpl;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElBuenSaborApplication {

	@Autowired
	private DetalleArticuloManufacturadoServiceImpl detalleArticuloManufacturadoService;

	@Autowired
	private ClienteServiceImpl clienteService;

	@Autowired
	private ArticuloManufacturadoServiceImpl articuloManufacturadoService;
	@Autowired
	private ArticuloInsumoServiceImpl articuloInsumoService;

	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("--------------------ESTÁ FUNCIONANDO CORRECTAMENTE------------------------");
	}

		@PostConstruct
		public void init () {
			try {
				articuloManufacturadoService.init();
				articuloInsumoService.initArticuloInsumo();
				detalleArticuloManufacturadoService.intitDetalleArticuloManufacturado();
				clienteService.initClientes();


			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No hay nada en la base de datos");

			}
		}
	}

