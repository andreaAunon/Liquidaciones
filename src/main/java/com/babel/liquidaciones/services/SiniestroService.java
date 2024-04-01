package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.model.Siniestro;
import com.babel.liquidaciones.repository.ISiniestroRepository;
import com.babel.liquidaciones.services.interfaces.IDamageService;
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
    private IDamageService damageService;

    public SiniestroService(IPolizaService polizaService,
                            ISiniestroRepository siniestroRepository,
                            IDamageService damageService) {
        this.polizaService = polizaService;
        this.siniestroRepository = siniestroRepository;
        this.damageService = damageService;
    }

    @Override
    public String generarSiniestro(String codigoPoliza, String fecha, String causaSiniestro) {
        Poliza polizaAsociada = getPolizaByCode(codigoPoliza);

        if (polizaAsociada == null) {
            return "Poliza inexistente";
        }

        Date fechaSiniestro = null;
        try {
            fechaSiniestro = procesarFecha(fecha);
        } catch (ParseException e) {
            return "Formato de fecha incorrecto";
        }
        List<Damage> damages = procesarDanos(codigoPoliza);

        return registrarSiniestro(damages, causaSiniestro, fechaSiniestro, polizaAsociada);
    }

    @Override
    public void altaSiniestro(Siniestro siniestro) {
        this.siniestroRepository.save(siniestro);
    }

    @Override
    public Siniestro findSiniestroById(Long id) {
        Optional<Siniestro> siniestro = this.siniestroRepository.findById(id);

        if(siniestro.isPresent()){
            return siniestro.get();
        }

        return null;
    }

    @Override
    public String updateSiniestro(Siniestro siniestro, Long id) {
        Siniestro siniestroBD = findSiniestroById(id);

        if(siniestroBD != null){
            siniestroBD.setListaDeDamages(siniestro.getListaDeDamages());
            siniestroBD.setCausa(siniestro.getCausa());
            siniestroBD.setPolizaAsociada(siniestro.getPolizaAsociada());
            siniestroBD.setCausa(siniestro.getCausa());
            siniestroBD.setFechaDeOcurrencia(siniestro.getFechaDeOcurrencia());
            this.siniestroRepository.save(siniestroBD);
            return "Siniestro actualizado correctamente";
        } else {
            return "El siniestro introducido no existe";
        }
    }

    @Override
    public String addDamage(Damage damage, Long id) {
        Damage damageBD = this.damageService.findDamageById(damage.getId());
        Siniestro siniestroBD = findSiniestroById(id);

        if(damage != null && siniestroBD != null){
            siniestroBD.getListaDeDamages().add(damage);
            this.siniestroRepository.save(siniestroBD);
            return "Daño añadido correctamente";
        } else {
            return "No se encontró el daño o el siniestro";
        }
    }

    @Override
    public Damage findDamage(Long idSiniestro, Long idDamage) {
        Damage damageBD = this.damageService.findDamageById(idDamage);
        Siniestro siniestroBD = findSiniestroById(idSiniestro);

        if(damageBD != null && siniestroBD != null){
            for(Damage damage : siniestroBD.getListaDeDamages()){
                if(damage.getId() == idDamage){
                    return damage;
                }
            }
        }

        return null;
    }

    @Override
    public String updateDamage(Long idSiniestro, Long idDamage) {
        Damage damage = this.damageService.findDamageById(idDamage);
        Siniestro siniestro = findSiniestroById(idSiniestro);

        if(damage != null && siniestro != null){
            siniestro.getListaDeDamages().remove(damage);
            this.damageService.updateDamage(damage);

            damage = this.damageService.findDamageById(idDamage);
            siniestro.getListaDeDamages().add(damage);
            this.siniestroRepository.save(siniestro);
            return "Daño actualizado";
        } else {
            return "No se encontró el daño o el siniestro";
        }
    }

    @Override
    public String deleteDamage(Long idSiniestro, Long idDamage) {
        Damage damage = this.damageService.findDamageById(idDamage);
        Siniestro siniestro = findSiniestroById(idSiniestro);

        if(damage != null && siniestro != null){
            siniestro.getListaDeDamages().remove(damage);
            this.siniestroRepository.save(siniestro);
            return "Daño eliminado del siniestro";
        } else {
            return "No se encontró el daño o el siniestro";
        }
    }

    private String registrarSiniestro(List<Damage> damages, String causaSiniestro, Date fechaSiniestro, Poliza polizaAsociada) {
        Siniestro siniestro = new Siniestro();
        siniestro.setListaDeDamages(damages);
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

    private List<Damage> procesarDanos(String codigoPoliza) {
        List<Damage> damages = new ArrayList<>();

        if (codigoPoliza.equalsIgnoreCase("exit")) {
            return damages;
        }

        Damage damage = new Damage();
        damages.add(damage);
        return damages;
    }

    private Poliza getPolizaByCode(String code){
        return this.polizaService.findPolizaByCode(code);
    }

}
