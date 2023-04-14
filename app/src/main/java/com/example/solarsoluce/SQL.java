package com.example.solarsoluce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQL extends SQLiteOpenHelper {
    public SQL(@Nullable Context context) {
        super(context,"SolarSoluceSQL", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE panneau(_id INTEGER PRIMARY KEY,nom TEXT,type TEXT,description TEXT,rendement REAL,prodmoy REAL,prodmax REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS panneau");
        onCreate(db);
    }

    public void insertPanneau(Panneau p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("type",p.getType());
        cv.put("description",p.getDescription());
        cv.put("rendement",p.getRendement());
        cv.put("prodmoy",p.getProdmoy());
        cv.put("prodmax",p.getProdmax());
        db.insert("panneau",null,cv);
        db.close();
    }

    public void updatePanneau(Panneau p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("type",p.getType());
        cv.put("description",p.getDescription());
        cv.put("rendement",p.getRendement());
        cv.put("prodmoy",p.getProdmoy());
        cv.put("prodmax",p.getProdmax());
        db.update("panneau",cv,"_id=?",new String[]{String.valueOf(p.getId())});
        db.close();
    }

    public void deletePanneau(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("panneau","_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getAllProducts(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM panneau",null);
    }

    public Panneau getOnePanneau(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.query("panneau",new String[]{"_id","nom","type","description","prodmoy","prodmax","rendement"},"_id=?",
                new String[]{String.valueOf(id)},null,null,null);
        c.moveToFirst();
        Panneau p= new Panneau(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getDouble(4),c.getDouble(5),c.getDouble(6));
        c.close();
        return p;
    }
    public Panneau getOnePanneauByName(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.query("panneau",new String[]{"_id","nom","type","description","prodmoy","prodmax","rendement"},"nom=?",
                new String[]{String.valueOf(name)},null,null,null);
        c.moveToFirst();
        Panneau p= new Panneau(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getDouble(4),c.getDouble(5),c.getDouble(6));
        c.close();
        return p;
    }
}