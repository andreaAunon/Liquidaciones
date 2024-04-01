package com.babel.liquidaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Damage {
    @Id
    @GeneratedValue
    private Long id;
    private String motivo;
    private Date antiguedad;
    @ManyToOne
    private ProductWarranty warranty;
}
