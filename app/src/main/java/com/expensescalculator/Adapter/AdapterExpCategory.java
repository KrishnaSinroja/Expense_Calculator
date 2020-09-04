package com.expensescalculator.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.R;

import java.util.ArrayList;

/**
 * Created by krishna on 19/01/2019.
 */
public class AdapterExpCategory extends BaseAdapter {

    ArrayList<BeanExpenseCategory> arrayExpCategory;
    Activity act;

    public AdapterExpCategory(Activity act, ArrayList<BeanExpenseCategory> arrayExpCategory) {
        this.arrayExpCategory = arrayExpCategory;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayExpCategory.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayExpCategory.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtExpCatID;
        TextView txtExpCatName;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null);
            holder = new ViewHolder();
            holder.txtExpCatID = (TextView) convertView.findViewById(R.id.sp_expcat_tv_id);
            holder.txtExpCatName = (TextView) convertView.findViewById(R.id.sp_expcat_tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtExpCatID.setText(arrayExpCategory.get(position).getExpCatID() + "");
        holder.txtExpCatName.setText(arrayExpCategory.get(position).getExpCatName() + "");


        return convertView;
    }
}