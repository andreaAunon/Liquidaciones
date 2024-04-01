package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.Poliza;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ClienteDTO {
    private String nif;
    private String nombre;
    private String password;
    private String direction;
    private String contacto;
    private Poliza poliza;

}
