package com.iitu.pizzeria.Dao;

import com.iitu.pizzeria.Database;
import com.iitu.pizzeria.Entity.Pizza;
import com.iitu.pizzeria.Event.Handlers.PizzaCreateHandler;
import com.iitu.pizzeria.Event.PizzaCreateEvent;
import com.iitu.pizzeria.Event.PizzaDeleteEvent;
import com.iitu.pizzeria.Event.PizzaUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String ADD_PIZZA = "INSERT INTO pizzas(name, price) VALUES(?,?)";
    private final String GET_ALL_PIZZAS = "SELECT * FROM pizzas";
    private final String GET_PIZZA_BY_ID = "SELECT * FROM pizzas WHERE id = ?";
    private final String UPDATE_PIZZAS_PRICE = "UPDATE pizzas SET price = ? WHERE id = ?";
    private final String DELETE_PIZZA = "DELETE FROM pizzas WHERE id = ?";

    private final String GET_LAST_CREATED_PIZZA = "SELECT * FROM pizzas ORDER BY id DESC LIMIT 1";

    @Autowired
    public PizzaDao(Database database) {
        this.jdbcTemplate = new JdbcTemplate(database.getDataSource());
    }

    public void create(String name, int price){
        jdbcTemplate.update(ADD_PIZZA, name, price);
        this.eventPublisher.publishEvent(new PizzaCreateEvent(this, getLastPizza()));
    }

    public List<Pizza> getAll(){
        return jdbcTemplate.query(GET_ALL_PIZZAS, new PizzaMapper());
    }

    public Pizza getPizzaById(int id){
        return jdbcTemplate.queryForObject(GET_PIZZA_BY_ID, new Object[]{id}, new PizzaMapper());
    }

    public void updatePrice(int id, int price){
        jdbcTemplate.update(UPDATE_PIZZAS_PRICE, price, id);
        this.eventPublisher.publishEvent(new PizzaUpdateEvent(this, getPizzaById(id)));
    }

    public void deletePizza(int id){
        this.eventPublisher.publishEvent(new PizzaDeleteEvent(this, getPizzaById(id)));
        jdbcTemplate.update(DELETE_PIZZA, id);
    }

    public Pizza getLastPizza(){
        return jdbcTemplate.queryForObject(GET_LAST_CREATED_PIZZA, new PizzaMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
