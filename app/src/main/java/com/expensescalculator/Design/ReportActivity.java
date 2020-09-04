package com.expensescalculator.Design;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.expensescalculator.Adapter.AdapterDisplayAllIncome;
import com.expensescalculator.Adapter.AdapterExpandableExp;
import com.expensescalculator.Adapter.AdapterIncCategory;
import com.expensescalculator.Adapter.AdapterMonthSpinner;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.Bean.BeanMonth;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_IncomeCategory;
import com.expensescalculator.DBhelper.DB_Month;
import com.expensescalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportActivity extends AppCompatActivity {


    Spinner spMonth;
    ArrayList<BeanMonth> arrayMonth;
    DB_Month dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);



        spMonth=(Spinner) findViewById(R.id.report_sp_month);
        dbm=new DB_Month(this);

        arrayMonth=dbm.selectAllMonth();
        spMonth.setAdapter(new AdapterMonthSpinner(this,arrayMonth));





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
