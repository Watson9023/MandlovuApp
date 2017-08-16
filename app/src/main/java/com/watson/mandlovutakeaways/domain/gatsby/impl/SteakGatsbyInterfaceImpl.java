package com.watson.mandlovutakeaways.domain.gatsby.impl;/*
 
/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;

public class SteakGatsbyInterfaceImpl implements GatsbyInterface {
    private final String GATSBYTYPE ="Steak Gatsby";
    private final double GATSBYPRICE = 85.00;

    @Override
    public void setType(String type) {
        type = GATSBYTYPE;
    }

    @Override
    public void setPrice(double price) {
        price = GATSBYPRICE;
    }

    @Override
    public String getGatsbyType() {
        return GATSBYTYPE;
    }

    @Override
    public double getGatsbyPrice() {
        return GATSBYPRICE;
    }
}
