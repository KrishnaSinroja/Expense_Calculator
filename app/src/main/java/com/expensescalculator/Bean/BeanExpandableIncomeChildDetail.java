package com.expensescalculator.Bean;

/**
 * Created by krishna on 27/03/2019.
 */
public class BeanExpandableIncomeChildDetail {


    private String incomeID;
    private  String incomeCategoryID;
    private  String incomeAmount;
    private  String incomeDate;

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeCategoryID() {
        return incomeCategoryID;
    }

    public void setIncomeCategoryID(String incomeCategoryID) {
        this.incomeCategoryID = incomeCategoryID;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(String incomeID) {
        this.incomeID = incomeID;
    }
}
