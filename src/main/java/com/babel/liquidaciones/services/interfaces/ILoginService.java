package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Cliente;

public interface ILoginService {

    String login(String usuario, String password);
    Cliente getUsuarioLogueado();
    Cliente findByNombreAndPassword(String nombre, String password);
}
