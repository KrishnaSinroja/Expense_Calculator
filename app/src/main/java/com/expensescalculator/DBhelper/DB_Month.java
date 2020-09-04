package com.expensescalculator.DBhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.expensescalculator.Bean.BeanMonth;
import com.expensescalculator.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by krishna on 11/02/2019.
 */
public class DB_Month extends SQLiteAssetHelper {

    public DB_Month(Context context) {
        super(context, Constant.dbName, null, Constant.dbVersion);
    }

    public ArrayList<BeanMonth> selectAllMonth() {
        ArrayList<BeanMonth> arrayMonth = new ArrayList<BeanMonth>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Month";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                BeanMonth bm = new BeanMonth();
                bm.setMonthID(cursor.getInt(cursor.getColumnIndex("ExpMonthID")));
                bm.setMonthName(cursor.getString(cursor.getColumnIndex("ExpMonthName")));
                arrayMonth.add(bm);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayMonth;
    }

    public String selectById(String expMonthID)
    {

        SQLiteDatabase db = getReadableDatabase();
        String query = "select ExpMonthName from EC_Month where ExpMonthID="+Integer.parseInt(expMonthID);
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String stMonthName="";
        if (cursor.moveToFirst())
            stMonthName=(cursor.getString(cursor.getColumnIndex("ExpMonthName")));
        db.close();
        return stMonthName;
    }



}

