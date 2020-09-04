package com.expensescalculator.DBhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by krishna on 18/01/2019.
 */

public class DB_Expense extends SQLiteAssetHelper {
    public DB_Expense(Context context) {
        super(context, Constant.dbName, null, Constant.dbVersion);
    }
//
//    public  void insertExpense(BeanExpense be)
//    {
//
//        SQLiteDatabase db=getWritableDatabase();
//        ContentValues cv=new ContentValues();
//        //cv.put("ExpID",be.getExpID());
//        cv.put("ExpDate",be.getExpDate());
//        cv.put("ExpExpense",be.getExpExpense());
//        cv.put("ExpCatID",be.getExpCategory());
//        cv.put("ExpPayee",be.getExpPayee());
//        cv.put("ExpDescription", be.getExpDiscription());
//        cv.put("ExpMonth",be.getExpMonth());
//        cv.put("ExpYear",be.getExpYear());
//        cv.put("ExpDay",be.getExpDay());
//
//
//
//        db.insert("EC_Expense", null, cv);
//
//        Log.d("ExpId----------->>>>", String.valueOf(be.getExpID()));
//
//        db.close();
//
//
//
//    }

    public void insertExpense(BeanExpense be) {
        int expID = 1;
        SQLiteDatabase db1 = getReadableDatabase();
        String strQuery = "select MAX(ExpID) as HighestValue from EC_Expense";
        Cursor cur = db1.rawQuery(strQuery, null);
        if (cur.moveToFirst()) {
            if (cur.getCount() > 0)
                expID = cur.getInt(cur.getColumnIndex("HighestValue")) + 1;
        }

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ExpID", expID);
        cv.put("ExpDate", be.getExpDate());
        cv.put("ExpExpense", be.getExpExpense());
        cv.put("ExpCatID", be.getExpCatID());
        cv.put("ExpPayee", be.getExpPayee());
        cv.put("ExpDescription", be.getExpDiscription());
        cv.put("ExpMonth", be.getExpMonth());
        cv.put("ExpYear", be.getExpYear());
        cv.put("ExpDay",be.getExpDay());
        db.insert("EC_Expense", null, cv);
        db.close();


    }

    public String getCatName(int name){
        SQLiteDatabase db = getReadableDatabase();
        String i;
        Cursor c = db.rawQuery("select ExpCatName from EC_Exp_Category where ExpCatID = '"+name+"'",null);
        if(c.moveToFirst()) {
            i = c.getString(c.getColumnIndex("ExpCatName"));
        }else{
            i = "";
        }
        return i;
    }



