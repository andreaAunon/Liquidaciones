package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.ProductWarranty;
import lombok.Data;

import java.util.Date;

@Data
public class DamageDTO {
    private Long id;
    private String motivo;
    private Date antiguedad;
    private ProductWarranty warranty;
}
