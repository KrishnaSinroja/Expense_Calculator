package com.expensescalculator.DBhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by krishna on 18/01/2019.
 */
public class DB_IncomeCategory extends SQLiteAssetHelper {

    public DB_IncomeCategory(Context context) {
        super(context, Constant.dbName, null, Constant.dbVersion);
    }

    public ArrayList<BeanIncomeCategory> selectAllIncCat()
    {
        ArrayList<BeanIncomeCategory> arrayIncCategory=new ArrayList<BeanIncomeCategory>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Inc_Category";
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                BeanIncomeCategory bic = new BeanIncomeCategory();
                bic.setIncCatID(c.getInt(c.getColumnIndex("IncCatID")));
                bic.setIncCatName(c.getString(c.getColumnIndex("IncCatName"))) ;
                arrayIncCategory.add(bic);

            } while (c.moveToNext());

        }
        db.close();
        return arrayIncCategory;

    }

    public String selectById(int incCatID)
    {

        SQLiteDatabase db = getReadableDatabase();
        String query = "select IncCatName from EC_Inc_Category where IncCatID="+incCatID;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String strCat="";
        if (cursor.moveToFirst())
            strCat=(cursor.getString(cursor.getColumnIndex("IncCatName")));
        db.close();
        return strCat;
    }


}
