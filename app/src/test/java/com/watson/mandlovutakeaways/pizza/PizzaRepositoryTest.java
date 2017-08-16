package com.watson.mandlovutakeaways.pizza;

import android.test.AndroidTestCase;

import com.watson.mandlovutakeaways.domain.pizza.PizzaInterface;
import com.watson.mandlovutakeaways.factories.pizza.PizzaBuilder;
import com.watson.mandlovutakeaways.repository.pizza.PizzaRepository;
import com.watson.mandlovutakeaways.repository.pizza.impl.PizzaRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;


/**
 * Created by Long on 8/14/2017.
 */

public class PizzaRepositoryTest extends AndroidTestCase
{

    public void testCreateAddUpdateDelete() throws Exception {

        final String TAG="PIZZA TEST";
        PizzaRepository repo = new PizzaRepositoryImpl(this.getContext());
        String type;
        PizzaBuilder builder = new PizzaBuilder();

        //CREATE
        PizzaInterface steak = builder.prepareSteakPizza();
        PizzaInterface steakInserted = repo.save(steak,"STEAK PIZZA");
        type = steakInserted.getPizzaType();
        assertNotNull(TAG+" CREATE ",steakInserted);

        //READ ALL
        Set<PizzaInterface> pizzas = repo.findAll();
        Assert.assertTrue(TAG+ " READ ALL", pizzas.size() >0);

        //READ ENTITY
        PizzaInterface entity = repo.findByType(type);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        PizzaInterface updateEntity = builder.prepareChickenPizza();
        updateEntity.setType("CHICKEN PIZZA");
        repo.update(updateEntity,"CHICKEN PIZZA");
        PizzaInterface newEntity = repo.findByType("CHICKEN PIZZA");
        Assert.assertEquals(TAG+" UPDATE ENTITY","CHICKEN PIZZA",newEntity.getPizzaType());

        //DELETE ENTITY
        repo.delete(updateEntity,"CHICKEN Pizza");
        PizzaInterface deletedEntity = repo.findByType("CHICKEN PIZZA");
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}