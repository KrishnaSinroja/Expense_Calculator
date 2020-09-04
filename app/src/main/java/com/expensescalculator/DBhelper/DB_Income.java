package com.expensescalculator.DBhelper;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by krishna on 18/01/2019.
 */

public class DB_Income extends SQLiteAssetHelper {
    public DB_Income(Context context) {
        super(context, Constant.dbName, null, Constant.dbVersion);
    }
//
//
    public void insertIncome(BeanIncome bi) {
        int incID = 1;
        SQLiteDatabase db1 = getReadableDatabase();
        String strQuery = "select MAX(IncID) as HighestValue from EC_Income";
        Cursor cur = db1.rawQuery(strQuery, null);
        if (cur.moveToFirst()) {
            if (cur.getCount() > 0)
                incID = cur.getInt(cur.getColumnIndex("HighestValue")) + 1;
        }

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IncID", incID);
        cv.put("IncDate", bi.getIncDate());
        cv.put("IncIncome", bi.getIncIncome());
        cv.put("IncCatID", bi.getIncCatID());
        cv.put("IncPayer", bi.getIncPayer());
        cv.put("IncDescription", bi.getIncDiscription());
        cv.put("IncMonth", bi.getIncMonth());
        cv.put("IncYear", bi.getIncYear());
        cv.put("IncDay",bi.getIncDay());
        db.insert("EC_Income", null, cv);
        db.close();

    }


    public ArrayList<BeanIncome> selectAllIIncome(String Month) {
        ArrayList<BeanIncome> arrayAllIncome = new ArrayList<BeanIncome>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Income where IncMonth='"+Month+"'";
        Cursor c = db.rawQuery(query, null);

        Log.d("hello", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanIncome binc = new BeanIncome();
                binc.setIncID(c.getInt(c.getColumnIndex("IncID")));
                binc.setIncDate(c.getString(c.getColumnIndex("IncDate")));
                binc.setIncIncome(c.getString(c.getColumnIndex("IncIncome")));
                binc.setIncCatID(c.getInt(c.getColumnIndex("IncCatID")));
                binc.setIncPayer(c.getString(c.getColumnIndex("IncPayer")));
                binc.setIncDiscription(c.getString(c.getColumnIndex("IncDescription")));
                binc.setIncMonth(c.getString(c.getColumnIndex("IncMonth")));
                arrayAllIncome.add(binc);

            } while (c.moveToNext());

        }
        db.close();
        return arrayAllIncome;

    }



    public ArrayList<BeanIncome> selectDistinctMonth() {
        ArrayList<BeanIncome> arrayDistinctMonth = new ArrayList<BeanIncome>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select distinct(IncMonth) from EC_Income";
        Cursor c = db.rawQuery(query, null);

        //Log.d("hello", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanIncome binc = new BeanIncome();
                binc.setIncMonth(c.getString(c.getColumnIndex("IncMonth")));
                arrayDistinctMonth.add(binc);

            } while (c.moveToNext());

        }
        db.close();
        return arrayDistinctMonth;

    }

    public String getMonthName(String Month)
    {

        SQLiteDatabase db = getReadableDatabase();
        String query = "select ExpMonthName from EC_Month where ExpMonthID="+Month;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String strMonth="";
        if (cursor.moveToFirst())
            strMonth=(cursor.getString(cursor.getColumnIndex("ExpMonthName")));
        db.close();
        return strMonth;
    }



    public String getCatName(int name){
        SQLiteDatabase db = getReadableDatabase();
        String i;
        Cursor c = db.rawQuery("select IncCatName from EC_Inc_Category where IncCatID = '"+name+"'",null);
        if(c.moveToFirst()) {
            i = c.getString(c.getColumnIndex("IncCatName"));
        }else{
            i = "";
        }
        return i;
    }

    public ArrayList<BeanIncome> getAllRecords() {
        ArrayList<BeanIncome> arrayAllIncome = new ArrayList<BeanIncome>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Income";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                BeanIncome binc = new BeanIncome();
                binc.setIncID(c.getInt(c.getColumnIndex("IncID")));
                binc.setIncDate(c.getString(c.getColumnIndex("IncDate")));
                binc.setIncCatID(c.getInt(c.getColumnIndex("IncCatID")));
                binc.setIncIncome(c.getString(c.getColumnIndex("IncIncome")));
                binc.setIncPayer(c.getString(c.getColumnIndex("IncPayer")));
                binc.setIncDiscription(c.getString(c.getColumnIndex("IncDescription")));
                binc.setIncCategory(getCatName(binc.getIncCatID()));
                binc.setIncMonth(c.getString(c.getColumnIndex("IncMonth")));
                arrayAllIncome.add(binc);

            } while (c.moveToNext());

        }
        db.close();
        return arrayAllIncome;
    }

    public BeanIncome selectByID(int incID) {

        BeanIncome bi = new BeanIncome();
        SQLiteDatabase db1 = getReadableDatabase();
        String strQuery = "select * from EC_Income where IncID=" + incID;
        Cursor cur = db1.rawQuery(strQuery, null);

        if (cur.moveToFirst()) {


            bi.setIncID(cur.getInt(cur.getColumnIndex("IncID")));
            bi.setIncDate(cur.getString(cur.getColumnIndex("IncDate")));
            bi.setIncPayer(cur.getString(cur.getColumnIndex("IncPayer")));
            bi.setIncCatID(cur.getInt(cur.getColumnIndex("IncCatID")));
            bi.setIncDiscription(cur.getString(cur.getColumnIndex("IncDescription")));
            bi.setIncIncome(cur.getString(cur.getColumnIndex("IncIncome")));


        }

        db1.close();
        return bi;
    }

    public void deletByID(int incID) {


        SQLiteDatabase db1 = getWritableDatabase();
        String strQuery = "delete from EC_Income where IncID=" + incID;
        db1.execSQL(strQuery);
        db1.close();
    }


    public void updateData(BeanIncome bi) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("IncDate", bi.getIncDate());
        cv.put("IncIncome", bi.getIncIncome());
        cv.put("IncCatID", bi.getIncCatID());
        cv.put("IncPayer", bi.getIncPayer());
        cv.put("IncDescription", bi.getIncDiscription());



        db.update("EC_Income", cv, "IncID=" + bi.getIncID(), null);
        db.close();


    }


    public  int gettotalIncome()
    {

        SQLiteDatabase db=getReadableDatabase();
        String strQuery = "select sum(IncIncome) as TotalIncome from EC_Income";
        Cursor cur = db.rawQuery(strQuery, null);
        int totalInc=0;
        if (cur.moveToFirst()) {
            if (cur.getCount() > 0)
                totalInc = cur.getInt(cur.getColumnIndex("TotalIncome"));
        }

        db.close();;
        return totalInc;
    }

}
