package com.um.practicoPersistencia;

import com.um.practicoPersistencia.entidades.*;
import com.um.practicoPersistencia.enumeraciones.EstadoPedido;
import com.um.practicoPersistencia.enumeraciones.FormaPago;
import com.um.practicoPersistencia.enumeraciones.TipoEnvio;
import com.um.practicoPersistencia.enumeraciones.TipoPedido;
import com.um.practicoPersistencia.repositorios.ClienteRepository;
import com.um.practicoPersistencia.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class PracticoPersistenciaApplication {


	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticoPersistenciaApplication.class, args);
		System.out.println("..........................Sigo funcionando...........................");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository, ClienteRepository clienteRepository) {
		return args -> {
			System.out.println("------------------FUNCIONANDO---------------------");
			///HAMBURUESAS
			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesas")
					.build();
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(30)
					.denominacion("Hamburguesa de Suprema")
					.precioVenta(2000)
					.precioCompra(1200)
					.stockActual(50)
					.stockMinimo(3)
					.unidadMedida("unidad")
					.receta("receta1")
					.tipo(TipoPedido.Insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(30)
					.denominacion("Hamburguesa de Carne")
					.precioVenta(2200)
					.precioCompra(1500)
					.stockActual(32)
					.stockMinimo(4)
					.unidadMedida("unidad")
					.receta("receta2")
					.tipo(TipoPedido.Insumo)
					.build();


			///NUGGETS
			Rubro rubro2 = Rubro.builder()
					.denominacion("Nuggets")
					.build();
			Producto producto3 = Producto.builder()
					.tiempoEstimadoCocina(25)
					.denominacion("Nuggets de Pollo")
					.precioVenta(1500)
					.precioCompra(800)
					.stockActual(265)
					.stockMinimo(60)
					.unidadMedida("unidad")
					.receta("receta3")
					.tipo(TipoPedido.Insumo)
					.build();

			//Agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubro2.agregarProducto(producto3);

			rubroRepository.save(rubro1);
			rubroRepository.save(rubro2);

			///CLIENTE
			Cliente cliente1 = Cliente.builder()
					.nombre("Lautaro")
					.apellido("Martinez")
					.email("lautimartinez@gmail.com")
					.telefono("telefono1")
					.build();
			Cliente cliente2 = Cliente.builder()
					.nombre("José")
					.apellido("Rodríguez")
					.email("jose_rodri@hotmail.com")
					.telefono("telefono2")
					.build();

			//DOMICILIO
			Domicilio domicilio1 = Domicilio.builder()
					.calle("San Martin")
					.numero(6538)
					.localidad("Lujan")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Las Heras")
					.numero(1223)
					.localidad("Ciudad")
					.build();
			Domicilio domicilio3= Domicilio.builder()
					.calle("Lavalle")
					.numero(116)
					.localidad("Godoy Cruz")
					.build();

			//Agregar domicilios a cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			cliente2.agregarDomicilio(domicilio3);


			//DETALLES PEDIDO
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(4000)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(2200)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(6000)
					.build();
			DetallePedido detallePedido4 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(3000)
					.build();

			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-14";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);

			//PEDIDO
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(6200)
					.estado(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(6000)
					.estado(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.Delivery)
					.build();
			Pedido pedido3 = Pedido.builder()
					.fecha(fecha)
					.total(3000)
					.estado(EstadoPedido.Preparacion)
					.tipoEnvio(TipoEnvio.Retira)
					.build();

			//FACTURA
			Factura factura1 = Factura.builder()
					.fecha(fecha)
					.total(5800)
					.numero(1)
					.descuento(400)
					.formaPago(FormaPago.Efectivo)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(5400)
					.numero(2)
					.descuento(600)
					.formaPago(FormaPago.Efectivo)
					.build();
			Factura factura3 = Factura.builder()
					.fecha(fecha)
					.total(3000)
					.numero(3)
					.descuento(0)
					.formaPago(FormaPago.Tarjeta)
					.build();


			//Agregar detalles al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);
			pedido3.agregarDetallePedido(detallePedido4);

			//Agregar pedidos al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);

			//Vincular el detalle pedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			detallePedido4.setProducto(producto3);

			//Vincular factura con pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			pedido3.setFactura(factura3);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//Recuperar objeto rubro desde la base de datos
			System.out.println("COMIDA");
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			System.out.println(" ");
			rubroRecuperado = rubroRepository.findById(rubro2.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			System.out.println("..........................................................");

			//Recuperar Cliente desde la base de Datos
			System.out.println("CLIENTES");
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
			System.out.println(" ");
			clienteRecuperado = clienteRepository.findById(cliente2.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
		};
	}
}
