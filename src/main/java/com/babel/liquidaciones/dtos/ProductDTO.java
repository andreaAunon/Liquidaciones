package com.babel.liquidaciones.dtos;


import com.babel.liquidaciones.model.ProductWarranty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String code;
    private String name;
    List<ProductWarranty> productWarranties;


}
