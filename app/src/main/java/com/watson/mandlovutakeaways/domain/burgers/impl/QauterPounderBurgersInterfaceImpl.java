package com.watson.mandlovutakeaways.domain.burgers.impl;
 
/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.burgers.BurgersInterface;

public class QauterPounderBurgersInterfaceImpl implements BurgersInterface
{

    private final String BURGERTYPE = "Quarterpounder Burger";
    private final double BURGERPRICE = 42.00;

    @Override
    public void setBurger(String type) {
        type = BURGERTYPE;
    }

    @Override
    public void setPrice(double price) {
        price = BURGERPRICE;
    }

    @Override
    public String getBurgerType() {
        return BURGERTYPE;
    }

    @Override
    public double getBurgerPrice() {
        return BURGERPRICE;
    }
}
