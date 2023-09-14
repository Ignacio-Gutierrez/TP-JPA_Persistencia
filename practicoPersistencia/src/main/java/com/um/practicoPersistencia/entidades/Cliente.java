package com.um.practicoPersistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();


    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    public void agregarPedido(Pedido ped){
        pedidos.add(ped);
    }



    public void mostrarDomicilios(){
        System.out.println("Domicilio/s de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio: domicilios){
            System.out.println("Calle: " + domicilio.getCalle() + ", número: " + domicilio.getNumero());
        }
    }
    public void mostrarPedidos(){
        System.out.println("Pedido/s de " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() + ". Total: " + pedido.getTotal());
            for (DetallePedido detallePedido : pedido.getDetallePedidos()) {
                System.out.println("   " + detallePedido.getCantidad() + " " + detallePedido.getProducto().getDenominacion()
                        + " | " + "Precio: " + detallePedido.getSubtotal());
            }
        }
    }
}
