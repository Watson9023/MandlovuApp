package com.watson.mandlovutakeaways.factories.burgers;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.burgers.BurgersInterface;
import com.watson.mandlovutakeaways.domain.burgers.impl.BeefBurgersInterfaceImpl;
import com.watson.mandlovutakeaways.domain.burgers.impl.ChickenBurgersInterfaceImpl;
import com.watson.mandlovutakeaways.domain.burgers.impl.HalfPounderBurgersInterfaceImpl;
import com.watson.mandlovutakeaways.domain.burgers.impl.QauterPounderBurgersInterfaceImpl;
import com.watson.mandlovutakeaways.domain.burgers.impl.VegBurgersInterfaceImpl;

public class BurgerFactory
{
    public BurgersInterface getBurger(String burgerType)
    {
        if(burgerType == null)
        {
            return null;
        }
        if(burgerType.equalsIgnoreCase("Beef Burger"))
        {
            return new BeefBurgersInterfaceImpl();
        }
        else if(burgerType.equalsIgnoreCase("Chicken Burger"))
        {
            return new ChickenBurgersInterfaceImpl();
        }
        else if(burgerType.equalsIgnoreCase("Veggie Burger"))
        {
            return new VegBurgersInterfaceImpl();
        }
        else if(burgerType.equalsIgnoreCase("Quarterpounder Burger"))
        {
            return new QauterPounderBurgersInterfaceImpl();
        }
        else if(burgerType.equalsIgnoreCase("Halfpounder Burger"))
        {
            return new HalfPounderBurgersInterfaceImpl();
        }
        return  null;
    }
}
