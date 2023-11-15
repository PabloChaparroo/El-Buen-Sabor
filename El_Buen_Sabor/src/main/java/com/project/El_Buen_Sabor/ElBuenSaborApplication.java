package com.project.El_Buen_Sabor;

import com.project.El_Buen_Sabor.entities.*;
import com.project.El_Buen_Sabor.repositories.*;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoServiceImpl;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoServiceImpl;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService.DetalleArticuloManufacturadoServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class ElBuenSaborApplication {

	@Autowired
	private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("--------------------ESTÁ FUNCIONANDO CORRECTAMENTE------------------------");
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
		@PostConstruct
		public void init () {
			try {


				//Articulo insumos
				ArticuloInsumo articuloInsumoQueso = new ArticuloInsumo();
				articuloInsumoQueso.setDenominacion("Queso");
				articuloInsumoQueso.setStockActual(20.3);
				articuloInsumoQueso.setStockMinimo(5);
				articuloInsumoQueso.setPrecioCompra(2300);


				ArticuloInsumo articuloInsumoLechuga = new ArticuloInsumo();
				articuloInsumoLechuga.setDenominacion("Lechuga");
				articuloInsumoLechuga.setStockActual(15.0);
				articuloInsumoLechuga.setStockMinimo(3);
				articuloInsumoLechuga.setPrecioCompra(500);


				ArticuloInsumo articuloInsumoTomate = new ArticuloInsumo();
				articuloInsumoTomate.setDenominacion("Tomate");
				articuloInsumoTomate.setStockActual(12.0);
				articuloInsumoTomate.setStockMinimo(2);
				articuloInsumoTomate.setPrecioCompra(400);


				ArticuloInsumo articuloInsumoCarne = new ArticuloInsumo();
				articuloInsumoCarne.setDenominacion("Carne");
				articuloInsumoCarne.setStockActual(30.0); // Cantidad de carne en stock
				articuloInsumoCarne.setStockMinimo(10);   // Stock mínimo de carne
				articuloInsumoCarne.setPrecioCompra(1800);


				ArticuloInsumo articuloInsumoPan = new ArticuloInsumo();
				articuloInsumoPan.setDenominacion("Pan");
				articuloInsumoPan.setStockActual(50.0); // Cantidad de Pan en stock
				articuloInsumoPan.setStockMinimo(10);   // Stock mínimo de pan
				articuloInsumoPan.setPrecioCompra(1300);

				//Salsa
				ArticuloInsumo articuloInsumoSalsa = new ArticuloInsumo();
				articuloInsumoSalsa.setDenominacion("Salsa");
				articuloInsumoSalsa.setStockActual(8);		//8 botellas
				articuloInsumoSalsa.setStockMinimo(2);
				articuloInsumoSalsa.setPrecioCompra(800);

				// Papas
				ArticuloInsumo articuloInsumoPapas = new ArticuloInsumo();
				articuloInsumoPapas.setDenominacion("Papas");
				articuloInsumoPapas.setStockActual(25.0);
				articuloInsumoPapas.setStockMinimo(5);
				articuloInsumoPapas.setPrecioCompra(300);

				// Cebolla
				ArticuloInsumo articuloInsumoCebolla = new ArticuloInsumo();
				articuloInsumoCebolla.setDenominacion("Cebolla");
				articuloInsumoCebolla.setStockActual(10.0);
				articuloInsumoCebolla.setStockMinimo(2);
				articuloInsumoCebolla.setPrecioCompra(150);

				// Salsa de mostaza
				ArticuloInsumo articuloInsumoMostaza = new ArticuloInsumo();
				articuloInsumoMostaza.setDenominacion("Mostaza");
				articuloInsumoMostaza.setStockActual(12); // 12 botellas
				articuloInsumoMostaza.setStockMinimo(3);
				articuloInsumoMostaza.setPrecioCompra(400);

				// Artículo Insumo para el aceite
				ArticuloInsumo articuloInsumoAceite = new ArticuloInsumo();
				articuloInsumoAceite.setDenominacion("Aceite");
				articuloInsumoAceite.setStockActual(5.0); // Cantidad de aceite en litros
				articuloInsumoAceite.setStockMinimo(2);   // Stock mínimo de aceite
				articuloInsumoAceite.setPrecioCompra(300);


				//Articulos Manufacturados
				//Hamburguesa:
				ArticuloManufacturado articuloManufacturadoHamburguesa = new ArticuloManufacturado();
				articuloManufacturadoHamburguesa.setDenominacion("Hamburguesa");
				articuloManufacturadoHamburguesa.setDescripcion("Hamburguesa con queso");
				articuloManufacturadoHamburguesa.setTiempoEstimadoCocina(15.0);
				articuloManufacturadoHamburguesa.setCosto(500.0);
				articuloManufacturadoHamburguesa.setPrecioVenta(750.0);

				//Pizza
				ArticuloManufacturado articuloManufacturadoPizza = new ArticuloManufacturado();
				articuloManufacturadoPizza.setDenominacion("Pizza");
				articuloManufacturadoPizza.setDescripcion("Especial");
				articuloManufacturadoPizza.setTiempoEstimadoCocina(15.0);
				articuloManufacturadoPizza.setCosto(900.0);
				articuloManufacturadoPizza.setPrecioVenta(1599.0);

				// Hamburguesa con papas
				ArticuloManufacturado articuloManufacturadoHamburguesaPapas = new ArticuloManufacturado();
				articuloManufacturadoHamburguesaPapas.setDenominacion("Hamburguesa con Papas");
				articuloManufacturadoHamburguesaPapas.setDescripcion("Con papas fritas y salsa de mostaza");
				articuloManufacturadoHamburguesaPapas.setTiempoEstimadoCocina(20.0);
				articuloManufacturadoHamburguesaPapas.setCosto(700.0); // Suma del costo de hamburguesa, papas y mostaza
				articuloManufacturadoHamburguesaPapas.setPrecioVenta(999.0); // Precio de venta sugerido

				// Pizza de cebolla
				ArticuloManufacturado articuloManufacturadoPizzaCebolla = new ArticuloManufacturado();
				articuloManufacturadoPizzaCebolla.setDenominacion("Pizza de Cebolla");
				articuloManufacturadoPizzaCebolla.setDescripcion("Con cebolla y salsa especial");
				articuloManufacturadoPizzaCebolla.setTiempoEstimadoCocina(18.0);
				articuloManufacturadoPizzaCebolla.setCosto(1100.0); // Suma del costo de pizza y cebolla
				articuloManufacturadoPizzaCebolla.setPrecioVenta(1899.0); // Precio de venta sugerido

				// Artículos Manufacturados con papas
				ArticuloManufacturado articuloManufacturadoPapas = new ArticuloManufacturado();
				articuloManufacturadoPapas.setDenominacion("Papas Fritas");
				articuloManufacturadoPapas.setDescripcion("Papas fritas crujientes");
				articuloManufacturadoPapas.setTiempoEstimadoCocina(10.0);
				articuloManufacturadoPapas.setCosto(300.0);
				articuloManufacturadoPapas.setPrecioVenta(800.0);


				//Cantidades de insumos para una hamburguesa
				ArrayList<DetalleArticuloManufacturado> detalleArticuloManufacturados = new ArrayList<>();

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaCarne = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaCarne.setCantidad(300); // Cantidad de carne gramos
				detalleArticuloManufacturadoHamburguesaCarne.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturadoHamburguesaCarne.setArticuloInsumo(articuloInsumoCarne);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaCarne);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPan = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaPan.setCantidad(2);
				detalleArticuloManufacturadoHamburguesaPan.setArticuloInsumo(articuloInsumoPan);
				detalleArticuloManufacturadoHamburguesaPan.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaPan);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaLechuga = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaLechuga.setCantidad(230);
				detalleArticuloManufacturadoHamburguesaLechuga.setArticuloInsumo(articuloInsumoLechuga);
				detalleArticuloManufacturadoHamburguesaLechuga.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaLechuga);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaTomate = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaTomate.setCantidad(200); //200 gramos de tomate
				detalleArticuloManufacturadoHamburguesaTomate.setArticuloInsumo(articuloInsumoTomate);
				detalleArticuloManufacturadoHamburguesaTomate.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaTomate);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaQueso = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaQueso.setCantidad(150);
				detalleArticuloManufacturadoHamburguesaQueso.setArticuloInsumo(articuloInsumoQueso);
				detalleArticuloManufacturadoHamburguesaQueso.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaQueso);

				// Agregar el aceite como un insumo al artículo manufacturado "Papas Fritas"
				DetalleArticuloManufacturado detalleArticuloManufacturadoAceite = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoAceite.setCantidad(1); // Cantidad de litros de aceite
				detalleArticuloManufacturadoAceite.setArticuloManufacturado(articuloManufacturadoPapas);
				detalleArticuloManufacturadoAceite.setArticuloInsumo(articuloInsumoAceite);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoAceite);

				//Cantidades de insumos para una Pizza
				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaTomate = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaTomate.setCantidad(500); //200 gramos de tomate
				detalleArticuloManufacturadoPizzaTomate.setArticuloInsumo(articuloInsumoTomate);
				detalleArticuloManufacturadoPizzaTomate.setArticuloManufacturado(articuloManufacturadoPizza);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaTomate);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaQueso = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaQueso.setCantidad(150);
				detalleArticuloManufacturadoPizzaQueso.setArticuloInsumo(articuloInsumoQueso);
				detalleArticuloManufacturadoPizzaQueso.setArticuloManufacturado(articuloManufacturadoPizza);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaQueso);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaSalsa= new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaQueso.setCantidad(100);
				detalleArticuloManufacturadoPizzaQueso.setArticuloInsumo(articuloInsumoSalsa);
				detalleArticuloManufacturadoPizzaQueso.setArticuloManufacturado(articuloManufacturadoPizza);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaSalsa);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaPan = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaPan.setCantidad(1);
				detalleArticuloManufacturadoPizzaPan.setArticuloInsumo(articuloInsumoPan);
				detalleArticuloManufacturadoPizzaPan.setArticuloManufacturado(articuloManufacturadoPizza);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaPan);

				// Cantidades de insumos para Hamburguesa con Papas
				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPapasCarne = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaPapasCarne.setCantidad(400); // Cantidad de carne en gramos
				detalleArticuloManufacturadoHamburguesaPapasCarne.setArticuloManufacturado(articuloManufacturadoHamburguesaPapas);
				detalleArticuloManufacturadoHamburguesaPapasCarne.setArticuloInsumo(articuloInsumoCarne);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaPapasCarne);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPapasPapas = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaPapasPapas.setCantidad(300); // Cantidad de papas en gramos
				detalleArticuloManufacturadoHamburguesaPapasPapas.setArticuloInsumo(articuloInsumoPapas);
				detalleArticuloManufacturadoHamburguesaPapasPapas.setArticuloManufacturado(articuloManufacturadoHamburguesaPapas);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaPapasPapas);

				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPapasMostaza = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaPapasMostaza.setCantidad(4); // 4 botellas de mostaza
				detalleArticuloManufacturadoHamburguesaPapasMostaza.setArticuloInsumo(articuloInsumoMostaza);
				detalleArticuloManufacturadoHamburguesaPapasMostaza.setArticuloManufacturado(articuloManufacturadoHamburguesaPapas);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoHamburguesaPapasMostaza);

				// Cantidades de insumos para Pizza de Cebolla
				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaCebollaCebolla = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaCebollaCebolla.setCantidad(150); // 150 gramos de cebolla
				detalleArticuloManufacturadoPizzaCebollaCebolla.setArticuloInsumo(articuloInsumoCebolla);
				detalleArticuloManufacturadoPizzaCebollaCebolla.setArticuloManufacturado(articuloManufacturadoPizzaCebolla);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaCebollaCebolla);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaCebollaTomate = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaCebollaTomate.setCantidad(300); // 300 gramos de tomate
				detalleArticuloManufacturadoPizzaCebollaTomate.setArticuloInsumo(articuloInsumoTomate);
				detalleArticuloManufacturadoPizzaCebollaTomate.setArticuloManufacturado(articuloManufacturadoPizzaCebolla);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaCebollaTomate);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaCebollaQueso = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaCebollaQueso.setCantidad(200);
				detalleArticuloManufacturadoPizzaCebollaQueso.setArticuloInsumo(articuloInsumoQueso);
				detalleArticuloManufacturadoPizzaCebollaQueso.setArticuloManufacturado(articuloManufacturadoPizzaCebolla);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaCebollaQueso);

				DetalleArticuloManufacturado detalleArticuloManufacturadoPizzaCebollaSalsa = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoPizzaCebollaSalsa.setCantidad(50); // 50 botellas de salsa
				detalleArticuloManufacturadoPizzaCebollaSalsa.setArticuloInsumo(articuloInsumoSalsa);
				detalleArticuloManufacturadoPizzaCebollaSalsa.setArticuloManufacturado(articuloManufacturadoPizzaCebolla);
				detalleArticuloManufacturados.add(detalleArticuloManufacturadoPizzaCebollaSalsa);



				detalleArticuloManufacturadoRepository.saveAll(detalleArticuloManufacturados);

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaAlta = sdf.parse("23/10/2023");
						Date fechaPedido = sdf.parse("15/10/2023");

						//Cliente 1: Pablo Chaparro
						//Domicilio 1: Guaymallén San Jose
						//Domicilio 2:Las Heras Plumerillo
						//Usuario 1: pablo11
						//Pedido 1:
						Cliente cliente1 = new Cliente();
						cliente1.setNombre("Pablo");
						cliente1.setApellido("Chaparro");
						cliente1.setTelefono("2614181650");
						cliente1.setEmail("pablobautic15@gmail.com");
						cliente1.setFechaAlta(fechaAlta);

							Domicilio domicilio1 = new Domicilio();
							domicilio1.setLocalidad("Guaymallén San Jose");
							domicilio1.setCalle("Jose Ingenieros");
							domicilio1.setNumero("913");

							Domicilio domicilio2 = new Domicilio();
							domicilio2.setLocalidad("Las Heras Plumerillo");
							domicilio2.setCalle("Moyano");
							domicilio2.setNumero("234");

							cliente1.getDomicilios().add(domicilio1);
							cliente1.getDomicilios().add(domicilio2);

								Usuario usuario1 = new Usuario();
								usuario1.setNombreUsuario("Pabloo11");
								usuario1.setContraseña(passwordEncoder.encode("1234"));
								usuario1.setRol(Usuario.Rol.COCINERO);
								usuario1.setFechaAlta(fechaAlta);
								cliente1.setUsuario(usuario1);

									Pedido pedido1 = new Pedido();
									pedido1.setFechapedido(fechaPedido);
									pedido1.setHoraEstimidaEntrega("30min");
									pedido1.setTotal(3000);
									pedido1.setEstado(Pedido.EstadoPedido.COMPLETADO);
									pedido1.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);

									cliente1.getPedido().add(pedido1);



						//Cliente 2: Saavedra Francisco
						//Domicilio 3: Guaymallen calle Godoy Cruz 666
						//Usuario 2:
						//Pedido 2: 30min, compretado, delivey
						//Pedido 3: 50min, pagado, take away
						//DetallePedido 1,2,3,4,5,6
						//Factura 1
						Cliente cliente2 = new Cliente();
						cliente2.setNombre("Francisco");
						cliente2.setApellido("Saavedra");
						cliente2.setTelefono("2614181652");
						cliente2.setEmail("saavedraaaa@gmail.com");
						cliente2.setFechaAlta(fechaAlta);

							Domicilio domicilio3 = new Domicilio();
							domicilio3.setLocalidad("Guaymallen San Jose");
							domicilio3.setCalle("Godoy Cruz");
							domicilio3.setNumero("666");

							cliente2.getDomicilios().add(domicilio3);

								Usuario usuario2 = new Usuario();
								usuario2.setNombreUsuario("Francisco22");
								usuario2.setContraseña(passwordEncoder.encode("4567"));
								usuario2.setRol(Usuario.Rol.CLIENTE);
								usuario2.setFechaAlta(fechaAlta);

								cliente2.setUsuario(usuario2);

								Pedido pedido2 = new Pedido();
								pedido2.setFechapedido(fechaPedido);
								pedido2.setHoraEstimidaEntrega("50min");
								pedido2.setTotal(5000);
								pedido2.setEstado(Pedido.EstadoPedido.COMPLETADO);
								pedido2.setTipoEnvio(Pedido.TipoEnvio.TAKE_AWAY);

								Pedido pedido3 = new Pedido();
								pedido3.setFechapedido(fechaPedido);
								pedido3.setHoraEstimidaEntrega("30min");
								pedido3.setTotal(5000);
								pedido3.setEstado(Pedido.EstadoPedido.PREPARACION);
								pedido3.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);


								cliente2.getPedido().add(pedido2);
								cliente2.getPedido().add(pedido3);


									// Detalle de cuantas hamburguesas pidio
									DetallePedido detallePedido2 = new DetallePedido();
									detallePedido2.setCantidad(3);
									detallePedido2.setArticuloManufacturado(articuloManufacturadoHamburguesa);


										//Calculo de subtotal de detallePedido1
										double precioHamburguesa = articuloManufacturadoHamburguesa.getPrecioVenta();
										double subTotal1 = detallePedido2.getCantidad() * precioHamburguesa;
										detallePedido2.setSubTotal(subTotal1);

									pedido2.getDetallePedidos().add(detallePedido2);

									//Detalle de cantidad de ingrediente consumido
									//Cantidad de Pan
									DetallePedido detallePedido3 = new DetallePedido();
									detallePedido3.setCantidad(2);
									detallePedido3.setArticuloInsumo(articuloInsumoPan);

									pedido2.getDetallePedidos().add(detallePedido3);

										//Cantidad de Lechuga
										DetallePedido detallePedido4 = new DetallePedido();
										detallePedido4.setCantidad(150);
										detallePedido4.setArticuloInsumo(articuloInsumoLechuga);

										pedido2.getDetallePedidos().add(detallePedido4);

										//Cantidad de Tomate
										DetallePedido detallePedido5 = new DetallePedido();
										detallePedido5.setCantidad(175);
										detallePedido5.setArticuloInsumo(articuloInsumoTomate);

										pedido2.getDetallePedidos().add(detallePedido5);

										//Cantidad de Carne
										DetallePedido detallePedido6 = new DetallePedido();
										detallePedido6.setCantidad(2);
										detallePedido6.setArticuloInsumo(articuloInsumoCarne);

										pedido2.getDetallePedidos().add(detallePedido6);

										DetallePedido detallePedido7 = new DetallePedido();
										detallePedido6.setCantidad(200);
										detallePedido6.setArticuloInsumo(articuloInsumoQueso);

										pedido2.getDetallePedidos().add(detallePedido7);

									Factura factura1 = new Factura();
									factura1.setNumero(1);
									Date fechaFacturacion = dateFormat.parse("2023-02-23");
									factura1.setFechaFacturacion(fechaFacturacion);
									factura1.setMpPaymentID(123456L);
									factura1.setMpMerchantOrderId(7890L);
									factura1.setMpPreferentsId("preferencia123");
									factura1.setMpPaymentType("MERCADO_PAGO");
									factura1.setTotalVenta(100.0);
										String horaEstimada = "14:30:00";
										Date horaEstimadaEntrega = horaFormat.parse(horaEstimada);
									factura1.setHoraEstimidaEntrega(horaEstimadaEntrega);
									factura1.setFormaPago(Factura.FormaPago.MERCADO_PAGO);

									Factura factura2 = new Factura();
									factura1.setNumero(1);
									Date fechaFacturacion2 = dateFormat.parse("2023-06-20");
									factura1.setFechaFacturacion(fechaFacturacion2);
									factura1.setMpPaymentID(123456L);
									factura1.setMpMerchantOrderId(7890L);
									factura1.setMpPreferentsId("preferencia123");
									factura1.setMpPaymentType("MERCADO_PAGO");
									factura1.setTotalVenta(100.0);
									String horaEstimada2 = "16:30:00";
									Date horaEstimadaEntrega2 = horaFormat.parse(horaEstimada2);
									factura1.setHoraEstimidaEntrega(horaEstimadaEntrega2);
									factura1.setFormaPago(Factura.FormaPago.EFECTIVO);

									pedido2.setFactura(factura1);
									pedido3.setFactura(factura2);




						//Cliente 3: Bernardo Fernandez
						//Domicilio 4: Guaymallen calle Godoy Cruz 666
						//Usuario 2:
						Cliente cliente3 = new Cliente();
						cliente3.setNombre("Bernardo");
						cliente3.setApellido("Fernandez");
						cliente3.setTelefono("261123453");
						cliente3.setEmail("bernadroo@gmail.com");
						cliente3.setFechaAlta(fechaAlta);

							Domicilio domicilio4 = new Domicilio();
							domicilio4.setLocalidad("Godoy Cruz");
							domicilio4.setCalle("Mitre");
							domicilio4.setNumero("999");

							cliente3.getDomicilios().add(domicilio4);


								Usuario usuario3 = new Usuario();
								usuario3.setNombreUsuario("Berna77");
								usuario3.setContraseña(passwordEncoder.encode("76128"));
								usuario3.setRol(Usuario.Rol.DELYVERY);
								usuario3.setFechaAlta(fechaAlta);

								cliente3.setUsuario(usuario3);

									// Crear un nuevo pedido para el cliente
									Pedido pedido4 = new Pedido();
									pedido4.setFechapedido(fechaPedido);
									pedido4.setHoraEstimidaEntrega("45min");
									pedido4.setTotal(4500);
									pedido4.setEstado(Pedido.EstadoPedido.PREPARACION);
									pedido4.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);

										// Agregar un detalle de pedido para una hamburguesa
										DetallePedido detallePedido8 = new DetallePedido();
										detallePedido8.setCantidad(2);
										detallePedido8.setArticuloManufacturado(articuloManufacturadoHamburguesa);

											// Calcular el subtotal del detallePedido8
											double precioHamburguesa2 = articuloManufacturadoHamburguesa.getPrecioVenta();
											double subTotal2 = detallePedido8.getCantidad() * precioHamburguesa2;
											detallePedido8.setSubTotal(subTotal2);

										pedido4.getDetallePedidos().add(detallePedido8);

											// Agregar detalles de cantidad de insumos consumidos
											// Cantidad de Papas
											DetallePedido detallePedido9 = new DetallePedido();
											detallePedido9.setCantidad(2);
											detallePedido9.setArticuloInsumo(articuloInsumoPapas);

											pedido4.getDetallePedidos().add(detallePedido9);

											// Cantidad de Mostaza
											DetallePedido detallePedido10 = new DetallePedido();
											detallePedido10.setCantidad(3); // 3 botellas de mostaza
											detallePedido10.setArticuloInsumo(articuloInsumoMostaza);

											pedido4.getDetallePedidos().add(detallePedido10);

												// Cantidad de Tomate
												DetallePedido detallePedido11 = new DetallePedido();
												detallePedido11.setCantidad(150); // 150 gramos de tomate
												detallePedido11.setArticuloInsumo(articuloInsumoTomate);

												pedido4.getDetallePedidos().add(detallePedido11);

													// Cantidad de Cebolla
													DetallePedido detallePedido12 = new DetallePedido();
													detallePedido12.setCantidad(100); // 100 gramos de cebolla
													detallePedido12.setArticuloInsumo(articuloInsumoCebolla);

													pedido4.getDetallePedidos().add(detallePedido12);

														// Crear una factura para el pedido
															Factura factura3 = new Factura();
															factura3.setNumero(2);
															Date fechaFacturacion3 = dateFormat.parse("2023-07-15");
															factura3.setFechaFacturacion(fechaFacturacion3);
															factura3.setMpPaymentID(987654L);
															factura3.setMpMerchantOrderId(54321L);
															factura3.setMpPreferentsId("preferencia456");
															factura3.setMpPaymentType("MERCADO_PAGO");
															factura3.setTotalVenta(150.0);
															String horaEstimada3 = "17:30:00";
															Date horaEstimadaEntrega3 = horaFormat.parse(horaEstimada3);
															factura3.setHoraEstimidaEntrega(horaEstimadaEntrega3);
															factura3.setFormaPago(Factura.FormaPago.MERCADO_PAGO);

															pedido4.setFactura(factura3);

															// Agregar el pedido al cliente
															cliente3.getPedido().add(pedido4);


				Cliente cliente4 = new Cliente();
				cliente4.setNombre("Valentin");
				cliente4.setApellido("Miranda");
				cliente4.setTelefono("26123452");
				cliente4.setEmail("miranda1234@gmail.com");
				cliente4.setFechaAlta(fechaAlta);

				// Domicilio del nuevo cliente
				Domicilio domicilio5 = new Domicilio();
				domicilio5.setLocalidad("Las Heras");
				domicilio5.setCalle("Belgrano");
				domicilio5.setNumero("789");

				cliente4.getDomicilios().add(domicilio5);

				// Crear un nuevo usuario para el cliente
				Usuario usuario4 = new Usuario();
				usuario4.setNombreUsuario("Valen9");
				usuario4.setContraseña(passwordEncoder.encode("1234"));
				usuario4.setRol(Usuario.Rol.CLIENTE);
				usuario4.setFechaAlta(fechaAlta);

				cliente4.setUsuario(usuario4);

				// Crear un nuevo pedido para el cliente
				Pedido pedido5 = new Pedido();
				pedido5.setFechapedido(fechaPedido);
				pedido5.setHoraEstimidaEntrega("40min");
				pedido5.setTotal(6000);
				pedido5.setEstado(Pedido.EstadoPedido.PREPARACION);
				pedido5.setTipoEnvio(Pedido.TipoEnvio.TAKE_AWAY);

				// Agregar un detalle de pedido para una pizza
				DetallePedido detallePedido13 = new DetallePedido();
				detallePedido13.setCantidad(1);
				detallePedido13.setArticuloManufacturado(articuloManufacturadoPizza);

			// Calcular el subtotal del detallePedido13
				double precioPizza = articuloManufacturadoPizza.getPrecioVenta();
				double subTotal3 = detallePedido13.getCantidad() * precioPizza;
				detallePedido13.setSubTotal(subTotal3);

				pedido5.getDetallePedidos().add(detallePedido13);

				// Agregar detalles de cantidad de insumos consumidos para la pizza
				// Cantidad de Tomate
				DetallePedido detallePedido14 = new DetallePedido();
				detallePedido14.setCantidad(300); // 300 gramos de tomate
				detallePedido14.setArticuloInsumo(articuloInsumoTomate);

				pedido5.getDetallePedidos().add(detallePedido14);

				// Cantidad de Queso
				DetallePedido detallePedido15 = new DetallePedido();
				detallePedido15.setCantidad(200);
				detallePedido15.setArticuloInsumo(articuloInsumoQueso);

				pedido5.getDetallePedidos().add(detallePedido15);

				// Cantidad de Salsa
				DetallePedido detallePedido16 = new DetallePedido();
				detallePedido16.setCantidad(50); // 50 botellas de salsa
				detallePedido16.setArticuloInsumo(articuloInsumoSalsa);

				pedido5.getDetallePedidos().add(detallePedido16);

				// Cantidad de Pan
				DetallePedido detallePedido17 = new DetallePedido();
				detallePedido17.setCantidad(1);
				detallePedido17.setArticuloInsumo(articuloInsumoPan);

				pedido5.getDetallePedidos().add(detallePedido17);

				// Crear una factura para el pedido
				Factura factura4 = new Factura();
				factura4.setNumero(3);
				Date fechaFacturacion4 = dateFormat.parse("2023-08-10");
				factura4.setFechaFacturacion(fechaFacturacion4);
				factura4.setMpPaymentID(13579L);
				factura4.setMpMerchantOrderId(24680L);
				factura4.setMpPreferentsId("preferencia789");
				factura4.setMpPaymentType("MERCADO_PAGO");
				factura4.setTotalVenta(180.0);
				String horaEstimada4 = "18:30:00";
				Date horaEstimadaEntrega4 = horaFormat.parse(horaEstimada4);
				factura4.setHoraEstimidaEntrega(horaEstimadaEntrega4);
				factura4.setFormaPago(Factura.FormaPago.EFECTIVO);

				pedido5.setFactura(factura4);

				// Agregar el pedido al cliente
				cliente4.getPedido().add(pedido5);






				Cliente cliente5 = new Cliente();
				cliente5.setNombre("Franco");
				cliente5.setApellido("Ivani");
				cliente5.setTelefono("261352345");
				cliente5.setEmail("franquito45@gmail.com");
				cliente5.setFechaAlta(fechaAlta);

				// Domicilio del nuevo cliente
				Domicilio domicilio6 = new Domicilio();
				domicilio6.setLocalidad("Godoy Cruz");
				domicilio6.setCalle("San Juan");
				domicilio6.setNumero("456");

				cliente5.getDomicilios().add(domicilio6);

				// Crear un nuevo usuario para el cliente
				Usuario usuario5 = new Usuario();
				usuario5.setNombreUsuario("Ivanii");
				usuario5.setContraseña(passwordEncoder.encode("5678"));
				usuario5.setRol(Usuario.Rol.CLIENTE);
				usuario5.setFechaAlta(fechaAlta);

				cliente5.setUsuario(usuario5);

				// Crear varios pedidos para el cliente
				Pedido pedido6 = new Pedido();
				pedido6.setFechapedido(fechaPedido);
				pedido6.setHoraEstimidaEntrega("30min");
				pedido6.setTotal(3000);
				pedido6.setEstado(Pedido.EstadoPedido.CANCELADO);
				pedido6.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);

				// Agregar un detalle de pedido para las papas fritas
				DetallePedido detallePedido18 = new DetallePedido();
				detallePedido18.setCantidad(1);
				detallePedido18.setArticuloManufacturado(articuloManufacturadoPapas);

				// Calcular el subtotal del detallePedido18
				double precioPapas = articuloManufacturadoPapas.getPrecioVenta();
				double subTotal4 = detallePedido18.getCantidad() * precioPapas;
				detallePedido18.setSubTotal(subTotal4);

				pedido6.getDetallePedidos().add(detallePedido18);


