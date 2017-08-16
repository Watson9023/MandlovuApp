package com.watson.mandlovutakeaways.factories.pizza;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.pizza.PizzaInterface;
import com.watson.mandlovutakeaways.domain.pizza.impl.ChickenPizzaInterfaceImpl;
import com.watson.mandlovutakeaways.domain.pizza.impl.SteakPizzaInterfaceImpl;

public class PizzaBuilder
{
    public PizzaInterface prepareSteakPizza()
    {
        PizzaInterface steakPizzaObject = new SteakPizzaInterfaceImpl();
        return steakPizzaObject;
    }

    public PizzaInterface prepareChickenPizza()
    {
        PizzaInterface chickenPizzaObject = new ChickenPizzaInterfaceImpl();
        return chickenPizzaObject;
    }
}
