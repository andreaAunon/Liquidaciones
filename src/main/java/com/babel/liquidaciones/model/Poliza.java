package com.babel.liquidaciones.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Poliza {
    @Id
    @GeneratedValue
    private String code;
    private Integer importeCapitalesContratados;

    @OneToOne
    private Cliente clienteAsociado;
    @OneToOne
    private Product producto;
}
