package com.watson.mandlovutakeaways.domain.pizza.impl;
 
/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.pizza.PizzaInterface;

public class ChickenPizzaInterfaceImpl implements PizzaInterface {

    private final String PIZZATYPE ="Chicken Pizza";
    private final double PIZZAPRICE = 76.00;

    @Override
    public void setType(String type) {
        type = PIZZATYPE;
    }

    @Override
    public void setPrice(double price) {
        price = PIZZAPRICE;
    }

    @Override
    public String getPizzaType() {
        return PIZZATYPE;
    }

    @Override
    public double getPizzaPrice() {
        return PIZZAPRICE;
    }
}
