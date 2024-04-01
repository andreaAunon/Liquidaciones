package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Damage;

public interface IDamageService {

    void addDamage(Damage damage);
    Damage findDamageById(Long id);
    String updateDamage(Damage damage);
}
