package com.iitu.pizzeria.Controller;

import com.iitu.pizzeria.Service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class Controller {

    private PizzaService pizzaService;

    @Autowired
    public Controller(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    public void menu(){

        boolean cycle = true;
        while (cycle){
            System.out.println("PIZZALAND");
            System.out.println("1)Show all pizzas\n2)Show pizza by ID\n3)Make pizza\n4)Update price\n5)Delete pizza");
            System.out.println("0)EXIT");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    pizzaService.showAllPizzas();
                    break;
                case 2:
                    System.out.println("Enter id of pizza");
                    int id = sc.nextInt();
                    pizzaService.getPizzaBiId(id);
                    break;
                case 3:
                    System.out.println("Enter name of new pizza");
                    String name = sc.next();
                    System.out.println("Enter price of new pizza");
                    int price = sc.nextInt();
                    pizzaService.addPizza(name, price);
                    break;
                case 4:
                    System.out.println("Enter id of pizza");
                    int updateId = sc.nextInt();
                    System.out.println("Enter new price of pizza");
                    int updatePrice = sc.nextInt();
                    pizzaService.updatePrice(updateId, updatePrice);
                    break;
                case 5:
                    System.out.println("Enter id of pizza");
                    int delPizza = sc.nextInt();
                    pizzaService.deletePizza(delPizza);
                    break;
                case 0:
                    cycle = false;
                    break;
                default:
                    System.out.println("Invalid value");
            }
        }


    }

}
