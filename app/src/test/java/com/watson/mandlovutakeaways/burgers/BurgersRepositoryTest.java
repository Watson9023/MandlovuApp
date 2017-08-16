package com.watson.mandlovutakeaways.burgers;

import android.test.AndroidTestCase;
import com.watson.mandlovutakeaways.domain.burgers.BurgersInterface;
import com.watson.mandlovutakeaways.factories.burgers.BurgerFactory;
import com.watson.mandlovutakeaways.repository.burgers.BurgersRepository;
import com.watson.mandlovutakeaways.repository.burgers.impl.BurgersRepositoryImpl;
import junit.framework.Assert;
import java.util.Set;


/**
 * Created by Long on 8/14/2017.
 */
public class BurgersRepositoryTest extends AndroidTestCase
{
    public void testCreateAddUpdateDelete() throws Exception {
        final String TAG="BURGERS TEST";
        BurgersRepository repo = new BurgersRepositoryImpl(this.getContext());
        String type;

        //CREATE
        BurgerFactory factory = new BurgerFactory();
        BurgersInterface beef = factory.getBurger("BEEF BURGER");
        BurgersInterface beefInserted = repo.save(beef,"BEEF BURGER");
        type = beefInserted.getBurgerType();
        assertNotNull(TAG+" CREATE ",beefInserted);

        //READ ALL
        Set<BurgersInterface> burgers = repo.findAll();
        Assert.assertTrue(TAG+ " READ ALL", burgers.size() >0);

        //READ ENTITY
        BurgersInterface entity = repo.findByType(type);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        BurgersInterface updateEntity = factory.getBurger("BEEF BURGER");
        updateEntity.setBurger("CHICKEN BURGER");
        repo.update(updateEntity,"CHICKEN BURGER");
        BurgersInterface newEntity = repo.findByType("CHICKEN BURGER");
        Assert.assertEquals(TAG+" UPDATE ENTITY","CHICKEN BURGER",newEntity.getBurgerType());

        //DELETE ENTITY
        repo.delete(updateEntity,"CHICKEN BURGER");
        BurgersInterface deletedEntity = repo.findByType("CHICKEN BURGER");
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}