    public ArrayList<BeanExpense> selectAllIExpense(String Month) {
        ArrayList<BeanExpense> arrayAllExpense = new ArrayList<BeanExpense>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Expense where ExpMonth='"+Month+"'";
        Cursor c = db.rawQuery(query, null);

        Log.d("size------+--->", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanExpense bexp = new BeanExpense();
                bexp.setExpID(c.getInt(c.getColumnIndex("ExpID")));
                bexp.setExpDate(c.getString(c.getColumnIndex("ExpDate")));
                bexp.setExpCatID(c.getInt(c.getColumnIndex("ExpCatID")));
                bexp.setExpExpense(c.getString(c.getColumnIndex("ExpExpense")));
                bexp.setExpPayee(c.getString(c.getColumnIndex("ExpPayee")));
                bexp.setExpDiscription(c.getString(c.getColumnIndex("ExpDescription")));
                arrayAllExpense.add(bexp);

            } while (c.moveToNext());

        }
        db.close();
        return arrayAllExpense;
    }

    public ArrayList<BeanExpense> getAllRecords() {
        ArrayList<BeanExpense> arrayAllExpense = new ArrayList<BeanExpense>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Expense";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                BeanExpense bexp = new BeanExpense();
                bexp.setExpID(c.getInt(c.getColumnIndex("ExpID")));
                bexp.setExpDate(c.getString(c.getColumnIndex("ExpDate")));
                bexp.setExpCatID(c.getInt(c.getColumnIndex("ExpCatID")));
                bexp.setExpExpense(c.getString(c.getColumnIndex("ExpExpense")));
                bexp.setExpPayee(c.getString(c.getColumnIndex("ExpPayee")));
                bexp.setExpDiscription(c.getString(c.getColumnIndex("ExpDescription")));
                bexp.setExpCategory(getCatName(bexp.getExpCatID()));
                bexp.setExpMonth(c.getString(c.getColumnIndex("ExpMonth")));
                arrayAllExpense.add(bexp);

            } while (c.moveToNext());

        }
        db.close();
        return arrayAllExpense;
    }

    public ArrayList<BeanExpense> selectDistinctMonth() {
        ArrayList<BeanExpense> arrayDistinctMonth = new ArrayList<BeanExpense>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select distinct(ExpMonth) from EC_Expense";
        Cursor c = db.rawQuery(query, null);

        Log.d("size-------->>>", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanExpense bexp = new BeanExpense();
                bexp.setExpMonth(c.getString(c.getColumnIndex("ExpMonth")));
                arrayDistinctMonth.add(bexp);

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

    public BeanExpense selectByID(int expID) {

        BeanExpense be = new BeanExpense();
        SQLiteDatabase db1 = getReadableDatabase();
        String strQuery = "select * from EC_Expense where ExpID=" + expID;
        Cursor cur = db1.rawQuery(strQuery, null);

        if (cur.moveToFirst()) {


            be.setExpID(cur.getInt(cur.getColumnIndex("ExpID")));
            be.setExpDate(cur.getString(cur.getColumnIndex("ExpDate")));
            be.setExpPayee(cur.getString(cur.getColumnIndex("ExpPayee")));
            be.setExpCatID(cur.getInt(cur.getColumnIndex("ExpCatID")));
            be.setExpDiscription(cur.getString(cur.getColumnIndex("ExpDescription")));
            be.setExpExpense(cur.getString(cur.getColumnIndex("ExpExpense")));


        }

        db1.close();
        return be;
    }

    public void deletByID(int expID) {


        SQLiteDatabase db1 = getWritableDatabase();
        String strQuery = "delete from EC_Expense where ExpID=" + expID;
        db1.execSQL(strQuery);

        db1.close();
    }


    public void updateData(BeanExpense be) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("ExpDate", be.getExpDate());
        cv.put("ExpExpense", be.getExpExpense());
        cv.put("ExpCatID", be.getExpCatID());
        cv.put("ExpPayee", be.getExpPayee());
        cv.put("ExpDescription", be.getExpDiscription());



        db.update("EC_Expense", cv, "ExpID=" + be.getExpID(), null);
        db.close();


    }

    public  int gettotalExpense()
    {

        SQLiteDatabase db=getReadableDatabase();
        String strQuery = "select sum(ExpExpense) as TotalExpense from EC_Expense";
        Cursor cur = db.rawQuery(strQuery, null);
        int totalExp=0;
        if (cur.moveToFirst()) {
            if (cur.getCount() > 0)
                totalExp = cur.getInt(cur.getColumnIndex("TotalExpense"));
        }

        db.close();
        return totalExp;
    }







//    public ArrayList<BeanExpense> getTotalExpense()
//    {
//        SQLiteDatabase db=getReadableDatabase();
//        Integer TotalExp=0;
//        ArrayList<BeanExpense> arrayTotalExpense=new ArrayList<>();
//        Cursor c = db.rawQuery("select sum(ExpExpense) from EC_Expense",null);
//        c.moveToFirst();
//        if(c.moveToFirst())
//        {
//            BeanExpense be=new BeanExpense();
//            be.setExpTotalExpense(c.getInt(c.getColumnIndex("ExpExpense")));
//            arrayTotalExpense.add(be);
//        }
//        return arrayTotalExpense;
//
//    }




//    public BeanExpense gettotalExpense() {
//
//        BeanExpense be = new BeanExpense();
//        SQLiteDatabase db1 = getReadableDatabase();
//        Integer totalExp=0;
//        String strQuery = "select sum(ExpExpense) from EC_Expense";
//        Cursor cur = db1.rawQuery(strQuery, null);
//        cur.moveToFirst();
//        do {
//            be.setExpTotalExpense(cur.getInt(cur.getColumnIndex("ExpExpense")));
//            //totalExp=cur.getInt(cur.getColumnIndex("ExpExpense"));
//        }while (cur.moveToNext());
//        db1.close();
//        return be;
//    }

//    public Integer getTotalExpense()
//    {
//        SQLiteDatabase db=getReadableDatabase();
//        String month="March";
//        Integer TotalExp=0;
//        Cursor c = db.rawQuery("SELECT SUM(ExpExpense) FROM EC_Expense WHERE TRIM(ExpMonth) = '"+month.trim()+"'", null);
//        c.moveToFirst();
//       do {
//           TotalExp=c.getInt(c.getColumnIndex("ExpExpense"));
//       }while (c.moveToFirst());
//
//
//        return TotalExp;
//    }


}
