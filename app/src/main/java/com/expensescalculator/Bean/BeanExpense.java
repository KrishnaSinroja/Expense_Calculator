package com.expensescalculator.Bean;

/**
 * Created by krishna on 09/01/2019.
 */
public class BeanExpense {

    private int expID;
    private String expDate;
    private String expMonth;
    private String expYear;
    private String expDay;
    private String expExpense;
    private String expCategory;
    private String expPayee;
    private String expDiscription;
    private int expCatID;
    private int expTotalExpense;

    public int getExpTotalExpense() {
        return expTotalExpense;
    }

    public void setExpTotalExpense(int expTotalExpense) {
        this.expTotalExpense = expTotalExpense;
    }

    public int getExpCatID() {
        return expCatID;
    }

    public void setExpCatID(int expCatID) {
        this.expCatID = expCatID;
    }

    public String getExpExpense() {
        return expExpense;
    }

    public String getExpDay() {
        return expDay;
    }

    public void setExpDay(String expDay) {
        this.expDay = expDay;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setExpExpense(String expExpense) {
        this.expExpense = expExpense;
    }



    public String getExpCategory() {
        return expCategory;
    }

    public void setExpCategory(String expCategory) {
        this.expCategory = expCategory;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDiscription() {
        return expDiscription;
    }

    public void setExpDiscription(String expDiscription) {
        this.expDiscription = expDiscription;
    }



    public int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        this.expID = expID;
    }

    public String getExpPayee() {
        return expPayee;
    }

    public void setExpPayee(String expPayee) {
        this.expPayee = expPayee;
    }
}
