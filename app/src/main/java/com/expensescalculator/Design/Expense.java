package com.expensescalculator.Design;

/**
 * Created by krishna on 16/01/2019.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.expensescalculator.Adapter.AdapterExpandableExp;
import com.expensescalculator.Bean.BeanExpChild;
import com.expensescalculator.Bean.BeanExpandableChildDetail;
import com.expensescalculator.Bean.BeanExpandableHeaderDetail;
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.DBhelper.DB_Month;
import com.expensescalculator.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Expense extends Fragment {

    ExpandableListAdapter listAdapter;
    private AdapterExpandableExp expandablAdapter;
    ExpandableListView expListView;

//    ListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    ArrayList<BeanExpense> arrayDistinctMonth;
    ArrayList<BeanExpense> arrayAllExpense;
    DB_Expense dbe;
    DB_ExpenseCategory dbec;
    DB_Month dbm;
    BeanExpense be;
    String Month1="";
    ArrayList<BeanExpense> getRecords = new ArrayList<>();
    BeanExpense chilDetail;
    String Month2="";
    String Category="";
    BeanExpChild bec;
    BeanExpChild child;
    String strExpID="";
    ArrayList<BeanExpense> arrayExp;




// New Code References

    private LinkedHashMap<String,BeanExpandableHeaderDetail> myDepartments =
            new LinkedHashMap<String, BeanExpandableHeaderDetail>();

    private ArrayList<BeanExpandableHeaderDetail> ex_deptList
            = new ArrayList<BeanExpandableHeaderDetail>();

    BeanExpandableHeaderDetail ex_headerInfo;
    BeanExpandableChildDetail ex_detailInfo;



    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_expense, container, false);


        expListView = (ExpandableListView) rootview.findViewById(R.id.lvExp);


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        chilDetail = new BeanExpense();

        dbe = new DB_Expense(this.getActivity());
        dbm = new DB_Month(this.getActivity());
        be = new BeanExpense();
        dbec = new DB_ExpenseCategory(this.getActivity());
        expandablAdapter = new AdapterExpandableExp();


        arrayDistinctMonth = new ArrayList<BeanExpense>();


        arrayDistinctMonth=dbe.selectDistinctMonth();
        for(int i=0;i<arrayDistinctMonth.size();i++)
        {

            listDataHeader.add(arrayDistinctMonth.get(i).getExpMonth()+"");
//            ex_headerInfo.setName(arrayDistinctMonth.get(i).getExpMonth()+"");

        }


//        for(int k=0;k<arrayDistinctMonth.size();k++)
//        {
////            Month1=arrayDistinctMonth.get(k).getExpMonth();
////            Month2=dbm.selectById(Month1);
////            arrayAllExpense=dbe.selectAllIExpense(Month1);
//
//            Month1=arrayDistinctMonth.get(k).getExpMonth();
//            arrayAllExpense=dbe.selectAllIExpense(Month1);
//
//            List<String> allExp = new ArrayList<String>();
//            ArrayList<BeanExpChild> childrecord=new ArrayList<BeanExpChild>();
//            ArrayList<BeanExpense> expenses=new ArrayList<BeanExpense>();
//            for(int j=0;j<arrayAllExpense.size();j++)
//            {
//
//                String strCat=arrayAllExpense.get(j).getExpCatID()+"";
//                String strCatName=dbec.selectById(Integer.parseInt(strCat));
//                allExp.add(strCatName);
//                allExp.add(arrayAllExpense.get(j).getExpDate() + "");
//                allExp.add(arrayAllExpense.get(j).getExpExpense() + "");
//                allExp.add(arrayAllExpense.get(j).getExpID()+"");
//
//


//            }


            loadData();
//
//
//
//
            listAdapter=new AdapterExpandableExp(getActivity(),ex_deptList,listDataHeader);
            expListView.setAdapter(listAdapter);

//            getRecords = dbe.getAllRecords();
//            listAdapter = new AdapterExpandableExp(getActivity(), listDataHeader, getRecords,ex_headerInfo );
//            expListView.setAdapter(listAdapter);

//        }






        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

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
                ex_headerInfo = ex_deptList.get(groupPosition);
                //get the child info
                ex_detailInfo = ex_headerInfo.getMonthList().get(childPosition);
                Intent intent=new Intent(getActivity(), ExpenseDetails.class);
                //add data to the Intent object
                intent.putExtra("ExpenseID", ex_detailInfo.getExpenseID());
                //start the second activity
                startActivity(intent);
                return false;
            }
        });

//        expListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
//                    ex_headerInfo = ex_deptList.get(groupPosition);
//                    //get the child info
//                    ex_detailInfo = ex_headerInfo.getMonthList().get(childPosition);
//                    //display it or do something with it
//                    strExpID = ex_detailInfo.getExpenseID();
//                }
//                return false;
//
//            }
//        });




            registerForContextMenu(expListView);
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
//
//
//        String str=menuItem.getTitle().toString();
////
//      if(str.equalsIgnoreCase("Delete")){
////
////          int groupPos = 0, childPos = 0;
////
////          int type = ExpandableListView.getPackedPositionType(info.packedPosition);
////          if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
////              groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
////              childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
////
////          }
////
////          final ArrayList<String> allExp=new ArrayList<String>();
////
////        new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),
////                android.R.style.Theme_Holo_Light_Dialog))
////
////                .setIcon(android.R.drawable.ic_dialog_alert) // icon that you want
////                .setTitle("Confirm") // title of your dialog
////                .setMessage("Are you sure want to delete?") // message of dialog
////                .setPositiveButton("Yes", // String for positive
////                        new DialogInterface.OnClickListener() {
////
////                            @Override
////                            public void onClick(DialogInterface dialog,
////                                                int which) {
////                                // do positive action here
////
////
////                                dbe.deletByID(Integer.parseInt(strExpID));
////                                arrayExp=dbe.getAllRecords();
////
////                                //expListView.setAdapter(new AdapterExpandableExp(getActivity(), listDataHeader, arrayExp,ex_headerInfo));
////                                expListView.setAdapter(new AdapterExpandableExp(getActivity(),ex_deptList,listDataHeader));
////
////                            }
////                        }).setNegativeButton("No", // String for negative action
////                null).show();
////
//
//
//
//          int ex_groupPos = 0, ex_childPos = 0;
//          int type = ExpandableListView.getPackedPositionType(info.packedPosition);
//          if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD)
//          {
//              ex_groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
//              ex_childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
//              ex_headerInfo = ex_deptList.get(ex_groupPos);
//              //get the child ex_info
//              ex_detailInfo = ex_headerInfo.getMonthList().get(ex_childPos);
//              //display it or do something with it
//              strExpID = ex_detailInfo.getExpenseID();
//          }
//          dbe.deletByID(Integer.parseInt(strExpID));
//          ex_headerInfo = ex_deptList.get(ex_groupPos);
//          double ex_updated =Double.parseDouble(ex_deptList.get(ex_groupPos).getTotalAmount()) - Double.parseDouble(ex_headerInfo.getMonthList().get(ex_childPos).getExpenseAmount()) ;
//          //ex_deptList.get(ex_groupPos).setTotalAmount(String.valueOf(ex_updated));
//
//          ex_deptList.get(ex_groupPos).setTotalAmount(String.valueOf(ex_updated));
//          ex_headerInfo.getMonthList().remove(ex_childPos);
//          if(ex_headerInfo.getMonthList().size()==0)
//          {
//              ex_deptList.remove(ex_groupPos);
//          }
//
//          expandablAdapter.notifyDataSetChanged();
//          return true;
//            }
//        if(str.equalsIgnoreCase("Edit"))
//      {
//
////          int groupPos = 0, childPos = 0;
////
////          int type = ExpandableListView.getPackedPositionType(info.packedPosition);
////          if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
////              groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
////              childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
////
////          }
////
////          Intent in=new Intent(getActivity().getApplicationContext() ,EditExpenseActivity.class);
////          in.putExtra("Title","Edit");
////          in.putExtra("ID", strExpID);
////          startActivity(in);
//
//          int ex_groupPos = 0, ex_childPos = 0;
//          int type = ExpandableListView.getPackedPositionType(info.packedPosition);
//          if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD)
//          {
//              ex_groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
//              ex_childPos = ExpandableListView.getPackedPositionChild(info.packedPosition);
//              ex_headerInfo = ex_deptList.get(ex_groupPos);
//              //get the child ex_info
//              ex_detailInfo = ex_headerInfo.getMonthList().get(ex_childPos);
//              //display it or do something with it
//                strExpID=  ex_detailInfo.getExpenseID();
//
//              Intent in=new Intent(getActivity().getApplicationContext() ,EditExpenseActivity.class);
//          in.putExtra("Title","Edit");
//          in.putExtra("ID", strExpID);
//          startActivity(in);
//
//          }
//
//          return true;
//
//
//      }
//
//        return super.onContextItemSelected(menuItem);
//    }


//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//
//        String str=item.getTitle().toString();
//        if(str.equalsIgnoreCase("Edit"))
//        {
//            Intent in=new Intent(getActivity(),EditExpenseActivity.class);
//            in.putExtra("Title","Edit");
//            in.putExtra("ID",strExpID);
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
//                                    dbe.deletByID(Integer.parseInt(strExpID));
//                                    arrayExp=dbe.getAllRecords();
//                                    expListView.setAdapter(new AdapterExpandableExp(getActivity(), ex_deptList, listDataHeader));
//                                    Intent in =new Intent(getActivity(),Expense.class);
//                                    startActivity(in);
//
//                                   // expandablAdapter.notifyDataSetChanged();
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

    //load some initial data into out list
    public void loadData(){
        ArrayList<BeanExpense> beanExpensesAllDetail = dbe.getAllRecords();
        int i = beanExpensesAllDetail.size();

        for (int loop = i-1; loop>=0; loop--)
        {
            addProduct(beanExpensesAllDetail.get(loop).getExpMonth(),
                    beanExpensesAllDetail.get(loop).getExpCategory(),
                    beanExpensesAllDetail.get(loop).getExpDate(),
                    beanExpensesAllDetail.get(loop).getExpExpense(),
                    beanExpensesAllDetail.get(loop).getExpID());

        }
    }




    private int addProduct(String monthName, String categoryName, String date, String amount,Integer expenseID){
        int groupPosition = 0;


        //check the hash map if the group already exists
        BeanExpandableHeaderDetail ex_headerInfo = myDepartments.get(monthName);

        //add the group if doesn't exists
        if(ex_headerInfo == null){
            ex_headerInfo = new BeanExpandableHeaderDetail();
            ex_headerInfo.setName(monthName);
            ex_headerInfo.setTotalAmount(amount);
            myDepartments.put(monthName, ex_headerInfo);
            myDepartments.put(amount, ex_headerInfo);
            ex_deptList.add(ex_headerInfo);
        }
        //get the children for the group
        ArrayList<BeanExpandableChildDetail> monthList = ex_headerInfo.getMonthList();
        //size of the children list
        int listSize = monthList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        BeanExpandableChildDetail ex_detailInfo = new BeanExpandableChildDetail();
        ex_detailInfo.setExpenseID(String.valueOf(expenseID));
        ex_detailInfo.setExpenseCategoryID(categoryName);
        ex_detailInfo.setExpenseDate(date);
        ex_detailInfo.setExpenseAmount(amount);
        monthList.add(ex_detailInfo);
        ex_headerInfo.setMonthList(monthList);

        //find the group position inside the list
        groupPosition = ex_deptList.indexOf(ex_headerInfo);
        return groupPosition;
    }
}




