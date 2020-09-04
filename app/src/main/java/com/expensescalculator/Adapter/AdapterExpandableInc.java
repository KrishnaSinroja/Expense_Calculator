package com.expensescalculator.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.expensescalculator.Bean.BeanExpandableChildDetail;
import com.expensescalculator.Bean.BeanExpandableHeaderDetail;
import com.expensescalculator.Bean.BeanExpandableIncomeChildDetail;
import com.expensescalculator.Bean.BeanExpandableIncomeHeaderDetail;
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by krishna on 22/01/2019.
 */
public class AdapterExpandableInc extends BaseExpandableListAdapter {

////    private Context _context;
////    private List<String> _listDataHeader; // header titles
////    // child data in format of header title, child title
////    private ArrayList<BeanExpense> _listDataChild;
////    private List<String> allInc;
////
////
////    public AdapterExpandableInc(Context context, List<String> listDataHeader,
////                                ArrayList<BeanExpense> _listDataChild,List<String> allInc) {
////        this._context = context;
////        this._listDataHeader = listDataHeader;
////        this._listDataChild = listChildData;
////        this.allInc=allInc;
////
////    }
////
////    @Override
////    public Object getChild(int groupPosition, int childPosititon) {
////        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
////                .get(childPosititon/3);
////    }
////
////    @Override
////    public long getChildId(int groupPosition, int childPosition) {
////        return childPosition/3;
////    }
////
////    @Override
////    public View getChildView(int groupPosition, final int childPosition,
////                             boolean isLastChild, View convertView, ViewGroup parent) {
////
////
////
////
//////        final String childText1 = (String) getChild(groupPosition, childPosition);
//////        final String childText2 = (String) getChild(groupPosition, childPosition);
//////        final String childText3 = (String) getChild(groupPosition, childPosition);
////
////        if (convertView == null) {
////            LayoutInflater infalInflater = (LayoutInflater) this._context
////                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            convertView = infalInflater.inflate(R.layout.lst_item_income, null);
////        }
////
////        TextView txtListChildCategory = (TextView) convertView
////                .findViewById(R.id.lblListCategory);
////
////        TextView txtListChildDate = (TextView) convertView
////                .findViewById(R.id.lblListDate);
////
////        TextView txtListChildIncome = (TextView) convertView
////                .findViewById(R.id.lblListIncome);
//////
////
//////        String childText1 = (String) getChild(groupPosition, childPosition);
//////        txtListChildCategory.setText(childText1);
//////
//////        childText1 = (String) getChild(groupPosition, childPosition);
//////        txtListChildDate.setText(childText1);
//////
//////        childText1 = (String) getChild(groupPosition, childPosition);
//////        txtListChildIncome.setText(childText1);
////
//////        for(int i=0;i<allInc.size();i++)
//////        {
//////            txtListChildCategory.setText(allInc.get(i));
//////            txtListChildDate.setText(allInc.get(i+1));
//////           // txtListChildIncome.setText(allInc.get(i+2));
//////        }
////
//////        txtListChildCategory.setText(allInc.get(0));
//////        txtListChildDate.setText(allInc.get(1));
//////        txtListChildIncome.setText(allInc.get(2));
////
////
////
//////
////        for(int i=0;i<allInc.size();i+=3)
////        {
////            txtListChildCategory.setText(allInc.get(i));
////            txtListChildDate.setText(allInc.get(i+1));
////            txtListChildIncome.setText(allInc.get(i+2));
////        }
////
////
////
////
////
////
////
////
////        return convertView;
////
////
////    }
////
////    @Override
////    public int getChildrenCount(int groupPosition) {
////        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
////                .size()/3;
////
////
////    }
////
////    @Override
////    public Object getGroup(int groupPosition) {
////        return this._listDataHeader.get(groupPosition);
////    }
////
////    @Override
////    public int getGroupCount() {
////        return this._listDataHeader.size();
////    }
////
////    @Override
////    public long getGroupId(int groupPosition) {
////        return groupPosition;
////    }
////
////    @Override
////    public View getGroupView(int groupPosition, boolean isExpanded,
////                             View convertView, ViewGroup parent) {
////        String headerTitle = (String) getGroup(groupPosition);
////        if (convertView == null) {
////            LayoutInflater infalInflater = (LayoutInflater) this._context
////                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            convertView = infalInflater.inflate(R.layout.lst_grp_income, null);
////        }
////
////        TextView lblListHeader = (TextView) convertView
////                .findViewById(R.id.lblListHeader);
////        lblListHeader.setTypeface(null, Typeface.BOLD);
////        lblListHeader.setText(headerTitle);
////
////
////        return convertView;
////    }
////
////    @Override
////    public boolean hasStableIds() {
////        return false;
////    }
////
////    @Override
////    public boolean isChildSelectable(int groupPosition, int childPosition) {
////        return true;
////    }
//
//    private Context _context;
//    private List<String> _listDataHeader; // header titles
//
//    private ArrayList<BeanIncome> _listDataChild;
//    private List<String> allInc;
//
//    ArrayList<BeanIncome> arrayAllExpense;
//
//    BeanIncome bi=new BeanIncome();;
//
//    ArrayList<BeanIncome> arrayInc;
//
//
//    public AdapterExpandableInc(Context context, List<String> listDataHeader,
//                                ArrayList<BeanIncome> listChildData ,List<String> allInc) {
//        this._context = context;
//        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
//        this.allInc=allInc;
//
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosititon) {
//        return this._listDataChild.get(groupPosition);
//
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition/3;
//        //return  childPosition;
//    }
//
//    @Override
//    public View getChildView(int groupPosition,  int childPosition,
//                             boolean isLastChild, View convertView, ViewGroup parent) {
//
//
//
//
//        //final String childText1 = (String) getChild(groupPosition, childPosition);
//        //final String childText2 = (String) getChild(groupPosition, childPosition);
//        //final String childText3 = (String) getChild(groupPosition, childPosition);
//
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.lst_item_income, null);
//        }
//
//
//
//        TextView txtListChildCategory = (TextView) convertView
//                .findViewById(R.id.IncomelblListCategory);
//
//        TextView txtListChildDate = (TextView) convertView
//                .findViewById(R.id.IncomelblListDate);
//
//        TextView txtListChildExpense = (TextView) convertView
//                .findViewById(R.id.IncomelblListIncome);
//
//        TextView txtListChildID = (TextView) convertView
//                .findViewById(R.id.IncomelblListid);
//
//
//
//        Log.v("-------------->>",_listDataHeader.get(groupPosition));
//
//
//        if(_listDataChild.get(childPosition).getIncMonth().equals(_listDataHeader.get(groupPosition))) {
//
//            txtListChildID.setText(Integer.toString(_listDataChild.get(childPosition).getIncID()));
//            txtListChildCategory.setText(_listDataChild.get(childPosition).getIncCategory());
//            txtListChildDate.setText(_listDataChild.get(childPosition).getIncDate());
//            txtListChildExpense.setText(_listDataChild.get(childPosition).getIncIncome());
//        }
//
//        return convertView;
//
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//
//        //Toast.makeText(_context,this._listDataChild.get(this._listDataHeader.get(groupPosition)).size()/3+"----"+this._listDataChild.get(this._listDataHeader.get(groupPosition)).size(),Toast.LENGTH_SHORT).show();
//        return this._listDataChild.size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this._listDataHeader.get(groupPosition);
//
//    }
//
//    @Override
//    public int getGroupCount() {
//        return this._listDataHeader.size();
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded,
//                             View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
//
//        // final BeanExpParent parentdetail=parents.get(groupPosition);
//
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.lst_grp_income, null);
//        }
//
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.lblListHeader);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle);
//
//
//
//        return convertView;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }

