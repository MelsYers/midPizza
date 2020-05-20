package com.example.iitu.pizza.controller;


import com.example.iitu.pizza.entity.Pizza;
import com.example.iitu.pizza.exception.PizzaNotFoundException;
import com.example.iitu.pizza.repository.PizzaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pizza")
@Api(value = "Pizza Controller class", description = "This class allows to interact with Pizza object")
public class PizzaController {


    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("")
    public String getAllPizzas(Map<String, Object> model){
        //return pizzaRepository.findAll();
        List<Pizza> pizzas = pizzaRepository.findAll();

        model.put("pizzas", pizzas);
        return "pizza";
    }

    @PostMapping("/create")
    public Pizza addPizza(@RequestBody Pizza pizza){
        return pizzaRepository.saveAndFlush(pizza);
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) throws PizzaNotFoundException {
        Pizza pizza = pizzaRepository.findById(id).get();
        if (pizza == null)
            throw new PizzaNotFoundException();
        return pizza;
    }

    @PutMapping("/{id}")
    public void updatePizza(@PathVariable Long id, @RequestBody Pizza pizza){
        Pizza pizza1 = pizzaRepository.findById(id).orElse(null);

        if (pizza1 != null) {
            pizza1.setTitle(pizza.getTitle());
            pizza1.setPrice(pizza.getPrice());
            pizza1.setDiameter(pizza.getDiameter());

            pizzaRepository.saveAndFlush(pizza1);
        }

    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaRepository.deleteById(id);
    }


}
