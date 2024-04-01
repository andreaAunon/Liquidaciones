package com.babel.liquidaciones.repository;

import com.babel.liquidaciones.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISinistroRepository extends JpaRepository<Siniestro,Long> {
}
