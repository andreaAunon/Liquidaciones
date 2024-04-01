package com.babel.liquidaciones.repository;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPolizaRepository extends JpaRepository<Poliza,String> {
    List<Poliza> findByCliente(Cliente cliente);
}
