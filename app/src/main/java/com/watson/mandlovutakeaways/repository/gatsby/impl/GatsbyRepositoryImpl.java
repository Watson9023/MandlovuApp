package com.watson.mandlovutakeaways.repository.gatsby.impl;


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
import com.watson.mandlovutakeaways.domain.gatsby.GatsbyInterface;
import com.watson.mandlovutakeaways.factories.gatsby.SingleGatsby;
import com.watson.mandlovutakeaways.repository.gatsby.GatsbyRepository;

import java.util.HashSet;
import java.util.Set;

public class GatsbyRepositoryImpl extends SQLiteOpenHelper implements GatsbyRepository {

    private SQLiteDatabase db;
    public static final String TABLE_NAME = "gatsbys";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PRICE = "price";

    //Database Creation Statement

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + " ("
            + COLUMN_TYPE + "TEXT NOT NULL, "
            + COLUMN_PRICE + "TEXT NOT NULL );";

    public GatsbyRepositoryImpl(Context context)
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
    public GatsbyInterface findByType(String type) {
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
        if(cursor.moveToFirst()) {
            if(type.equalsIgnoreCase("STEAK GATSBY"))
            {
                final GatsbyInterface steak = SingleGatsby.getGatsby(type);
                steak.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                steak.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                return steak;
            }
            else if(type.equalsIgnoreCase("CHICKEN GATSBY"))
            {
                final GatsbyInterface chicken = SingleGatsby.getGatsby(type);
                chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                chicken.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                return chicken;
            }
            else if(type.equalsIgnoreCase("FULLHOUSE GATSBY"))
            {
                final GatsbyInterface fullhouse = SingleGatsby.getGatsby(type);
                fullhouse.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                fullhouse.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                return fullhouse;
            }
        }
        return null;
    }

    @Override
    public GatsbyInterface save(GatsbyInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("CHICKEN GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;

        }
        else if(type.equalsIgnoreCase("STEAK GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        else if(type.equalsIgnoreCase("FULLHOUSE GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.insertOrThrow(TABLE_NAME,null, values);
            return entity;
        }
        return null;
    }

    @Override
    public GatsbyInterface update(GatsbyInterface entity, String type) {
        open();
        ContentValues values = new ContentValues();
        if(type.equalsIgnoreCase("CHICKEN GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;

        }
        else if(type.equalsIgnoreCase("STEAK GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("FULLHOUSE GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            values.put(COLUMN_TYPE,entity.getGatsbyType());
            values.put(COLUMN_PRICE,entity.getGatsbyPrice());
            db.update(
                    TABLE_NAME,
                    values,
                    COLUMN_TYPE + " =? ",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;
        }
        return null;
    }

    @Override
    public GatsbyInterface delete(GatsbyInterface entity, String type) {
        open();
        if(type.equalsIgnoreCase("STEAK GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("CHICKEN GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;
        }
        else if(type.equalsIgnoreCase("FULLHOUSE GATSBY"))
        {
            entity = SingleGatsby.getGatsby(type);
            db.delete(
                    TABLE_NAME,
                    COLUMN_TYPE + "=?",
                    new String[]{String.valueOf(entity.getGatsbyType())}
            );
            return entity;
        }
        return null;
    }

    @Override
    public Set<GatsbyInterface> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        GatsbyInterface steak = SingleGatsby.getGatsby("STEAK GATSBY");
        GatsbyInterface chicken = SingleGatsby.getGatsby("CHICKEN GATSBY");
        GatsbyInterface fullHouse = SingleGatsby.getGatsby("FULLHOUSE GATSBY");
        Set<GatsbyInterface> gatsbys = new HashSet<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        open();

        if(cursor.moveToFirst())
        {
            do{
                if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("STEAK GATSBY"))
                {
                    steak.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    steak.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    gatsbys.add(steak);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("CHICKEN GATSBY"))
                {
                    chicken.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    chicken.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    gatsbys.add(chicken);
                }
                else if(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)).equalsIgnoreCase("FULLHOUSE GATSBY"))
                {
                    fullHouse.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                    fullHouse.setPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)));
                    gatsbys.add(fullHouse);
                }
            }while (cursor.moveToNext());
        }
        return gatsbys;
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
