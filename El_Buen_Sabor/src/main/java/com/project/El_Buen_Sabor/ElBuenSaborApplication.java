package com.project.El_Buen_Sabor;

import com.project.El_Buen_Sabor.entities.*;
import com.project.El_Buen_Sabor.repositories.*;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoServiceImpl;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoServiceImpl;
import com.project.El_Buen_Sabor.services.ClienteService.ClienteServiceImpl;
import com.project.El_Buen_Sabor.services.DetalleArticuloManufacturadoService.DetalleArticuloManufacturadoServiceImpl;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
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

	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("--------------------ESTÁ FUNCIONANDO CORRECTAMENTE------------------------");
	}

		@PostConstruct
		public void init () {
			try {
				//articuloManufacturadoService.init();
				//articuloInsumoService.initArticuloInsumo();
				//detalleArticuloManufacturadoService.intitDetalleArticuloManufacturado();
				//clienteService.initClientes();


				//Metodos de inicializacion de datos (harcodeo)


						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaAlta = sdf.parse("23/10/2023");

						//Cliente 1: Pablo Chaparro
						//Domicilio 1: Guaymallén San Jose
						//Domicilio 2:Las Heras Plumerillo
						//Usuario 1: pablo11
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
						usuario1.setContraseña("1234");
						usuario1.setRol(Usuario.Rol.COCINERO);
						usuario1.setFechaAlta(fechaAlta);
						cliente1.setUsuario(usuario1);

						Pedido pedido1 = new Pedido();
						pedido1.setHoraEstimidaEntrega("30min");
						pedido1.setTotal(3000);
						pedido1.setEstado(Pedido.EstadoPedido.COMPLETADO);
						pedido1.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);


						//Cliente 2: Saavedra Francisco
						//Domicilio 3: Guaymallen calle Godoy Cruz 666
						//Usuario 2:
						//Pedido 1: 30min, compretado, delivey
						//Pedido 2: 50min, pagado, take away
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
						usuario2.setContraseña("5678");
						usuario2.setRol(Usuario.Rol.CLIENTE);
						usuario2.setFechaAlta(fechaAlta);

						cliente2.setUsuario(usuario2);

						Pedido pedido2 = new Pedido();
						pedido2.setHoraEstimidaEntrega("50min");
						pedido2.setTotal(5000);
						pedido2.setEstado(Pedido.EstadoPedido.COMPLETADO);
						pedido2.setTipoEnvio(Pedido.TipoEnvio.TAKE_AWAY);

						Pedido pedido3 = new Pedido();
						pedido3.setHoraEstimidaEntrega("30min");
						pedido3.setTotal(5000);
						pedido3.setEstado(Pedido.EstadoPedido.PREPARACION);
						pedido3.setTipoEnvio(Pedido.TipoEnvio.DELIVERY);

						cliente1.getPedido().add(pedido1);
						cliente2.getPedido().add(pedido2);
						cliente2.getPedido().add(pedido3);




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
						articuloInsumoPan.setPrecioCompra(3);




						//Articulos Manufacturados
						//Hamburguesa:
						ArticuloManufacturado articuloManufacturadoHamburguesa = new ArticuloManufacturado();
						articuloManufacturadoHamburguesa.setDenominacion("Hamburguesa");
						articuloManufacturadoHamburguesa.setDescripcion("Hamburguesa con queso");
						articuloManufacturadoHamburguesa.setTiempoEstimadoCocina(15.0);
						articuloManufacturadoHamburguesa.setCosto(500.0);
						articuloManufacturadoHamburguesa.setPrecioVenta(750.0);
						//articulos.add(articuloManufacturadoHamburguesa);

						//Pizza
						ArticuloManufacturado articuloManufacturadoPizza = new ArticuloManufacturado();
						articuloManufacturadoPizza.setDenominacion("Pizza");
						articuloManufacturadoPizza.setDescripcion("Especial");
						articuloManufacturadoPizza.setTiempoEstimadoCocina(15.0);
						articuloManufacturadoPizza.setCosto(900.0);
						articuloManufacturadoPizza.setPrecioVenta(1599.0);
						//articulos.add(articuloManufacturadoPizza);

		//				guardarArticuloManufacturado(articulos);

			//Cantidades de insumos para una hamburguesa
				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaCarne = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaCarne.setCantidad(300); // Cantidad de carne gramos
				detalleArticuloManufacturadoHamburguesaCarne.setArticuloManufacturado(articuloManufacturadoHamburguesa);
				detalleArticuloManufacturadoHamburguesaCarne.setArticuloInsumo(articuloInsumoCarne);



				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaPan = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaPan.setCantidad(2);
				detalleArticuloManufacturadoHamburguesaPan.setArticuloInsumo(articuloInsumoPan);
				detalleArticuloManufacturadoHamburguesaPan.setArticuloManufacturado(articuloManufacturadoHamburguesa);


				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaLechuga = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaLechuga.setCantidad(230);
				detalleArticuloManufacturadoHamburguesaLechuga.setArticuloInsumo(articuloInsumoLechuga);
				detalleArticuloManufacturadoHamburguesaLechuga.setArticuloManufacturado(articuloManufacturadoHamburguesa);


				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaTomate = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaTomate.setCantidad(200); //200 gramos de tomate
				detalleArticuloManufacturadoHamburguesaTomate.setArticuloInsumo(articuloInsumoTomate);
				detalleArticuloManufacturadoHamburguesaTomate.setArticuloManufacturado(articuloManufacturadoHamburguesa);


				DetalleArticuloManufacturado detalleArticuloManufacturadoHamburguesaQueso = new DetalleArticuloManufacturado();
				detalleArticuloManufacturadoHamburguesaQueso.setCantidad(150);
				detalleArticuloManufacturadoHamburguesaQueso.setArticuloInsumo(articuloInsumoQueso);
				detalleArticuloManufacturadoHamburguesaQueso.setArticuloManufacturado(articuloManufacturadoHamburguesa);



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
						usuario3.setContraseña("7896423");
						usuario3.setRol(Usuario.Rol.DELYVERY);
						usuario3.setFechaAlta(fechaAlta);

						cliente3.setUsuario(usuario3);

						Cliente cliente4 = new Cliente();
						cliente4.setNombre("Valentin");
						cliente4.setApellido("Miranda");
						cliente4.setTelefono("26123452");
						cliente4.setEmail("miranda1234@gmail.com");
						cliente4.setFechaAlta(fechaAlta);

						Cliente cliente5 = new Cliente();
						cliente5.setNombre("Franco");
						cliente5.setApellido("Ivani");
						cliente5.setTelefono("261352345");
						cliente5.setEmail("franquito45@gmail.com");
						cliente5.setFechaAlta(fechaAlta);

						// Guardar los clientes en la base de datos


						articuloManufacturadoRepository.save(articuloManufacturadoHamburguesa);


						articuloInsumoRepository.save(articuloInsumoTomate);
						articuloInsumoRepository.save(articuloInsumoCarne);
						articuloInsumoRepository.save(articuloInsumoLechuga);
						articuloInsumoRepository.save(articuloInsumoPan);
						articuloInsumoRepository.save(articuloInsumoQueso);
						detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturadoHamburguesaCarne);
						detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturadoHamburguesaPan);
						detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturadoHamburguesaLechuga);
						detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturadoHamburguesaTomate);
						detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturadoHamburguesaQueso);
				clienteRepository.save(cliente1);
				clienteRepository.save(cliente2);
				clienteRepository.save(cliente3);
				clienteRepository.save(cliente4);
				clienteRepository.save(cliente5);
				pedidoRepository.save(pedido1);
				pedidoRepository.save(pedido2);
				pedidoRepository.save(pedido3);
				detallePedidoRepository.save(detallePedido2);
				detallePedidoRepository.save(detallePedido3);
				detallePedidoRepository.save(detallePedido4);
				detallePedidoRepository.save(detallePedido5);
				detallePedidoRepository.save(detallePedido6);



					} catch (Exception e) {
						System.out.println("Error en la inicialización de datos:" + e.getMessage());
						e.printStackTrace();
					}

				}
			}



