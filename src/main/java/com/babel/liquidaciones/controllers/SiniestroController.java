package com.babel.liquidaciones.controllers;

import com.babel.liquidaciones.configuration.DTOEntityMapper;
import com.babel.liquidaciones.dtos.DamageDTO;
import com.babel.liquidaciones.dtos.SiniestroDTO;
import com.babel.liquidaciones.services.interfaces.ICalculoValService;
import com.babel.liquidaciones.services.interfaces.ISiniestroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/sinester")
public class SiniestroController {

    private ISiniestroService siniestroService;
    private ICalculoValService calculoValService;

    public SiniestroController(ISiniestroService siniestroService,
                               ICalculoValService calculoValService){
        this.siniestroService = siniestroService;
        this.calculoValService = calculoValService;
    }

    @PostMapping
    @ResponseBody
    public String altaSiniestro(@RequestBody String codigoPoliza, @RequestBody String fecha,
                              @RequestBody String causaSiniestro) {
        return this.siniestroService.generarSiniestro(codigoPoliza, fecha, causaSiniestro);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SiniestroDTO getSiniestroById(@RequestParam Long id) {
        return DTOEntityMapper.siniestroToDTO(this.siniestroService.findSiniestroById(id));
    }

    @PutMapping("/{id}")
    public String updateSinester(@RequestBody SiniestroDTO siniestroDTO, @RequestParam Long id) {
        return this.siniestroService.updateSiniestro(DTOEntityMapper.DTOToSiniestro(siniestroDTO),id);
    }

    @PostMapping("/{id}/damages")
    public String addDamage(@RequestBody DamageDTO dano, @RequestParam Long id) {
        return this.siniestroService.addDamage(DTOEntityMapper.DTOToDamage(dano),id);
    }

    @GetMapping("/{id}/damages/{id}")
    @ResponseBody
    public DamageDTO getDamage(@RequestParam Long idSiniestro,@RequestParam Long idDamage) {
        return DTOEntityMapper.damageToDTO(this.siniestroService.findDamage(idSiniestro,idDamage));
    }

    @PutMapping("/{id}/damages/{id}")
    public String updateDamage(@RequestParam Long idSiniestro,@RequestParam Long idDamage) {
        return this.siniestroService.updateDamage(idSiniestro,idDamage);
    }

    @DeleteMapping("/{id}/damages/{id}")
    public String deleteDamage(@RequestParam Long idSiniestro,@RequestParam Long idDamage) {
        return this.siniestroService.deleteDamage(idSiniestro,idDamage);
    }

    @PostMapping("/{id}/liquidation")
    public String getLiquidation(@RequestParam Long idSiniestro) {

    }
}
