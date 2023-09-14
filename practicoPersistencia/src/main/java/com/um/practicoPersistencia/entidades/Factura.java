package com.um.practicoPersistencia.entidades;

import com.um.practicoPersistencia.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}
