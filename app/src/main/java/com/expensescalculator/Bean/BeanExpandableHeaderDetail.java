package com.expensescalculator.Bean;

import java.util.ArrayList;

/**
 * Created by krishna on 27/03/2019.
 */
public class BeanExpandableHeaderDetail {

    private String name;
    private ArrayList<BeanExpandableChildDetail> MonthList = new ArrayList<BeanExpandableChildDetail>();
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

    public ArrayList<BeanExpandableChildDetail> getMonthList() {
        return MonthList;
    }

    public void setMonthList(ArrayList<BeanExpandableChildDetail> monthList) {
        MonthList = monthList;
    }
}



