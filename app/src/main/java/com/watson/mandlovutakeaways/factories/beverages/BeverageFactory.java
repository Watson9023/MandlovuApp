package com.watson.mandlovutakeaways.factories.beverages;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.beverages.BeveragesInterface;
import com.watson.mandlovutakeaways.domain.beverages.impl.ColdBeveragesInterfaceImpl;
import com.watson.mandlovutakeaways.domain.beverages.impl.HotBeveragesInterfaceImpl;
import com.watson.mandlovutakeaways.domain.beverages.impl.MilkshakeBeveragesInterfaceImpl;

public class BeverageFactory
{
    public BeveragesInterface getBeverage(String type)
    {
        if(type == null)
        {
            return null;
        }
        else if(type.equalsIgnoreCase("TEA"))
        {
            BeveragesInterface tea = new HotBeveragesInterfaceImpl();
            tea.setPrice(12.50);
            tea.setBeverage("Tea");
            return tea;
        }
        else if(type.equalsIgnoreCase("COFFEE"))
        {
            BeveragesInterface coffee = new HotBeveragesInterfaceImpl();
            coffee.setPrice(12.50);
            coffee.setBeverage("Coffee");
            return coffee;
        }
        else if(type.equalsIgnoreCase("SPRITE"))
        {
            BeveragesInterface sprite = new ColdBeveragesInterfaceImpl();
            sprite.setPrice(10.00);
            sprite.setBeverage("Sprite");
            return sprite;
        }
        else if(type.equalsIgnoreCase("FANTA"))
        {
            BeveragesInterface fanta = new ColdBeveragesInterfaceImpl();
            fanta.setPrice(10.00);
            fanta.setBeverage("Fanta");
            return fanta;
        }
        else if(type.equalsIgnoreCase("COKE"))
        {
            BeveragesInterface coke = new ColdBeveragesInterfaceImpl();
            coke.setPrice(10.00);
            coke.setBeverage("Coke");
            return coke;
        }
        else if(type.equalsIgnoreCase("PEPSI"))
        {
            BeveragesInterface pepsi= new ColdBeveragesInterfaceImpl();
            pepsi.setPrice(10.00);
            pepsi.setBeverage("Pepsi");
            return pepsi;
        }
        else if(type.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
        {
            BeveragesInterface strawberry = new MilkshakeBeveragesInterfaceImpl();
            strawberry.setBeverage("Strawberry Milkshake");
            strawberry.setPrice(20.00);
            return strawberry;
        }
        else if(type.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
        {
            BeveragesInterface chocolate = new MilkshakeBeveragesInterfaceImpl();
            chocolate.setBeverage("Chocolate Milkshake");
            chocolate.setPrice(20.00);
            return chocolate;
        }
        else if(type.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
        {
            BeveragesInterface bubblegum = new MilkshakeBeveragesInterfaceImpl();
            bubblegum.setBeverage("Bubblegum Milkshake");
            bubblegum.setPrice(20.00);
            return bubblegum;
        }
        return null;
    }
}
