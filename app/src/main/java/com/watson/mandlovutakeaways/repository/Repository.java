package com.watson.mandlovutakeaways.repository;


/**
 * Created by Long on 8/14/2017.
 */

import java.util.Set;

public interface Repository <E,ID>
{
    E findByType(ID type);
    E save(E entity, ID type);
    E update(E entity, ID type);
    E delete(E entity, ID type);
    Set<E> findAll();
    int deleteAll();
}
