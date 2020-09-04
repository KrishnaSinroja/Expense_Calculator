package com.expensescalculator.Bean;

import java.util.ArrayList;

/**
 * Created by krishna on 27/03/2019.
 */
public class BeanExpandableIncomeHeaderDetail {

    private String name;
    private ArrayList<BeanExpandableIncomeChildDetail> MonthList = new ArrayList<BeanExpandableIncomeChildDetail>();
    private String totalAmount;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BeanExpandableIncomeChildDetail> getMonthList() {
        return MonthList;
    }

    public void setMonthList(ArrayList<BeanExpandableIncomeChildDetail> monthList) {
        MonthList = monthList;
    }
}



