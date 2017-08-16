package com.watson.mandlovutakeaways.domain.beverages.impl;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.beverages.BeveragesInterface;

import java.io.Serializable;

public class MilkshakeBeveragesInterfaceImpl implements BeveragesInterface, Serializable
{
    private String type;
    private double price;

    @Override
    public void setBeverage(String type) {
        this.type = type;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getBeverageType() {
        return type;
    }

    @Override
    public double getBeveragePrice() {
        return price;
    }
}
