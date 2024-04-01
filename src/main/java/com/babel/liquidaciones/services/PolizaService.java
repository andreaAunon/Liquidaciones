package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.repository.IPolizaRepository;
import com.babel.liquidaciones.services.interfaces.IPolizaService;

import java.util.List;
import java.util.Optional;

public class PolizaService implements IPolizaService {

    private IPolizaRepository polizaRepository;

    public PolizaService(IPolizaRepository polizaRepository){
        this.polizaRepository = polizaRepository;
    }

    @Override
    public List<Poliza> findPolizasByUser(Cliente cliente) {
        return polizaRepository.findByCliente(cliente);
    }

    @Override
    public Poliza findPolizaByCode(String code) {
        Optional<Poliza> poliza = this.polizaRepository.findById(code);

        if(poliza.isPresent()){
            return poliza.get();
        }

        return null;
    }
}
