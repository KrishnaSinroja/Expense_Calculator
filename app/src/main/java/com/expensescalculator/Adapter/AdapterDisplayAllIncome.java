package com.expensescalculator.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.R;

import java.util.ArrayList;

/**
 * Created by krishna on 19/01/2019.
 */
public class AdapterDisplayAllIncome extends BaseAdapter {

    ArrayList<BeanIncome> arrayAllIncome;
    Activity act;

    public AdapterDisplayAllIncome(Activity act, ArrayList<BeanIncome> arrayAllIncome)
    {
        this.arrayAllIncome = arrayAllIncome;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayAllIncome.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayAllIncome.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtIncDate;
        TextView txtIncIncome;
        TextView txtIncCategory;
        TextView txtIncPayer;
        TextView txtIncDescription;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_incomecategory, null);
            holder = new ViewHolder();
            holder.txtIncDate = (TextView) convertView.findViewById(R.id.addincome_tv_Date);
            holder.txtIncIncome = (TextView) convertView.findViewById(R.id.addincome_tv_Income);
            holder.txtIncCategory = (TextView) convertView.findViewById(R.id.addincome_tv_Category);
            holder.txtIncPayer = (TextView) convertView.findViewById(R.id.addincome_tv_Payer);
            holder.txtIncDescription = (TextView) convertView.findViewById(R.id.addincome_tv_Discription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtIncDate.setText(arrayAllIncome.get(position).getIncDate() + "");
        holder.txtIncIncome.setText(arrayAllIncome.get(position).getIncIncome() + "");
        holder.txtIncCategory.setText(arrayAllIncome.get(position).getIncCategory() + "");
        holder.txtIncPayer.setText(arrayAllIncome.get(position).getIncPayer() + "");
        holder.txtIncDescription.setText(arrayAllIncome.get(position).getIncDiscription() + "");

        return convertView;
    }
}