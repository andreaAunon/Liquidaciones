package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.services.interfaces.ILoginService;
import com.babel.liquidaciones.services.interfaces.IPolizaService;
import com.babel.liquidaciones.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private ILoginService loginService;
    private IPolizaService polizaService;

    public UserService(ILoginService loginService, IPolizaService polizaService) {
        this.loginService = loginService;
        this.polizaService = polizaService;
    }

    @Override
    public void verPolizas() {
        System.out.println("Polizas del usuario: ");
        List<Poliza> polizaList = this.polizaService.findPolizasByUser(this.loginService.getUsuarioLogueado());

        polizaList.forEach(poliza -> {
            System.out.printf("Poliza - Código: %s,  Importe: %d, Producto: %s", poliza.getCode(), poliza.getImporteCapitalesContratados(), poliza.getProducto().getCode());
        });
    }
}
