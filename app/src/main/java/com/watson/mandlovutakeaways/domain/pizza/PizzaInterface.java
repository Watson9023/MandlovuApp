package com.watson.mandlovutakeaways.domain.pizza;

/**
 * Created by Long on 8/14/2017.
 */


public interface PizzaInterface
{
    void setType(String type);
    void setPrice(double price);
    String getPizzaType();
    double getPizzaPrice();
}
