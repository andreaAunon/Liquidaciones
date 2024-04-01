package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.model.Product;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PolizaDTO {
    private String code;
    private Integer importeCapitalesContratados;
    private Cliente clienteAsociado;
    private Product producto;

}
