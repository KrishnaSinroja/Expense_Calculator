package com.expensescalculator.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.R;

import java.util.ArrayList;

/**
 * Created by krishna on 19/01/2019.
 */
public class AdapterDisplayAllIExpense extends BaseAdapter {

    ArrayList<BeanExpense> arrayAllExpense;
    Activity act;

    public AdapterDisplayAllIExpense(Activity act, ArrayList<BeanExpense> arrayAllExpense)
    {
        this.arrayAllExpense = arrayAllExpense;
        this.act = act;
    }


    @Override
    public int getCount() {

        return arrayAllExpense.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayAllExpense.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtExpDate;
        TextView txtExpIncome;
        TextView txtExpCategory;
        TextView txtExpPayee;
        TextView txtExpDescription;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        LayoutInflater inflater = act.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null);
            holder = new ViewHolder();
            holder.txtExpDate = (TextView) convertView.findViewById(R.id.addexpense_tv_Date);
            holder.txtExpIncome = (TextView) convertView.findViewById(R.id.addexpense_tv_expense);
            holder.txtExpCategory = (TextView) convertView.findViewById(R.id.addexpense_tv_Category);
            holder.txtExpPayee = (TextView) convertView.findViewById(R.id.addexpense_tv_Payee);
            holder.txtExpDescription = (TextView) convertView.findViewById(R.id.addexpense_ed_discription);
            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtExpDate.setText(arrayAllExpense.get(position).getExpDate() + "");
        holder.txtExpIncome.setText(arrayAllExpense.get(position).getExpExpense() + "");
        holder.txtExpCategory.setText(arrayAllExpense.get(position).getExpCategory() + "");
        holder.txtExpPayee.setText(arrayAllExpense.get(position).getExpPayee() + "");
        holder.txtExpDescription.setText(arrayAllExpense.get(position).getExpDiscription() + "");

        return convertView;
    }
}