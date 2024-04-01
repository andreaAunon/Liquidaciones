package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.Dano;
import com.babel.liquidaciones.model.Poliza;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SiniestroDTO {
    private Long id;
    private Date fechaDeOcurrencia;
    private String causa;
    private List<Dano> listaDeDanos;
    private Poliza polizaAsociada;

    public Dano getDano(int index){
        return listaDeDanos.get(index);
    }

}
