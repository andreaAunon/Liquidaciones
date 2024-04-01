package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.Risk;
import com.babel.liquidaciones.model.Warranty;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ProductWarrantyDTO {
    private String id;
    private boolean excluded;
    private String paymentType;
    private double capitalInsured;
    private Risk risk;
    private Warranty warranty;
}
