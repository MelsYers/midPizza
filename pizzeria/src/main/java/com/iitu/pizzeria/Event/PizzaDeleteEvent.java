package com.iitu.pizzeria.Event;

import com.iitu.pizzeria.Entity.Pizza;
import org.springframework.context.ApplicationEvent;

public class PizzaDeleteEvent extends ApplicationEvent {

    private Pizza pizza;
    public PizzaDeleteEvent(Object source, Pizza pizza) {
        super(source);
        this.pizza = pizza;
    }
    public Pizza getPizza(){return pizza;}
}
