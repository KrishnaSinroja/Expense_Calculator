package com.expensescalculator.Bean;

/**
 * Created by krishna on 27/03/2019.
 */
public class BeanExpandableChildDetail {


    private String expenseID;
    private  String expenseCategoryID;
    private  String expenseAmount;
    private  String expenseDate;

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public String getExpenseCategoryID() {
        return expenseCategoryID;
    }

    public void setExpenseCategoryID(String expenseCategoryID) {
        this.expenseCategoryID = expenseCategoryID;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

}
