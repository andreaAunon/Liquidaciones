package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.model.Poliza;

import java.util.List;

public interface IPolizaService {

    List<Poliza> findPolizasByUser(Cliente cliente);
    Poliza findPolizaByCode(String code);
}
