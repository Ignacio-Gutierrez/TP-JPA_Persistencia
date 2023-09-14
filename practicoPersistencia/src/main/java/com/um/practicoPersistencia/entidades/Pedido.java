package com.um.practicoPersistencia.entidades;

import com.um.practicoPersistencia.enumeraciones.EstadoPedido;
import com.um.practicoPersistencia.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{

    private EstadoPedido estado;
    private Date fecha;  // REVISDAR COMO USAR DATE
    private TipoEnvio tipoEnvio;
    private double total;


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();


    public void agregarDetallePedido(DetallePedido detallePedido) {

        detallePedidos.add(detallePedido);
    }
}