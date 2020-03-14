package com.iitu.pizzeria.Event;

import com.iitu.pizzeria.Entity.Pizza;
import org.springframework.context.ApplicationEvent;

public class PizzaCreateEvent extends ApplicationEvent {


    private Pizza pizza;

    public PizzaCreateEvent(Object source, Pizza pizza) {
        super(source);
        this.pizza = pizza;
    }

    public Pizza getPizza(){return pizza;}

}
