package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.model.Siniestro;
import org.springframework.web.bind.annotation.RequestParam;

public interface ISiniestroService {

    String generarSiniestro(String codigoPoliza, String fecha, String causaSiniestro);
    void altaSiniestro(Siniestro siniestro);
    Siniestro findSiniestroById(Long id);
    String updateSiniestro(Siniestro siniestro,Long id);
    String addDamage(Damage damage, Long id);
    Damage findDamage(Long idSiniestro, Long idDamage);
    String updateDamage(Long idSiniestro, Long idDamage);
    String deleteDamage(Long idSiniestro, Long idDamage);
}