package com.expensescalculator.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.Bean.BeanMonth;
import com.expensescalculator.R;

import java.util.ArrayList;

/**
 * Created by krishna on 11/02/2019.
 */

public class AdapterMonthSpinner extends BaseAdapter {

    ArrayList<BeanMonth> arrayMonth;
    Activity act;

    public AdapterMonthSpinner(Activity act, ArrayList<BeanMonth> arrayMonth) {
        this.arrayMonth = arrayMonth;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayMonth.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayMonth.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtMonthID;
        TextView txtMonthName;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_month, null);
            holder = new ViewHolder();
            holder.txtMonthID = (TextView) convertView.findViewById(R.id.sp_expcat_tv_id);
            holder.txtMonthName = (TextView) convertView.findViewById(R.id.sp_expcat_tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtMonthID.setText(arrayMonth.get(position).getMonthID() + "");
        holder.txtMonthName.setText(arrayMonth.get(position).getMonthName() + "");


        return convertView;
    }
}