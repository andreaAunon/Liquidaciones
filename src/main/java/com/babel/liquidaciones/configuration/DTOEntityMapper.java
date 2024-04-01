package com.babel.liquidaciones.configuration;

import com.babel.liquidaciones.dtos.DamageDTO;
import com.babel.liquidaciones.dtos.SiniestroDTO;
import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.model.Siniestro;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DTOEntityMapper {
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static SiniestroDTO siniestroToDTO(Siniestro siniestro) {
        return mapper.map(siniestro, SiniestroDTO.class);
    }

    public static Siniestro DTOToSiniestro(SiniestroDTO siniestroDTO) {
        return mapper.map(siniestroDTO, Siniestro.class);
    }

    public static DamageDTO damageToDTO(Damage damage) {
        return mapper.map(damage, DamageDTO.class);
    }

    public static Damage DTOToDamage(DamageDTO damageDTO) {
        return mapper.map(damageDTO, Damage.class);
    }

}
