package com.project.El_Buen_Sabor.services.ClienteService;


import com.project.El_Buen_Sabor.entities.*;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.ClienteRepository;
import com.project.El_Buen_Sabor.repositories.DetallePedidoRepository;
import com.project.El_Buen_Sabor.services.ArticuloInsumoService.ArticuloInsumoService;
import com.project.El_Buen_Sabor.services.ArticuloManufacturadoService.ArticuloManufacturadoService;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //Harcodeo-------------------------------------
    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchPaged(filtro, pageable);
            return clientes;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }



    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;
    @Autowired
    private ArticuloInsumoService articuloInsumoService;


    //Metodos de inicializacion de datos (harcodeo)
    public void initClientes() throws Exception {
        try {
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

            cliente2.getPedido().add(pedido2);
            cliente2.getPedido().add(pedido3);


            // Obtener el artículo manufacturado "Hamburguesa" de la base de datos
            ArticuloManufacturado articuloManufacturadoHamburguesa = articuloManufacturadoService.obtenerArticuloHamburguesa();

            // Obtener el artículos insumos de la base de datos
            ArticuloInsumo articuloInsumoQueso = articuloInsumoService.findByDenominacion("Queso");
            ArticuloInsumo articuloInsumoPan = articuloInsumoService.findByDenominacion("Pan");
            ArticuloInsumo articuloInsumoLechuga = articuloInsumoService.findByDenominacion("Lechuga");
            ArticuloInsumo articuloInsumoTomate = articuloInsumoService.findByDenominacion("Tomate");
            ArticuloInsumo articuloInsumoCarne = articuloInsumoService.findByDenominacion("Carne");


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
            save(cliente1);
            save(cliente2);
            save(cliente3);
            save(cliente4);
            save(cliente5);
        } catch (Exception e) {
            System.out.println("Error en la inicialización de datos:" + e.getMessage());
            e.printStackTrace();
        }

    }

}




