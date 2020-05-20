package com.example.iitu.pizza.controller;

import com.example.iitu.pizza.entity.Order;
import com.example.iitu.pizza.entity.Pizza;
import com.example.iitu.pizza.entity.User;
import com.example.iitu.pizza.exception.OrderNotFoundException;
import com.example.iitu.pizza.repository.OrderRepository;
import com.example.iitu.pizza.repository.PizzaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
@Api(value = "Order Controller class", description = "This class allows to interact with Order object")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("")
    public String getAllOrders(Map<String, Object> model, @AuthenticationPrincipal User user){
        //return orderRepository.findAll();
        List<Order> orders = orderRepository.findAllByUsers(user);
        model.put("orders", orders);

        return "order";
    }

    @PostMapping("/create")
    public String addOrder(Order order, @AuthenticationPrincipal User user, String[] pizzas){
        //@RequestParam(value = "param[]") String[] paramValues
        String all="";
        all+=pizzas.toString();
        System.out.println(all);

        order.setTime(new Date());
        order.setUsers(user);

        ArrayList<Pizza> pizzasOrder = new ArrayList<>();

        for (String pizza : pizzas) {
            Pizza p = pizzaRepository.findById(Long.parseLong(pizza)).get();
            pizzasOrder.add(p);
        }

        order.setPizzas(pizzasOrder);
        int allPrice = 0;
        for(Pizza price:pizzasOrder){
            allPrice+=price.getPrice();
        }
        order.setOrderPrice(allPrice);

        orderRepository.saveAndFlush(order);
        return "redirect:/";

    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) //throws OrderNotFoundException
    {
        Order order =  orderRepository.findById(id).get();
        //if(order==null)
           // throw new OrderNotFoundException();
        return order;
    }

    @GetMapping("/{username}")
    public List<Order> getAllUsersOrders(@PathVariable String username){
        return orderRepository.findAllByUsers_Username(username);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

}
