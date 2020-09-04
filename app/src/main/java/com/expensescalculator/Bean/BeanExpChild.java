package com.expensescalculator.Bean;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * Created by krishna on 06/03/2019.
 */
public class BeanExpChild {


    private  String expID;

    public String getExpID() {
        return expID;
    }

    public void setExpID(String expID) {
        this.expID = expID;
    }

    private String category;
    private String date;
    private  String expense;

    private ArrayList<BeanExpChild> children = new ArrayList<BeanExpChild>();

    public ArrayList<BeanExpChild> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<BeanExpChild> children) {
        this.children = children;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }
}