// Crear otro pedido para hamburguesas
				Pedido pedido7 = new Pedido();
				pedido7.setFechapedido(fechaPedido);
				pedido7.setHoraEstimidaEntrega("40min");
				pedido7.setTotal(4000);
				pedido7.setEstado(Pedido.EstadoPedido.PREPARACION);
				pedido7.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);

// Agregar un detalle de pedido para hamburguesas
				DetallePedido detallePedido19 = new DetallePedido();
				detallePedido19.setCantidad(2);
				detallePedido19.setArticuloManufacturado(articuloManufacturadoHamburguesa);

// Calcular el subtotal del detallePedido19
				double precioHamburguesa3 = articuloManufacturadoHamburguesa.getPrecioVenta();
				double subTotal5 = detallePedido19.getCantidad() * precioHamburguesa3;
				detallePedido19.setSubTotal(subTotal5);

				pedido7.getDetallePedidos().add(detallePedido19);

// Agregar detalles de cantidad de insumos consumidos para las hamburguesas
// Cantidad de Pan
				DetallePedido detallePedido20 = new DetallePedido();
				detallePedido20.setCantidad(4);
				detallePedido20.setArticuloInsumo(articuloInsumoPan);

				pedido7.getDetallePedidos().add(detallePedido20);

// Cantidad de Lechuga
				DetallePedido detallePedido21 = new DetallePedido();
				detallePedido21.setCantidad(300);
				detallePedido21.setArticuloInsumo(articuloInsumoLechuga);

				pedido7.getDetallePedidos().add(detallePedido21);

