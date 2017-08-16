package com.watson.mandlovutakeaways.gatsby;

import android.test.AndroidTestCase;
import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;
import com.watson.mandlovutakeaways.factories.gatsby.SingleGatsby;
import com.watson.mandlovutakeaways.repository.gatsby.GatsbyRepository;
import com.watson.mandlovutakeaways.repository.gatsby.impl.GatsbyRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;


/**
 * Created by Long on 8/14/2017.
 */
public class GatsbyRepositoryTest extends AndroidTestCase
{
    public void testCreateAddUpdateDelete() throws Exception {

        final String TAG="GATSBYS TEST";
        GatsbyRepository repo = new GatsbyRepositoryImpl(this.getContext());
        String type;

        //CREATE
        GatsbyInterface steak = SingleGatsby.getGatsby("Steak Gatsby");
        GatsbyInterface steakInserted = repo.save(steak,"STEAK GATSBY");
        type = steakInserted.getGatsbyType();
        assertNotNull(TAG+" CREATE ",steakInserted);

        //READ ALL
        Set<GatsbyInterface> gatsbys = repo.findAll();
        Assert.assertTrue(TAG+ " READ ALL", gatsbys.size() >0);

        //READ ENTITY
        GatsbyInterface entity = repo.findByType(type);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        GatsbyInterface updateEntity = SingleGatsby.getGatsby("Chicken Gatsby");
        updateEntity.setType("CHICKEN GATSBY");
        repo.update(updateEntity,"CHICKEN GATSBY");
        GatsbyInterface newEntity = repo.findByType("CHICKEN GATSBY");
        Assert.assertEquals(TAG+" UPDATE ENTITY","CHICKEN GATSBY",newEntity.getGatsbyType());

        //DELETE ENTITY
        repo.delete(updateEntity,"CHICKEN BURGER");
        GatsbyInterface deletedEntity = repo.findByType("CHICKEN BURGER");
        Assert.assertNull(TAG+" DELETE",deletedEntity);
    }
}