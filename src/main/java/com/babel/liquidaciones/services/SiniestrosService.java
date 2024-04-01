package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Dano;
import com.babel.liquidaciones.model.Poliza;
import com.babel.liquidaciones.model.Siniestro;
import com.babel.liquidaciones.model.example.BaseData;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SiniestrosService implements ISiniestrosService {

    private BaseData data;

    public SiniestrosService(BaseData data) {
        this.data = data;
    }

    @Override
    public void generarSiniestro() {
        Scanner sc = new Scanner(System.in);

        Poliza polizaAsociada = null;
        Boolean polizaCorrecta = false;
        while (!polizaCorrecta) {
            System.out.println("Por favor, introduzca a continuación los datos del siniestro: ");
            System.out.println("Código de Poliza: ");
            String codigoPoliza = sc.nextLine();
            polizaAsociada = obtenerPoliza(codigoPoliza);

            if (polizaAsociada == null) {
                System.err.println("Esa poliza no existe.");
            } else {
                polizaCorrecta = true;
            }

        }

        System.out.println("Fecha de ocurrencia (dd/MM/YYYY): ");
        String fecha = sc.nextLine();
        Date fechaSiniestro = null;
        try {
            fechaSiniestro = procesarFecha(fecha);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha incorrecto");
        }

        System.out.println("Cause de origen del siniestro: ");
        String causaSiniestro = sc.nextLine();

        List<Dano> daños = procesarDaños();

        registrarSiniestro(daños, causaSiniestro, fechaSiniestro, polizaAsociada);
    }

    private void registrarSiniestro(List<Dano> daños, String causaSiniestro, Date fechaSiniestro, Poliza polizaAsociada) {
        Siniestro siniestro = new Siniestro();
        siniestro.setDaños(daños);
        siniestro.setCausa(causaSiniestro);
        siniestro.setFechaDeOcurrencia(fechaSiniestro);
        siniestro.setPolizaAsociada(polizaAsociada);

        this.data.altaSiniestro(siniestro);
        System.out.println("Siniestro registrado");
    }

    private Date procesarFecha(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.GERMAN);
        return formatter.parse(fecha);
    }

    private List<Dano> procesarDaños() {
        System.out.println("Listado de daños");
        List<Dano> daños = new ArrayList<>();
        boolean isDone = false;
        while (!isDone) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Codigo de poliza (o 'exit'): ");
            String codigoPoliza = sc.nextLine();

            if (codigoPoliza.equalsIgnoreCase("exit")) {
                return daños;
            }

            System.out.println("Valor: ");
            int valor = sc.nextInt();
            Dano daño = new Dano();
            daño.setPoliza(this.obtenerPoliza(codigoPoliza));
            daño.setValor(valor);
            daños.add(daño);
        }
        return daños;
    }


    private Poliza obtenerPoliza(String code) {
        return this.data.findPolizaByCode(code);
    }
}
