package com.watson.mandlovutakeaways.domain;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.beverages.BeveragesInterface;
import com.watson.mandlovutakeaways.domain.burgers.BurgersInterface;
import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;
import com.watson.mandlovutakeaways.domain.pizza.PizzaInterface;
import com.watson.mandlovutakeaways.factories.beverages.BeverageFactory;
import com.watson.mandlovutakeaways.factories.burgers.BurgerFactory;
import com.watson.mandlovutakeaways.factories.gatsby.SingleGatsby;
import com.watson.mandlovutakeaways.factories.pizza.PizzaBuilder;

import java.util.ArrayList;
import java.util.List;

public class Orders
{
    private BurgerFactory burgerFactory = new BurgerFactory();
    private PizzaBuilder pizzaBuilder = new PizzaBuilder();
    private float total = 0;
    List<String> orders = new ArrayList<>();

    public void gatsbyOrders(String item)
    {
        if(item.equalsIgnoreCase("STEAK GATSBY"))
        {
            GatsbyInterface steakGatsby = SingleGatsby.getGatsby(item);
            orders.add(steakGatsby.getGatsbyType());
            total += steakGatsby.getGatsbyPrice();
        }
        else if(item.equalsIgnoreCase("CHICKEN GATSBY"))
        {
            GatsbyInterface ChickenGatsby = SingleGatsby.getGatsby(item);
            orders.add(ChickenGatsby.getGatsbyType());
            total += ChickenGatsby.getGatsbyPrice();
        }
        else if(item.equalsIgnoreCase("FULLHOUSE GATSBY"))
        {
            GatsbyInterface fullhouseGatsby = SingleGatsby.getGatsby(item);
            orders.add(fullhouseGatsby.getGatsbyType());
            total += fullhouseGatsby.getGatsbyPrice();
        }
    }

    public void burgerOrders(String item)
    {
        if(item.equalsIgnoreCase("BEEF BURGER"))
        {
            BurgersInterface beef = burgerFactory.getBurger(item);
            orders.add(beef.getBurgerType());
            total += beef.getBurgerPrice();
        }
        else if(item.equalsIgnoreCase("CHICKEN BURGER"))
        {
            BurgersInterface chicken = burgerFactory.getBurger(item);
            orders.add(chicken.getBurgerType());
            total += chicken.getBurgerPrice();
        }
        else if(item.equalsIgnoreCase("HALFPOUNDER BURGER"))
        {
            BurgersInterface halfpounder = burgerFactory.getBurger(item);
            orders.add(halfpounder.getBurgerType());
            total += halfpounder.getBurgerPrice();
        }
        else if(item.equalsIgnoreCase("QUARTERPOUNDER BURGER"))
        {
            BurgersInterface quarterpounder = burgerFactory.getBurger(item);
            orders.add(quarterpounder.getBurgerType());
            total += quarterpounder.getBurgerPrice();
        }
        else if(item.equalsIgnoreCase("VEGGY BURGER"))
        {
            BurgersInterface veggy = burgerFactory.getBurger(item);
            orders.add(veggy.getBurgerType());
            total += veggy.getBurgerPrice();
        }
    }

    public void pizzaOrders(String item)
    {
        if(item.equalsIgnoreCase("STEAK PIZZA"))
        {
            PizzaInterface steak = pizzaBuilder.prepareSteakPizza();
            orders.add(steak.getPizzaType());
            total += steak.getPizzaPrice();
        }
        else if(item.equalsIgnoreCase("CHICKEN PIZZA"))
        {
            PizzaInterface chicken = pizzaBuilder.prepareChickenPizza();
            orders.add(chicken.getPizzaType());
            total += chicken.getPizzaPrice();
        }
    }

    public void coldDrinkOrders(String item)
    {
        if(item.equalsIgnoreCase("SPRITE"))
        {
            BeveragesInterface sprite = new BeverageFactory().getBeverage(item);
            orders.add(sprite.getBeverageType());
            total += sprite.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("COKE"))
        {
            BeveragesInterface coke = new BeverageFactory().getBeverage(item);
            orders.add(coke.getBeverageType());
            total += coke.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("FANTA"))
        {
            BeveragesInterface fanta = new BeverageFactory().getBeverage(item);
            orders.add(fanta.getBeverageType());
            total += fanta.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("PEPSI"))
        {
            BeveragesInterface pepsi = new BeverageFactory().getBeverage(item);
            orders.add(pepsi.getBeverageType());
            total += pepsi.getBeveragePrice();
        }
    }

    public void hotDrinkOrders(String item)
    {
        if(item.equalsIgnoreCase("TEA"))
        {
            BeveragesInterface tea = new BeverageFactory().getBeverage(item);
            orders.add(tea.getBeverageType());
            total += tea.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("COFFEE"))
        {
            BeveragesInterface coffee = new BeverageFactory().getBeverage(item);
            orders.add(coffee.getBeverageType());
            total += coffee.getBeveragePrice();
        }
    }

    public void milkshakeOrders(String item)
    {
        if(item.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
        {
            BeveragesInterface strawberry = new BeverageFactory().getBeverage(item);
            orders.add(strawberry.getBeverageType());
            total += strawberry.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
        {
            BeveragesInterface chocolate = new BeverageFactory().getBeverage(item);
            orders.add(chocolate.getBeverageType());
            total += chocolate.getBeveragePrice();
        }
        else if(item.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
        {
            BeveragesInterface bubblegum = new BeverageFactory().getBeverage(item);
            orders.add(bubblegum.getBeverageType());
            total += bubblegum.getBeveragePrice();
        }
    }
    public double getTotal()
    {
        return total;
    }

    public List<String> getOrders()
    {
        return orders;
    }
}
