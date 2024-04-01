package com.babel.liquidaciones.dtos;

import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.model.Poliza;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SiniestroDTO {
    private Long id;
    private Date fechaDeOcurrencia;
    private String causa;
    private List<Damage> listaDeDamages;
    private Poliza polizaAsociada;

    public Damage getDano(int index){
        return listaDeDamages.get(index);
    }

}
