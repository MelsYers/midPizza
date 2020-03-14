package com.iitu.pizzeria.Event.Handlers;

import com.iitu.pizzeria.Event.PizzaDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeleteHandler implements ApplicationListener<PizzaDeleteEvent> {

    @Override
    public void onApplicationEvent(PizzaDeleteEvent pizzaDeleteEvent) {
        System.out.println("PizzaDeleteHandler.onApplicationEvent");
        System.out.println("Deleted pizza: "+pizzaDeleteEvent.getPizza().getName());
    }
}
