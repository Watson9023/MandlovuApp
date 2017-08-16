package com.watson.mandlovutakeaways.factories.gatsby;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;
import com.watson.mandlovutakeaways.domain.gatsby.impl.ChickenGatsbyInterfaceImpl;
import com.watson.mandlovutakeaways.domain.gatsby.impl.FullHouseGatsbyInterfaceImpl;
import com.watson.mandlovutakeaways.domain.gatsby.impl.SteakGatsbyInterfaceImpl;

public class SingleGatsby
{
    private static GatsbyInterface steakGatsbyObject = new SteakGatsbyInterfaceImpl();
    private static GatsbyInterface chickenGatsbyObject = new ChickenGatsbyInterfaceImpl();
    private static GatsbyInterface fullhouseGatsbyObject = new FullHouseGatsbyInterfaceImpl();

    private SingleGatsby()
    {}

    public static GatsbyInterface getGatsby(String gatsby)
    {
        if(gatsby == null)
        {
            return null;
        }
        if(gatsby.equalsIgnoreCase("Steak Gatsby"))
        {
            return steakGatsbyObject;
        }
        else if(gatsby.equalsIgnoreCase("Chicken Gatsby"))
        {
            return chickenGatsbyObject;
        }
        else if(gatsby.equalsIgnoreCase("Fullhouse Gatsby"))
        {
            return fullhouseGatsbyObject;
        }
        return null;
    }
}
