package com.babel.liquidaciones;

import com.babel.liquidaciones.configuration.AppConfig;
import com.babel.liquidaciones.view.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        Menu menu = context.getBean(Menu.class);
        menu.startSession();
    }
}
