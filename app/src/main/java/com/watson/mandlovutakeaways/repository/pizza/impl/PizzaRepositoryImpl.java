package com.watson.mandlovutakeaways.repository.pizza.impl;


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
import com.watson.mandlovutakeaways.domain.pizza.PizzaInterface;
import com.watson.mandlovutakeaways.factories.pizza.PizzaBuilder;
import com.watson.mandlovutakeaways.repository.pizza.PizzaRepository;

import java.util.HashSet;
import java.util.Set;

public class PizzaRepositoryImpl extends SQLiteOpenHelper implements PizzaRepository {

    private SQLiteDatabase db;
    private PizzaBuilder builder = new PizzaBuilder();
    public static final String TABLE_NAME = "pizzas";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PRICE = "price";

    //Database Creation Statement

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + " ("
            + COLUMN_TYPE + "TEXT NOT NULL, "
            + COLUMN_PRICE + "TEXT NOT NULL );";

    public PizzaRepositoryImpl(Context context)
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
    public PizzaInterface findByType(String type) {
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
            if(type.equalsIgnoreCase("STEAK PIZZA"))
            {
                final PizzaInterface steak = builder.prepareSteakPizza();
                steak.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                steak.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return steak;
            }
            else if(type.equalsIgnoreCase("CHICKEN PIZZA"))
            {
                final PizzaInterface chicken = builder.prepareSteakPizza();
                chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                chicken.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                return chicken;
            }
        }
        return null;
    }

    @Override
    public PizzaInterface save(PizzaInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("CHICKEN PIZZA"))
        {
            entity = builder.prepareChickenPizza();
            values.put(COLUMN_TYPE,entity.getPizzaType());
            values.put(COLUMN_PRICE,entity.getPizzaPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;

        }
        else if(type.equalsIgnoreCase("STEAK PIZZA"))
        {
            entity = builder.prepareSteakPizza();
            values.put(COLUMN_TYPE,entity.getPizzaType());
            values.put(COLUMN_PRICE,entity.getPizzaPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        return null;
    }

    @Override
    public PizzaInterface update(PizzaInterface entity, String type)
    {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("CHICKEN PIZZA"))
        {
            entity = builder.prepareChickenPizza();
            values.put(COLUMN_TYPE,entity.getPizzaType());
            values.put(COLUMN_PRICE,entity.getPizzaPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getPizzaType())}
            );
            return entity;

        }
        else if(type.equalsIgnoreCase("STEAK PIZZA"))
        {
            entity = builder.prepareSteakPizza();
            values.put(COLUMN_TYPE,entity.getPizzaType());
            values.put(COLUMN_PRICE,entity.getPizzaPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getPizzaType())}
            );
            return entity;
        }
        return null;
    }

    @Override
    public PizzaInterface delete(PizzaInterface entity, String type) {
        open();
        if(type.equalsIgnoreCase("STEAK PIZZA"))
        {
            entity = builder.prepareSteakPizza();
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getPizzaType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("CHICKEN PIZZA"))
        {
            entity = builder.prepareChickenPizza();
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getPizzaType())}
            );
            return entity;
        }
        return null;
    }

    @Override
    public Set<PizzaInterface> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<PizzaInterface> pizzas = new HashSet<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        PizzaInterface steak = builder.prepareSteakPizza();
        PizzaInterface chicken = builder.prepareChickenPizza();
        open();
        if(cursor.moveToFirst())
        {
            do{
                if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("STEAK PIZZA"))
                {
                    steak.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    steak.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    pizzas.add(steak);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("CHICKEN PIZZA"))
                {
                    chicken.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    pizzas.add(chicken);
                }

            }while (cursor.moveToNext());
        }
        return pizzas;
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
