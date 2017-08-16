package com.watson.mandlovutakeaways.repository.burgers.impl;
 
/**
 * Created by Long on 8/14/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.watson.mandlovutakeaways.conf.databases.DBConstants;
import com.watson.mandlovutakeaways.domain.burgers.BurgersInterface;
import com.watson.mandlovutakeaways.factories.burgers.BurgerFactory;
import com.watson.mandlovutakeaways.repository.burgers.BurgersRepository;

import java.util.HashSet;
import java.util.Set;

public class BurgersRepositoryImpl extends SQLiteOpenHelper implements BurgersRepository
{
    private BurgerFactory burgerFactory = new BurgerFactory();
    private SQLiteDatabase db;
    public static final String TABLE_NAME = "burgers";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PRICE = "price";

    //Database Creation Statement

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + " ("
            + COLUMN_TYPE + "TEXT NOT NULL, "
            + COLUMN_PRICE + "TEXT NOT NULL );";

    public BurgersRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException
    {
        db = this.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.close();
    }


    @Override
    public BurgersInterface findByType(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_TYPE,
                        COLUMN_PRICE},
                COLUMN_TYPE + " =? ",
                new String[]{String.valueOf(type)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
        {
            if(type.equalsIgnoreCase("BEEF BURGER"))
            {
                final BurgersInterface beef = burgerFactory.getBurger(type);
                beef.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                beef.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return beef;
            }
            if(type.equalsIgnoreCase("CHICKEN BURGER"))
            {
                final BurgersInterface chicken = burgerFactory.getBurger(type);
                chicken.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return chicken;
            }
            if(type.equalsIgnoreCase("VEGGY BURGER"))
            {
                final BurgersInterface veggy = burgerFactory.getBurger(type);
                veggy.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                veggy.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return veggy;
            }
            if(type.equalsIgnoreCase("HALFPOUNDER BURGER"))
            {
                final BurgersInterface halfpounder = burgerFactory.getBurger(type);
                halfpounder.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                halfpounder.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return halfpounder;
            }
            if(type.equalsIgnoreCase("QUARTERPOUNDER BURGER"))
            {
                final BurgersInterface quarterpounder = burgerFactory.getBurger(type);
                quarterpounder.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                quarterpounder.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return quarterpounder;
            }
        }
       return null;
    }

    @Override
    public BurgersInterface save(BurgersInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("Beef Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        else if(type.equalsIgnoreCase("Chicken Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        else if(type.equalsIgnoreCase("Veggy Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        else if(type.equalsIgnoreCase("Halfpounder Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        else if(type.equalsIgnoreCase("Quarterpounder Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        return null;
    }

    @Override
    public BurgersInterface update(BurgersInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("Beef Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("Chicken Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("Veggy Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("Halfpounder Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("Quarterpounder Burger"))
        {
            entity = burgerFactory.getBurger(type);
            values.put(COLUMN_TYPE,entity.getBurgerType());
            values.put(COLUMN_PRICE,entity.getBurgerPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
            return entity;
        }
        return null;
    }

    @Override
    public BurgersInterface delete(BurgersInterface entity, String type) {
        open();
        if(type.equalsIgnoreCase(type))
        {
            entity = burgerFactory.getBurger(type);
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getBurgerType())}
            );
        }
        return entity;
    }

    @Override
    public Set<BurgersInterface> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<BurgersInterface> burgers = new HashSet<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        BurgersInterface beef = new BurgerFactory().getBurger("Beef Burger");
        BurgersInterface chicken = new BurgerFactory().getBurger("Chicken Burger");
        BurgersInterface veggy = new BurgerFactory().getBurger("Veggy Burger");
        BurgersInterface halfpounder = new BurgerFactory().getBurger("Halfpounder Burger");
        BurgersInterface quarterpounder = new BurgerFactory().getBurger("Quarterpounder Burger");
        open();

        if(cursor.moveToFirst())
        {
            do{
                if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("BEEF BURGER"))
                {
                    beef.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    beef.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    burgers.add(beef);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("CHICKEN BURGER"))
                {
                    chicken.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    burgers.add(chicken);
                }
                else  if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("VEGGY BURGER"))
                {
                    veggy.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    veggy.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    burgers.add(veggy);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("HALFPOUNDER BURGER"))
                {
                    halfpounder.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    halfpounder.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    burgers.add(halfpounder);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("QUARTERPOUNDER BURGER"))
                {
                    quarterpounder.setBurger(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    quarterpounder.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    burgers.add(quarterpounder);
                }
            }while (cursor.moveToNext());
        }
        return burgers;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
         + newVersion + " , which will destroy all old data "
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
