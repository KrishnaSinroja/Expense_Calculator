package com.expensescalculator.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.R;

import java.util.ArrayList;

/**
 * Created by krishna on 19/01/2019.
 */
public class AdapterIncCategory extends BaseAdapter {

    ArrayList<BeanIncomeCategory> arrayIncCategory;
    Activity act;

    public AdapterIncCategory(Activity act, ArrayList<BeanIncomeCategory> arrayIncCategory)
    {
        this.arrayIncCategory = arrayIncCategory;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayIncCategory.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayIncCategory.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtIncCatID;
        TextView txtIncCatName;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_incomecategory, null);
            holder = new ViewHolder();
            holder.txtIncCatID = (TextView) convertView.findViewById(R.id.sp_inccat_tv_id);
            holder.txtIncCatName = (TextView) convertView.findViewById(R.id.sp_inccat_tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtIncCatID.setText(arrayIncCategory.get(position).getIncCatID() + "");
        holder.txtIncCatName.setText(arrayIncCategory.get(position).getIncCatName() + "");


        return convertView;
    }
}