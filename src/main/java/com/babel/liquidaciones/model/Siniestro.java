package com.babel.liquidaciones.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Siniestro {
    @Id
    @GeneratedValue
    private Long id;

    private Date fechaDeOcurrencia;
    private String causa;
    @ManyToOne
    private List<Dano> listaDeDanos;
    @OneToOne
    private Poliza polizaAsociada;

}
