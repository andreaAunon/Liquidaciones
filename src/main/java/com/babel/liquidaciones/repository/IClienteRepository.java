package com.babel.liquidaciones.repository;

import com.babel.liquidaciones.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente,String> {
    Optional<Cliente> findByNombreAndPassword(String nombre, String password);
}
