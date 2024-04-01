package com.babel.liquidaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ProductWarranty {
    @Id
    @GeneratedValue
    private String id;

    private boolean excluded;
    private String paymentType;
    private double capitalInsured;

    @OneToOne
    private Risk risk;
    @OneToOne
    private Warranty warranty;
}
