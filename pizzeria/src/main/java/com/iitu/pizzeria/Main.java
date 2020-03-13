package com.iitu.pizzeria;

import com.iitu.pizzeria.Controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sqlite.SQLiteConnection;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Controller controller = context.getBean("controller", Controller.class);
        controller.menu();

    }
}
