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
        import com.expensescalculator.Bean.BeanExpense;
        import com.expensescalculator.R;

        import java.text.NumberFormat;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

/**
 * Created by krishna on 22/01/2019.
 */
public class AdapterExpandableExp extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private ArrayList<BeanExpense> _listDataChild;
    private List<String> allExp;
    //private List<String> allExpData;
    ArrayList<BeanExpense> arrayAllExpense;

    BeanExpense be=new BeanExpense();;
    private ArrayList<BeanExpandableHeaderDetail> headerMonthList;

    String strdemo;
    ArrayList<BeanExpense> arrayExp;
    BeanExpandableHeaderDetail headerName;

//    Old Constructor
//
//    public AdapterExpandableExp(Context context, List<String> listDataHeader,
//                                ArrayList<BeanExpense> listChildData, BeanExpandableHeaderDetail headerName ) {
//        this._context = context;
//        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
//        this.headerName=headerName;
//        this.allExp=allExp;
//
//
//
//    }

//    New Constructor
//

        public AdapterExpandableExp(Context context, ArrayList<BeanExpandableHeaderDetail> headerMonthList,List<String> listDataHeader)
        {
            this._context = context;
            this.headerMonthList = headerMonthList;
            this._listDataHeader = listDataHeader;

    }

    public AdapterExpandableExp() {

    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {

        ArrayList<BeanExpandableChildDetail> ExpenseCategoryList = headerMonthList.get(groupPosition).getMonthList();
        return ExpenseCategoryList.get(childPosititon);


    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;

    }

    @Override
    public View getChildView(int groupPosition,  int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        BeanExpandableChildDetail detailInfo = (BeanExpandableChildDetail) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lst_item_expense, null);
        }

        TextView txtListChildCategory = (TextView) convertView
                .findViewById(R.id.lblListCategory);

        TextView txtListChildDate = (TextView) convertView
                .findViewById(R.id.lblListDate);

        TextView txtListChildExpense = (TextView) convertView
                .findViewById(R.id.lblListExpense);

        TextView txtListChildID = (TextView) convertView
                .findViewById(R.id.lblListid);


            txtListChildID.setText(detailInfo.getExpenseAmount()+"");
            txtListChildCategory.setText(detailInfo.getExpenseCategoryID().trim());
            txtListChildDate.setText(detailInfo.getExpenseDate().trim());
            txtListChildExpense.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                    .format(Double.parseDouble(detailInfo.getExpenseAmount().trim()))));










            Log.v("-------------->>",_listDataHeader.get(groupPosition));

//       Old Code to set value in child item



//        txtListChildID.setText(bexp.getExpID());
//        txtListChildCategory.setText(bexp.getExpCategory());
//        txtListChildDate.setText(bexp.getExpDate());
//        txtListChildExpense.setText(bexp.getExpExpense());

//                if(_listDataChild.get(childPosition).getExpMonth().equals(_listDataHeader.get(groupPosition))) {
//
//                    txtListChildID.setText(Integer.toString(_listDataChild.get(childPosition).getExpID()));
//                    txtListChildCategory.setText(_listDataChild.get(childPosition).getExpCategory());
//                    txtListChildDate.setText(_listDataChild.get(childPosition).getExpDate());
//                    txtListChildExpense.setText(_listDataChild.get(childPosition).getExpExpense());
//                }


//                for(int i=0;i<_listDataChild.size();i++)
//                {
//                    if(_listDataChild.get(childPosition).getExpMonth().equals(_listDataHeader.get(groupPosition))) {
//
//                        txtListChildCategory.setText(_listDataChild.get(childPosition).getExpCategory());
//                        txtListChildDate.setText(_listDataChild.get(childPosition).getExpDate());
//                        txtListChildExpense.setText(_listDataChild.get(childPosition).getExpExpense());
//                    }
//
//                }




//        Set<Map.Entry<String, ArrayList<String>>> setMap = _listDataChild.entrySet();
//        // Get an iterator
//        Iterator<Map.Entry<String,  ArrayList<String>>> iteratorMap = setMap.iterator();
//
//
//       //System.out.println("\nHashMap with Multiple Values");
//        // display all the elements
//
//        while(iteratorMap.hasNext()) {
//            Map.Entry<String, ArrayList<String>> entry =
//                    (Map.Entry<String, ArrayList<String>>) iteratorMap.next();
//
//            String key = entry.getKey();
//            List<String> values = entry.getValue();
//            // System.out.println("Key = '" + key + "' has values: " + values);
//
//
//
//            int k=childPosition=0;
//
//            for(int i=0;i<values.size();i++)
//            {
////
//                for(int j=0;j<_listDataHeader.size();j++)
//                {
//                    String header=_listDataHeader.get(j);
//                    if(header.equals(key))
//                    {
//                        txtListChildCategory.setText(be.getExpCategory());
//                        txtListChildDate.setText(values.get(i+1));
//                        txtListChildExpense.setText(values.get(i+2));
//                        childPosition++;
//
//                    }
//                }
//            }
//        }
//
//





//                    for(int i=0;i<values.size();i+=3) {
//                        txtListChildCategory.setText(values.get(i));
//                        txtListChildDate.setText(values.get(i + 1));
//                        txtListChildExpense.setText(values.get(i + 2));
//                    }
//                    int j=0;
//                    for(int i=0;i<values.size();i+=3)
//                    {
//
//                        while (j<_listDataHeader.size())
//                        {
//                            if(_listDataHeader.get(j)==key)
//                            {
//
//
//                                txtListChildCategory.setText(getChild(1,0)+values.get(i));
//                                txtListChildDate.setText(getChild(1,0)+values.get(i+1));
//                                txtListChildExpense.setText(getChild(1,0)+values.get(i+2));
//
//                                j++;
//                            }
//                            j++;
//                        }
//
//                    }

//                if(_listDataHeader.get(0)==key)



        return convertView;



//

//      \


    }

    @Override
    public int getChildrenCount(int groupPosition) {

        //Toast.makeText(_context,this._listDataChild.get(this._listDataHeader.get(groupPosition)).size()/3+"----"+this._listDataChild.get(this._listDataHeader.get(groupPosition)).size(),Toast.LENGTH_SHORT).show();
//     return this._listDataChild.size();
//
        ArrayList<BeanExpandableChildDetail> monthList = headerMonthList.get(groupPosition).getMonthList();
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

        BeanExpandableHeaderDetail headerInfo = (BeanExpandableHeaderDetail) getGroup(groupPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lst_grp_expense, null);
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
