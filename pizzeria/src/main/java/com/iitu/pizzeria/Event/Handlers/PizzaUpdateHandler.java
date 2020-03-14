package com.iitu.pizzeria.Event.Handlers;

import com.iitu.pizzeria.Event.PizzaUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PizzaUpdateHandler implements ApplicationListener<PizzaUpdateEvent> {

    @Override
    public void onApplicationEvent(PizzaUpdateEvent pizzaUpdateEvent) {
        System.out.println("PizzaUpdateHandler.onApplicationEvent");
        System.out.println("Updated pizza: "+pizzaUpdateEvent.getPizza().getName()+"" +
                "\nNew Price: "+pizzaUpdateEvent.getPizza().getPrice());
    }
}
