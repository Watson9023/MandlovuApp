package com.watson.mandlovutakeaways.beverges;

import android.test.AndroidTestCase;

import com.watson.mandlovutakeaways.domain.beverages.BeveragesInterface;
import com.watson.mandlovutakeaways.factories.beverages.BeverageFactory;
import com.watson.mandlovutakeaways.repository.beverages.BeveragesRepository;
import com.watson.mandlovutakeaways.repository.beverages.impl.BeveragesRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;


/**
 * Created by Long on 8/14/2017.
 */
public class BeveragesRepositoryTest extends AndroidTestCase
{
    public void testCreateAddUpdateDelete() throws Exception
    {
        final String TAG="BEVERAGES TEST";
        BeveragesRepository repo = new BeveragesRepositoryImpl(this.getContext());
        String type;

        //CREATE
        BeverageFactory factory = new BeverageFactory();
        BeveragesInterface tea = factory.getBeverage("TEA");
        BeveragesInterface teaInserted = repo.save(tea,"Tea");
        type = teaInserted.getBeverageType();
        assertNotNull(TAG+" CREATE ",teaInserted);

        //READ ALL
        Set<BeveragesInterface> beverages = repo.findAll();
        Assert.assertTrue(TAG+ " READ ALL", beverages.size() >0);

        //READ ENTITY
        BeveragesInterface entity = repo.findByType(type);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        BeveragesInterface updateEntity = factory.getBeverage("TEA");
        updateEntity.setBeverage("COFFEE");
        repo.update(updateEntity,"COFFEE");
        BeveragesInterface newEntity = repo.findByType("COFFEE");
        Assert.assertEquals(TAG+" UPDATE ENTITY","COFFEE",newEntity.getBeverageType());

        //DELETE ENTITY
        repo.delete(updateEntity,"COFFEE");
        BeveragesInterface deletedEntity = repo.findByType("COFFEE");
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}