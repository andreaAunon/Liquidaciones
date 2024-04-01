package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.ProductWarranty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class DanoDTO {
    private Long id;
    private String motivo;
    private Date antiguedad;
    private ProductWarranty warranty;
}
