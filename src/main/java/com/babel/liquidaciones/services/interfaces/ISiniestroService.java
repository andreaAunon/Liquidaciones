package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Siniestro;

public interface ISiniestroService {

    String generarSiniestro(String codigoPoliza, String fecha, String causaSiniestro);
    void altaSiniestro(Siniestro siniestro);

}
