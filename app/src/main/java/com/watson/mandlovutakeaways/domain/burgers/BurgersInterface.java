package com.watson.mandlovutakeaways.domain.burgers;

/**
 * Created by Long on 8/14/2017.
 */


public interface BurgersInterface
{
    void setBurger(String type);
    void setPrice(double price);
    String getBurgerType();
    double getBurgerPrice();
}
