package com.watson.mandlovutakeaways.domain.gatsby.impl;/*

/**
 * Created by Long on 8/14/2017.
 */


import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;

public class FullHouseGatsbyInterfaceImpl implements GatsbyInterface
{

    private final String GATSBYTYPE ="Full House Gatsby";
    private final double GATSBYPRICE = 120.00;

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
