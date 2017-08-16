package com.watson.mandlovutakeaways.repository.beverages.impl;
 
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
import com.watson.mandlovutakeaways.domain.beverages.BeveragesInterface;
import com.watson.mandlovutakeaways.factories.beverages.BeverageFactory;
import com.watson.mandlovutakeaways.repository.beverages.BeveragesRepository;

import java.util.HashSet;
import java.util.Set;

public class BeveragesRepositoryImpl extends SQLiteOpenHelper implements BeveragesRepository
{
    private BeverageFactory beverageFactory = new BeverageFactory();
    private SQLiteDatabase db;
    public static final String TABLE_NAME = "beverages";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PRICE = "price";

    //Database Creation Statement

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + " ("
            + COLUMN_TYPE + "TEXT NOT NULL, "
            + COLUMN_PRICE + "TEXT NOT NULL );";

    public BeveragesRepositoryImpl(Context context)
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
    public BeveragesInterface findByType(String type) {
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
            if(type.equalsIgnoreCase("TEA"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("COFFEE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("SPRITE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("FANTA"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("PEPSI"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("COKE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
            else if(type.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
            {
                final BeveragesInterface entity = beverageFactory.getBeverage(type);
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                entity.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                return  entity;
            }
        }
        return null;
    }

    @Override
    public BeveragesInterface save(BeveragesInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("TEA"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("COFFEE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("SPRITE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("FANTA"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("PEPSI"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("COKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        else if(type.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.insertOrThrow(TABLE_NAME,null,values);
            return  entity;
        }
        return null;
    }

    @Override
    public BeveragesInterface update(BeveragesInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("TEA"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("COFFEE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("SPRITE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("FANTA"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("PEPSI"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("COKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        else if(type.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
        {
            entity = beverageFactory.getBeverage(type);
            values.put(COLUMN_TYPE,entity.getBeverageType());
            values.put(COLUMN_PRICE,entity.getBeveragePrice());
            db.update(TABLE_NAME,values,COLUMN_TYPE + " =? ", new String[]{String.valueOf(entity.getBeverageType())});
            return  entity;
        }
        return null;
    }

    @Override
    public BeveragesInterface delete(BeveragesInterface entity, String type) {
        open();
        if(type.equalsIgnoreCase(type))
        {
            entity =beverageFactory.getBeverage(type);
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getBeverageType())}
            );
        }
        return entity;
    }

    @Override
    public Set<BeveragesInterface> findAll()
    {
        BeverageFactory factory = new BeverageFactory();
        SQLiteDatabase db = this.getReadableDatabase();
        Set<BeveragesInterface> beverages = new HashSet<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        BeveragesInterface tea = factory.getBeverage("TEA");
        BeveragesInterface coffee = factory.getBeverage("COFFEE");
        BeveragesInterface sprite = factory.getBeverage("SPRITE");
        BeveragesInterface fanta = factory.getBeverage("FANTA");
        BeveragesInterface coke = factory.getBeverage("COKE");
        BeveragesInterface pepsi = factory.getBeverage("PEPSI");
        BeveragesInterface strawberryMilkshake = factory.getBeverage("STRAWBERRY MILKSHAKE");
        BeveragesInterface chocolateMilkshake = factory.getBeverage("CHOCOLATE MILKSHAKE");
        BeveragesInterface bubblegumMilkshake = factory.getBeverage("BUBBLEGUM MILKSHAKE");
        open();

        if(cursor.moveToFirst())
        {
            do{
                if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("TEA"))
                {
                    tea.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    tea.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(tea);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("COFFEE"))
                {
                    coffee.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    coffee.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(coffee);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("SPRITE"))
                {
                    sprite.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    sprite.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(sprite);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("COKE"))
                {
                    coke.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    coke.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(coke);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("FANTA"))
                {
                    fanta.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    fanta.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(fanta);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("PEPSI"))
                {
                    pepsi.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    pepsi.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(pepsi);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
                {
                    chocolateMilkshake.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    chocolateMilkshake.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(chocolateMilkshake);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
                {
                    strawberryMilkshake.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    strawberryMilkshake.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(strawberryMilkshake);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
                {
                    bubblegumMilkshake.setBeverage(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    bubblegumMilkshake.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    beverages.add(bubblegumMilkshake);
                }
            }while (cursor.moveToNext());
        }
        return beverages;
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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + " , which will destroy all old data "
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
