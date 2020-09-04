package com.expensescalculator.Adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by krishna on 02/02/2019.
 */



public class AdapterExpDistinctMonth  extends BaseAdapter {

    ArrayList<BeanExpense> arrayDistinctMonth;
    Activity act;

    public AdapterExpDistinctMonth(Activity act, ArrayList<BeanExpense> arrayDistinctMonth) {
        this.arrayDistinctMonth = arrayDistinctMonth;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayDistinctMonth.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayDistinctMonth.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {

        TextView txtExpMonth;
}


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null);
            holder = new ViewHolder();

            holder.txtExpMonth = (TextView) convertView.findViewById(R.id.lblListHeader);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.txtExpMonth.setText(arrayDistinctMonth.get(position).getExpMonth() + "");


        return convertView;
    }
}