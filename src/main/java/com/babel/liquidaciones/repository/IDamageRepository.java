package com.babel.liquidaciones.repository;

import com.babel.liquidaciones.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDamageRepository extends JpaRepository<Damage,Long> {
}