// Cantidad de Tomate
				DetallePedido detallePedido22 = new DetallePedido();
				detallePedido22.setCantidad(250);
				detallePedido22.setArticuloInsumo(articuloInsumoTomate);

				pedido7.getDetallePedidos().add(detallePedido22);

// Crear otro pedido para pizzas
				Pedido pedido8 = new Pedido();
				pedido8.setFechapedido(fechaPedido);
				pedido8.setHoraEstimidaEntrega("35min");
				pedido8.setTotal(3500);
				pedido8.setEstado(Pedido.EstadoPedido.PREPARACION);
				pedido8.setTipoEnvio(Pedido.TipoEnvio.TAKE_AWAY);

// Agregar un detalle de pedido para pizzas
				DetallePedido detallePedido23 = new DetallePedido();
				detallePedido23.setCantidad(1);
				detallePedido23.setArticuloManufacturado(articuloManufacturadoPizza);

// Calcular el subtotal del detallePedido23
				double precioPizza2 = articuloManufacturadoPizza.getPrecioVenta();
				double subTotal6 = detallePedido23.getCantidad() * precioPizza2;
				detallePedido23.setSubTotal(subTotal6);

				pedido8.getDetallePedidos().add(detallePedido23);

// Agregar detalles de cantidad de insumos consumidos para las pizzas
// Cantidad de Tomate
				DetallePedido detallePedido24 = new DetallePedido();
				detallePedido24.setCantidad(200);
				detallePedido24.setArticuloInsumo(articuloInsumoTomate);

				pedido8.getDetallePedidos().add(detallePedido24);

// Cantidad de Queso
				DetallePedido detallePedido25 = new DetallePedido();
				detallePedido25.setCantidad(150);
				detallePedido25.setArticuloInsumo(articuloInsumoQueso);

				pedido8.getDetallePedidos().add(detallePedido25);

// Cantidad de Salsa
				DetallePedido detallePedido26 = new DetallePedido();
				detallePedido26.setCantidad(30); // 30 botellas de salsa
				detallePedido26.setArticuloInsumo(articuloInsumoSalsa);

				pedido8.getDetallePedidos().add(detallePedido26);

// Agregar los pedidos al cliente
				cliente5.getPedido().add(pedido6);
				cliente5.getPedido().add(pedido7);
				cliente5.getPedido().add(pedido8);




				clienteRepository.save(cliente1);
				clienteRepository.save(cliente2);
				clienteRepository.save(cliente3);
				clienteRepository.save(cliente4);
				clienteRepository.save(cliente5);

					} catch (Exception e) {
						System.out.println("Error en la inicialización de datos:" + e.getMessage());
						e.printStackTrace();
					}

				}
			}



