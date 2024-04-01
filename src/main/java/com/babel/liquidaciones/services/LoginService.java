package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.model.example.BaseData;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class LoginService implements ILoginService {

    private BaseData data;
    private Cliente clienteLogueado;

    public LoginService(BaseData baseData) {
        this.data = baseData;
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String contraseña = sc.nextLine();
        if (isUserPasswordCorrect(usuario, contraseña)) {
            this.clienteLogueado = this.data.getClienteByNombre(usuario, contraseña);
            return true;
        }
        System.err.println("Usuario o contraseña incorrectas");
        return false;
    }

    @Override
    public Cliente getUsuarioLogueado() {
        return this.clienteLogueado;
    }

    private boolean isUserPasswordCorrect(String usuario, String contraseña) {
        return this.data.getClienteByNombre(usuario, contraseña) != null;
    }


}
