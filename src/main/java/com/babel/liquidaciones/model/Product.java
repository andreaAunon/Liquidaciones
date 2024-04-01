package com.babel.liquidaciones.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private String code;
    private String name;

    @ManyToOne
    List<ProductWarranty> productWarranties;


}
