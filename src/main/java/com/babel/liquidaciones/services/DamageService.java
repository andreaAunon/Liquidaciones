package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Damage;
import com.babel.liquidaciones.repository.IDamageRepository;
import com.babel.liquidaciones.services.interfaces.IDamageService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DamageService implements IDamageService {

    private IDamageRepository damageRepository;

    public DamageService(IDamageRepository damageRepository){
        this.damageRepository = damageRepository;
    }

    @Override
    public void addDamage(Damage damage) {
        this.damageRepository.save(damage);
    }

    @Override
    public Damage findDamageById(Long id) {
        Optional<Damage> damage = this.damageRepository.findById(id);

        if(damage.isPresent()){
            return damage.get();
        }

        return null;
    }

    @Override
    public String updateDamage(Damage damage) {
        Damage damageBD = findDamageById(damage.getId());

        if(damage != null){
            damageBD.setAntiguedad(damage.getAntiguedad());
            damageBD.setMotivo(damage.getMotivo());
            damageBD.setWarranty(damage.getWarranty());
            this.damageRepository.save(damageBD);
            return "Daño actualizado correctamente";
        }

        return "Daño no encontrado";
    }
}
