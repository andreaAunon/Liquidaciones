package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Damage;

public interface ICalculoValService {
    public Double calcularPrimerRiesgo(Damage daño);
    public Double calcularReposicion(Damage daño);
    public Double calcularValorReal(Damage daño);
}
