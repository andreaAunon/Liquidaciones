package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Cliente;

public interface ILoginService {

    public boolean login();
    public Cliente getUsuarioLogueado();
}
