package com.iitu.pizzeria.Dao;

import com.iitu.pizzeria.Entity.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaMapper implements RowMapper<Pizza> {

    @Override
    public Pizza mapRow(ResultSet resultSet, int i) throws SQLException {
        Pizza pizza = new Pizza();
        pizza.setId(resultSet.getInt(1));
        pizza.setName(resultSet.getString(2));
        pizza.setPrice(resultSet.getInt(3));

        return pizza;
    }
}
