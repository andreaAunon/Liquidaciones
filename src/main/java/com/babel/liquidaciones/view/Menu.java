package com.babel.liquidaciones.view;

import com.babel.liquidaciones.services.interfaces.ILoginService;
import com.babel.liquidaciones.services.ISiniestroService;
import com.babel.liquidaciones.services.interfaces.IUserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    private Scanner scanner;
    private boolean isInSession;
    private ILoginService loginService;
    private ISiniestroService siniestrosService;
    private IUserService userService;

    public Menu(ILoginService loginService, ISiniestroService siniestrosService, IUserService userService) {
        this.loginService = loginService;
        this.userService = userService;
        this.siniestrosService = siniestrosService;
        this.scanner = new Scanner(System.in);
        this.isInSession = true;
    }

    public void startSession() {
        if (this.loginService.login()) {
            while (isInSession) {
                inicioMenu();
            }
        }
    }

    private void inicioMenu() {
        System.out.println("Bienvenido, elija la acción que desea realizar: ");
        System.out.println("1. Dar de alta un siniestro");
        System.out.println("2. Salir");
        System.out.println("3. Ver polizas");
        creacionAcciones();
    }

    private void creacionAcciones() {
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                this.siniestrosService.generarSiniestro();
                break;
            case "2":
                this.isInSession = false;
                break;
            case "3":
                this.userService.verPolizas();
                break;
            default:
                break;
        }
    }

}
