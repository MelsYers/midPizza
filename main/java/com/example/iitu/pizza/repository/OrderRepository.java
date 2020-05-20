package com.example.iitu.pizza.repository;

import com.example.iitu.pizza.entity.Order;
import com.example.iitu.pizza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUsers_Username(String username);
    List<Order> findAllByUsers(User user);

}
