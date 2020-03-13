package com.iitu.pizzeria.Service;

import com.iitu.pizzeria.Dao.PizzaDao;
import com.iitu.pizzeria.Entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaService {

    private PizzaDao pizzaDao;

    @Autowired
    public PizzaService(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public void addPizza(String name, int price){
        pizzaDao.create(name, price);
    }

    public void showAllPizzas(){
        List<Pizza> pizzaList = pizzaDao.getAll();
        System.out.println("All Pizzas:");
        for (Pizza pizza:pizzaList) {
            System.out.println(pizza.toString());
        }
    }

    public void getPizzaBiId(int id){
        Pizza pizza = pizzaDao.getPizzaById(id);
        System.out.println(pizza.toString());
    }

    public void updatePrice(int id, int price){
        pizzaDao.updatePrice(id, price);
    }

    public void deletePizza(int id){
        pizzaDao.deletePizza(id);
    }
}
