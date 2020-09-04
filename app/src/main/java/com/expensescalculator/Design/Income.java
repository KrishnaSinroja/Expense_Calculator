package com.expensescalculator.Design;

/**
 * Created by krishna on 16/01/2019.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.expensescalculator.Adapter.AdapterExpandableExp;
import com.expensescalculator.Adapter.AdapterExpandableInc;

import com.expensescalculator.Bean.BeanExpChild;
import com.expensescalculator.Bean.BeanExpandableChildDetail;
import com.expensescalculator.Bean.BeanExpandableHeaderDetail;
import com.expensescalculator.Bean.BeanExpandableIncomeChildDetail;
import com.expensescalculator.Bean.BeanExpandableIncomeHeaderDetail;
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_IncomeCategory;
import com.expensescalculator.DBhelper.DB_Month;
import com.expensescalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Income extends Fragment {

////    ExpandableListAdapter listAdapter;
////    ExpandableListView incListView;
////    //    ListView expListView;
////    List<String> listDataHeader;
////    ArrayList<BeanIncome> listDataChild;
////
////    ArrayList<BeanIncome> getRecords = new ArrayList<>();
////    ArrayList<BeanIncome> arrayDistinctMonth;
////    ArrayList<BeanIncome> arrayAllIncome;
////    DB_Income dbi;
////    DB_IncomeCategory dbic;
////    BeanIncome bi;
////    String Month1="";
////    String Category="";
////
////
////    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
////        View rootview=inflater.inflate(R.layout.activity_expense,container,false);
////
////        // get the listview
////        incListView = (ExpandableListView) rootview.findViewById(R.id.lvExp);
////
////        // preparing list data
////        //prepareListData();
////        listDataHeader = new ArrayList<String>();
////        listDataChild = new ArrayList<BeanIncome>();
////
////        dbi=new DB_Income(this.getActivity());
////        bi=new BeanIncome();
////        dbic=new DB_IncomeCategory(this.getActivity());
////        arrayDistinctMonth=new ArrayList<BeanIncome>();
////
////
////
////
////
////
////        arrayDistinctMonth=dbi.selectDistinctMonth();
////        for(int i=0;i<arrayDistinctMonth.size();i++)
////        {
////            listDataHeader.add(arrayDistinctMonth.get(i).getIncMonth()+"");
////            //listDataHeader.add(arrayDistinctMonth.get(1).getExpMonth()+"");
////        }
////
////
////        for(int k=0;k<arrayDistinctMonth.size();k++)
////        {
////            Month1=arrayDistinctMonth.get(k).getIncMonth();
////            arrayAllIncome=dbi.selectAllIIncome(Month1);
////
////            List<String> allInc = new ArrayList<String>();
////            for(int j=0;j<arrayAllIncome.size();j++)
////            {
////
////                String strCat=arrayAllIncome.get(j).getIncCatID()+"";
////                String strCatName=dbic.selectById(Integer.parseInt(strCat));
////                allInc.add(strCatName);
////                allInc.add(arrayAllIncome.get(j).getIncDate()+"");
////                allInc.add(arrayAllIncome.get(j).getIncIncome()+"");
////
//////
////            }
////            getRecords = dbi.getAllRecords();
////            listAdapter = new AdapterExpandableInc(getActivity(), listDataHeader, getRecords ,allInc);
////            incListView.setAdapter(listAdapter);
////        }
////
////        return rootview;
////
////
////    }
//
//    ExpandableListAdapter listAdapter;
//    ExpandableListView expListView;
//    //    ListView expListView;
//    List<String> listDataHeader;
//    HashMap<String, List<String>> listDataChild;
//
//    String Month1="";
//    ArrayList<BeanIncome> arrayDistinctMonth;
//    ArrayList<BeanIncome> arrayAllIncome;
//    DB_Income dbi;
//    DB_IncomeCategory dbic;
//    DB_Month dbm;
//    BeanIncome bi;
//
//    ArrayList<BeanIncome> getRecords = new ArrayList<>();
//
//
//    String strIncID="";
//    ArrayList<BeanIncome> arrayInc;
//
//
////
////
//
//
//    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootview=inflater.inflate(R.layout.activity_expense,container,false);
//
//
//        expListView = (ExpandableListView) rootview.findViewById(R.id.lvExp);
//
//
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//
//        dbi=new DB_Income(this.getActivity());
//        dbm =new DB_Month(this.getActivity());
//        bi=new BeanIncome();
//        dbic=new DB_IncomeCategory(this.getActivity());
//
//        arrayDistinctMonth=new ArrayList<BeanIncome>();
//        ArrayList<BeanIncome> li = new ArrayList<>();
//
//        DB_Income d = new DB_Income(container.getContext());
//        li = d.selectAllIIncome("March");
//        Log.v("", "DBEXPSize-->" + li.size());
//
//
//
//
//        arrayDistinctMonth=dbi.selectDistinctMonth();
//        for(int i=0;i<arrayDistinctMonth.size();i++)
//        {
//
//            listDataHeader.add(arrayDistinctMonth.get(i).getIncMonth()+"");
//
//        }
//
//        for(int k=0;k<arrayDistinctMonth.size();k++)
//        {
////            Month1=arrayDistinctMonth.get(k).getExpMonth();
////            Month2=dbm.selectById(Month1);
////            arrayAllExpense=dbe.selectAllIExpense(Month1);
//
//            Month1=arrayDistinctMonth.get(k).getIncMonth();
//            arrayAllIncome=dbi.selectAllIIncome(Month1);
//
//            List<String> allInc = new ArrayList<String>();
//
//            for(int j=0;j<arrayAllIncome.size();j++)
//            {
//
//                String strCat=arrayAllIncome.get(j).getIncCatID()+"";
//                String strCatName=dbic.selectById(Integer.parseInt(strCat));
//                allInc.add(strCatName);
//                allInc.add(arrayAllIncome.get(j).getIncDate() + "");
//                allInc.add(arrayAllIncome.get(j).getIncIncome() + "");
//                allInc.add(arrayAllIncome.get(j).getIncID()+"");
//
//
//            }
//
//
//            getRecords = dbi.getAllRecords();
//            listAdapter = new AdapterExpandableInc(getActivity(), listDataHeader, getRecords ,allInc);
//            expListView.setAdapter(listAdapter);
//
//        }
//
//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                //Toast.makeText(getActivity().getApplicationContext(),"Child Is Clikced",Toast.LENGTH_SHORT).show();
//
//                String incid = ((TextView) v.findViewById(R.id.IncomelblListid)).getText().toString();
//                Intent intent=new Intent(getActivity(),IncomeDetails.class);
//                intent.putExtra("IncID", incid);
//                startActivity(intent);
//
//                return false;
//            }
//        });
//
//        expListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                strIncID = ((TextView) view.findViewById(R.id.IncomelblListid)).getText().toString();
//                return false;
//            }
//        });
//
//
//        registerForContextMenu(expListView);
//        return rootview;
//
////
////
//    }
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo)
//    {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//        ExpandableListView.ExpandableListContextMenuInfo info =
//                (ExpandableListView.ExpandableListContextMenuInfo) menuInfo;
//
//        int type =
//                ExpandableListView.getPackedPositionType(info.packedPosition);
//
//        int group =
//                ExpandableListView.getPackedPositionGroup(info.packedPosition);
//
//        int child =
//                ExpandableListView.getPackedPositionChild(info.packedPosition);
//
//        // Only create a context menu for child items
//        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD)
//        {
//            // Array created earlier when we built the expandable list
//
//            menu.add("Delete");
//            menu.add("Edit");
//
//        }
//    }
//
//    public boolean onContextItemSelected(MenuItem menuItem)
//    {
//        ExpandableListView.ExpandableListContextMenuInfo info =
//                (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();
//
//        int groupPos = 0, childPos = 0;
//
//        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
//        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
//            groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
//            childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
//
//        }
//
//        String str=menuItem.getTitle().toString();
////
//        if(str.equalsIgnoreCase("Delete")){
//            final ArrayList<String> allInc=new ArrayList<String>();
//
//            new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),
//                    android.R.style.Theme_Holo_Light_Dialog))
//
//                    .setIcon(android.R.drawable.ic_dialog_alert) // icon that you want
//                    .setTitle("Confirm") // title of your dialog
//                    .setMessage("Are you sure want to delete?") // message of dialog.setPositiveButton("Yes", // String for positive
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // do positive action here
//                                    dbi.deletByID(Integer.parseInt(strIncID));
//                                    arrayInc=dbi.getAllRecords();
//                                    expListView.setAdapter(new AdapterExpandableInc(getActivity(), listDataHeader, arrayInc ,allInc));
//
//                                }
//                            }).setNegativeButton("No", // String for negative action
//                    null).show();
//
//
//
//        }
//        else
//        {
//            Intent in=new Intent(getActivity().getApplicationContext() ,EditIncomeActivity.class);
//            in.putExtra("Title","Edit");
//            in.putExtra("ID",strIncID);
//            startActivity(in);
//        }
//
//
//
//
//        return super.onContextItemSelected(menuItem);
//    }

//    New Income Tab Code starts from here


    ExpandableListAdapter listAdapter;
    ExpandableListView incListView;

    //    ListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    ArrayList<BeanIncome> arrayDistinctMonth;
    ArrayList<BeanIncome> arrayAllIncome;
    DB_Income dbi;
    DB_IncomeCategory dbic;
    DB_Month dbm;
    BeanIncome bi;
    String Month1="";
    ArrayList<BeanIncome> getRecords = new ArrayList<>();
    BeanIncome chilDetail;
    String Month2="";
    String Category="";
    String strIncID="";
    ArrayList<BeanIncome> arrayInc;



// New Code References

    private LinkedHashMap<String,BeanExpandableIncomeHeaderDetail> myDepartments =
            new LinkedHashMap<String, BeanExpandableIncomeHeaderDetail>();

    private ArrayList<BeanExpandableIncomeHeaderDetail> in_deptList
            = new ArrayList<BeanExpandableIncomeHeaderDetail>();

    BeanExpandableIncomeHeaderDetail in_headerInfo;
    BeanExpandableIncomeChildDetail in_detailInfo;



    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.activity_expense,container,false);

        incListView = (ExpandableListView) rootview.findViewById(R.id.lvExp);


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        chilDetail=new BeanIncome();

        dbi=new DB_Income(this.getActivity());
        dbm =new DB_Month(this.getActivity());
        bi=new BeanIncome();
        dbic=new DB_IncomeCategory(this.getActivity());

        arrayDistinctMonth=new ArrayList<BeanIncome>();


        arrayDistinctMonth=dbi.selectDistinctMonth();
        for(int i=0;i<arrayDistinctMonth.size();i++)
        {

            listDataHeader.add(arrayDistinctMonth.get(i).getIncMonth()+"");
//            ex_headerInfo.setName(arrayDistinctMonth.get(i).getExpMonth()+"");

        }
        loadData();
//
        listAdapter=new AdapterExpandableInc(getActivity(),in_deptList,listDataHeader);
        incListView.setAdapter(listAdapter);

//            getRecords = dbe.getAllRecords();
//            listAdapter = new AdapterExpandableExp(getActivity(), listDataHeader, getRecords,ex_headerInfo );
//            expListView.setAdapter(listAdapter);

//        }




        incListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //Toast.makeText(getActivity().getApplicationContext(),"Child Is Clikced",Toast.LENGTH_SHORT).show();
//
//                String expid = ((TextView) v.findViewById(R.id.lblListid)).getText().toString();
//                Intent intent=new Intent(getActivity(),ExpenseDetails.class);
//                intent.putExtra("ExpID", expid);
//                startActivity(intent);

                //get the group header
                in_headerInfo = in_deptList.get(groupPosition);
                //get the child info
                in_detailInfo = in_headerInfo.getMonthList().get(childPosition);
                Intent intent=new Intent(getActivity(), IncomeDetails.class);
                //add data to the Intent object
                intent.putExtra("IncomeID", in_detailInfo.getIncomeID());
                //start the second activity
                startActivity(intent);
                return false;
            }
        });

//        incListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
////                strExpID = ((TextView) view.findViewById(R.id.lblListid)).getText().toString();
//
//                int itemType = ExpandableListView.getPackedPositionType(id);
//
//                if (itemType == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
//                    int childPosition = ExpandableListView.getPackedPositionChild(id);
//                    int groupPosition = ExpandableListView.getPackedPositionGroup(id);
//
//                    in_headerInfo = in_deptList.get(groupPosition);
//                    //get the child info
//                    in_detailInfo = in_headerInfo.getMonthList().get(childPosition);
//                    //display it or do something with it
//                    strIncID = in_detailInfo.getIncomeID();
//                }
//                return false;
//
//            }
//        });
//



//        registerForContextMenu(incListView);
        return rootview;

//
//
    }
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo)
//    {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//        ExpandableListView.ExpandableListContextMenuInfo info =
//                (ExpandableListView.ExpandableListContextMenuInfo) menuInfo;
//
//        int type =
//                ExpandableListView.getPackedPositionType(info.packedPosition);
//
//        int group =
//                ExpandableListView.getPackedPositionGroup(info.packedPosition);
//
//        int child =
//                ExpandableListView.getPackedPositionChild(info.packedPosition);
//
//        // Only create a context menu for child items
//        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD)
//        {
//            // Array created earlier when we built the expandable list
//
//            menu.add("Delete");
//            menu.add("Edit");
//
//        }
////
////
////
//    }
//
//    public boolean onContextItemSelected(MenuItem menuItem)
//    {
//        ExpandableListView.ExpandableListContextMenuInfo info =
//                (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();
//
//        int groupPos = 0, childPos = 0;
//
//        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
//        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
//            groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
//            childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
//
//        }
//
//        String str=menuItem.getTitle().toString();
////
//        if(str.equalsIgnoreCase("Delete")){
//            final ArrayList<String> allExp=new ArrayList<String>();
//
//            new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),
//                    android.R.style.Theme_Holo_Light_Dialog))
//
//                    .setIcon(android.R.drawable.ic_dialog_alert) // icon that you want
//                    .setTitle("Confirm") // title of your dialog
//                    .setMessage("Are you sure want to delete?") // message of dialog
//                    .setPositiveButton("Yes", // String for positive
//                            new DialogInterface.OnClickListener() {
//
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // do positive action here
//
//
//                                    dbi.deletByID(Integer.parseInt(strIncID));
//                                    arrayInc=dbi.getAllRecords();
//                                    //expListView.setAdapter(new AdapterExpandableExp(getActivity(), listDataHeader, arrayExp,ex_headerInfo));
//                                    incListView.setAdapter(new AdapterExpandableInc(getActivity(),
//                                            in_deptList,listDataHeader));
//                                    Intent in =new Intent(getActivity(),Income.class);
//                                    startActivity(in);
//
//                                }
//                            }).setNegativeButton("No", // String for negative action
//                    null).show();
//
//
//
//        }
//        else
//        {
//            Intent in=new Intent(getActivity().getApplicationContext() ,EditIncomeActivity.class);
//            in.putExtra("Title","Edit");
//            in.putExtra("ID", strIncID);
//            startActivity(in);
//        }
//
//        return super.onContextItemSelected(menuItem);
//    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//
//        String str=item.getTitle().toString();
//        if(str.equalsIgnoreCase("Edit"))
//        {
//            Intent in=new Intent(getActivity(),EditIncomeActivity.class);
//            in.putExtra("Title","Edit");
//            in.putExtra("ID",strIncID);
//            startActivity(in);
//
//        }
//        else
//        {
//
//
//            new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),android.R.style.Theme_Holo_Light_Dialog))
//
//                    .setIcon(android.R.drawable.ic_dialog_alert) // icon that you want
//                    .setTitle("Confirm") // title of your dialog
//                    .setMessage("Are you sure want to delete?") // message of dialog
//                    .setPositiveButton("Yes", // String for positive
//                            new DialogInterface.OnClickListener() {
//
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // do positive action here
//
//
//                                    dbi.deletByID(Integer.parseInt(strIncID));
//                                    arrayInc=dbi.getAllRecords();
//                                    incListView.setAdapter(new AdapterExpandableInc(getActivity(), in_deptList, listDataHeader));
//                                    Intent in =new Intent(getActivity(),Income.class);
//                                    startActivity(in);
//
//                                    // expandablAdapter.notifyDataSetChanged();
//
//
//                                }
//                            }).setNegativeButton("No", // String for negative action
//                    null).show();
//
//
//
//
//
//        }
//        return super.onOptionsItemSelected(item);
//
//
//    }
//



    //load some initial data into out list
    public void loadData(){
        ArrayList<BeanIncome> beanIncomeAllDetail = dbi.getAllRecords();
        int i = beanIncomeAllDetail.size();

        for (int loop = i-1; loop>=0; loop--)
        {
            addProduct(beanIncomeAllDetail.get(loop).getIncMonth(),
                    beanIncomeAllDetail.get(loop).getIncCategory(),
                    beanIncomeAllDetail.get(loop).getIncDate(),
                    beanIncomeAllDetail.get(loop).getIncIncome(),
                    beanIncomeAllDetail.get(loop).getIncID());

        }
    }


    private int addProduct(String monthName, String categoryName, String date, String amount,Integer expenseID){
        int groupPosition = 0;


        //check the hash map if the group already exists
        BeanExpandableIncomeHeaderDetail in_headerInfo = myDepartments.get(monthName);

        //add the group if doesn't exists
        if(in_headerInfo == null){
            in_headerInfo = new BeanExpandableIncomeHeaderDetail();
            in_headerInfo.setName(monthName);
            in_headerInfo.setTotalAmount(amount);
            myDepartments.put(monthName, in_headerInfo);
            myDepartments.put(amount, in_headerInfo);
            in_deptList.add(in_headerInfo);
        }
        //get the children for the group
        ArrayList<BeanExpandableIncomeChildDetail> monthList = in_headerInfo.getMonthList();
        //size of the children list
        int listSize = monthList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        BeanExpandableIncomeChildDetail in_detailInfo = new BeanExpandableIncomeChildDetail();
        in_detailInfo.setIncomeID(String.valueOf(expenseID));
        in_detailInfo.setIncomeCategoryID(categoryName);
        in_detailInfo.setIncomeDate(date);
        in_detailInfo.setIncomeAmount(amount);
        monthList.add(in_detailInfo);
        in_headerInfo.setMonthList(monthList);

        //find the group position inside the list
        groupPosition = in_deptList.indexOf(in_headerInfo);
        return groupPosition;
    }




}