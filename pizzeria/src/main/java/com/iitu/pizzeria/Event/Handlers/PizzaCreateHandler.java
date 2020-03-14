package com.iitu.pizzeria.Event.Handlers;

import com.iitu.pizzeria.Event.PizzaCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PizzaCreateHandler implements ApplicationListener<PizzaCreateEvent> {

    @Override
    public void onApplicationEvent(PizzaCreateEvent pizzaCreateEvent) {
        System.out.println("PizzaCreateHandler.onApplicationEvent");
        System.out.println("New Pizza was created: "+pizzaCreateEvent.getPizza().getName());
    }

}
