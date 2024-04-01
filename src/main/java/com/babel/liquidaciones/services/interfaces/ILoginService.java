package com.babel.liquidaciones.services.interfaces;

import com.babel.liquidaciones.model.Cliente;

public interface ILoginService {

    public boolean login();
    public Cliente getUsuarioLogueado();
}
