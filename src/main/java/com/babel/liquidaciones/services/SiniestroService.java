package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Dano;
import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.model.Siniestro;
import com.babel.liquidaciones.repository.ISiniestroRepository;
import com.babel.liquidaciones.services.interfaces.IPolizaService;
import com.babel.liquidaciones.services.interfaces.ISiniestroService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SiniestroService implements ISiniestroService {

    private IPolizaService polizaService;
    private ISiniestroRepository siniestroRepository;

    public SiniestroService(IPolizaService polizaService,
                            ISiniestroRepository siniestroRepository) {
        this.polizaService = polizaService;
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public String generarSiniestro(String codigoPoliza, String fecha, String causaSiniestro) {
        Poliza polizaAsociada = getpolizaByCode(codigoPoliza);

        if (polizaAsociada == null) {
            return "Poliza inexistente";
        }

        Date fechaSiniestro = null;
        try {
            fechaSiniestro = procesarFecha(fecha);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha incorrecto");
        }
        List<Dano> danos = procesarDanos(codigoPoliza);

        return registrarSiniestro(danos, causaSiniestro, fechaSiniestro, polizaAsociada);
    }

    @Override
    public void altaSiniestro(Siniestro siniestro) {
        this.siniestroRepository.save(siniestro);
    }

    private String registrarSiniestro(List<Dano> danos, String causaSiniestro, Date fechaSiniestro, Poliza polizaAsociada) {
        Siniestro siniestro = new Siniestro();
        siniestro.setListaDeDanos(danos);
        siniestro.setCausa(causaSiniestro);
        siniestro.setFechaDeOcurrencia(fechaSiniestro);
        siniestro.setPolizaAsociada(polizaAsociada);

        altaSiniestro(siniestro);
        return "Siniestro registrado";
    }

    private Date procesarFecha(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.GERMAN);
        return formatter.parse(fecha);
    }

    private List<Dano> procesarDanos(String codigoPoliza) {
        List<Dano> danos = new ArrayList<>();

        if (codigoPoliza.equalsIgnoreCase("exit")) {
            return danos;
        }

        Dano dano = new Dano();
        danos.add(dano);
        return danos;
    }

    private Poliza getpolizaByCode(String code){
        return this.polizaService.findPolizaByCode(code);
    }

}
