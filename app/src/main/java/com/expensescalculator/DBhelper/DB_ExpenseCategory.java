package com.expensescalculator.DBhelper;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by krishna on 18/01/2019.
 */

public class DB_ExpenseCategory extends SQLiteAssetHelper {

    public DB_ExpenseCategory(Context context) {
        super(context, Constant.dbName, null, Constant.dbVersion);
    }

    public ArrayList<BeanExpenseCategory> selectAllExpCat() {
        ArrayList<BeanExpenseCategory> arrayExpCategory = new ArrayList<BeanExpenseCategory>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Exp_Category";
        Cursor c = db.rawQuery(query, null);

        Log.d("hello", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanExpenseCategory bec = new BeanExpenseCategory();
                bec.setExpCatID(c.getInt(c.getColumnIndex("ExpCatID")));
                bec.setExpCatName(c.getString(c.getColumnIndex("ExpCatName")));
                arrayExpCategory.add(bec);

            } while (c.moveToNext());

        }
        db.close();
        return arrayExpCategory;

    }

    public String selectById(int expCatID)
    {

        SQLiteDatabase db = getReadableDatabase();
        String query = "select ExpCatName from EC_Exp_Category where ExpCatID="+expCatID;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String strCat="";
        if (cursor.moveToFirst())
            strCat=(cursor.getString(cursor.getColumnIndex("ExpCatName")));
        db.close();
        return strCat;
    }
}