//      New Adapter Starts frorm here


    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private ArrayList<BeanIncome> _listDataChild;
    private List<String> allInc;
    //private List<String> allExpData;
    ArrayList<BeanIncome> arrayAllIncome;

    BeanIncome bi=new BeanIncome();;
    private ArrayList<BeanExpandableIncomeHeaderDetail> headerMonthList;

    String strdemo;
    ArrayList<BeanIncome> arrayInc;
    BeanExpandableIncomeHeaderDetail headerName;

//
    public AdapterExpandableInc(Context context, ArrayList<BeanExpandableIncomeHeaderDetail> headerMonthList
            ,List<String> listDataHeader)
    {
        this._context = context;
        this.headerMonthList = headerMonthList;
        this._listDataHeader = listDataHeader;

    }




    @Override
    public Object getChild(int groupPosition, int childPosititon) {

        ArrayList<BeanExpandableIncomeChildDetail> IncomeCategoryList = headerMonthList.get(groupPosition).getMonthList();
        return IncomeCategoryList.get(childPosititon);


    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;

    }

    @Override
    public View getChildView(int groupPosition,  int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        BeanExpandableIncomeChildDetail detailInfo = (BeanExpandableIncomeChildDetail) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lst_item_income, null);
        }

        TextView txtListChildCategory = (TextView) convertView
                .findViewById(R.id.IncomelblListCategory);

        TextView txtListChildDate = (TextView) convertView
                .findViewById(R.id.IncomelblListDate);

        TextView txtListChildExpense = (TextView) convertView
                .findViewById(R.id.IncomelblListIncome);

        TextView txtListChildID = (TextView) convertView
                .findViewById(R.id.IncomelblListid);


        txtListChildID.setText(detailInfo.getIncomeAmount()+"");
        txtListChildCategory.setText(detailInfo.getIncomeCategoryID().trim());
        txtListChildDate.setText(detailInfo.getIncomeDate().trim());
        txtListChildExpense.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(Double.parseDouble(detailInfo.getIncomeAmount().trim()))));











        return convertView;



//

//      \


    }

    @Override
    public int getChildrenCount(int groupPosition) {

        //Toast.makeText(_context,this._listDataChild.get(this._listDataHeader.get(groupPosition)).size()/3+"----"+this._listDataChild.get(this._listDataHeader.get(groupPosition)).size(),Toast.LENGTH_SHORT).show();
//     return this._listDataChild.size();
//
        ArrayList<BeanExpandableIncomeChildDetail> monthList = headerMonthList.get(groupPosition).getMonthList();
        return monthList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //return _listDataHeader.get(groupPosition);
        return headerMonthList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        //return _listDataHeader.size();
        return headerMonthList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);

        BeanExpandableIncomeHeaderDetail headerInfo = (BeanExpandableIncomeHeaderDetail) getGroup(groupPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lst_grp_income, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerInfo.getName().trim());



        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);

    }


}

