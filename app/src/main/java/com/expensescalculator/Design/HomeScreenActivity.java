package com.expensescalculator.Design;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_Month;
import com.expensescalculator.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class HomeScreenActivity extends AppCompatActivity {

    Button btnAddIncome;
    Button AddExpense;
    Button btnHistory;
    TextView tvIncome;
    TextView tvExpense;
    TextView tvSaving;

    BeanIncome bi;
    BeanExpense be;
    DB_Income dbi;
    DB_Expense dbe;
    DB_Month dbm;

    int IncMonth=0,TotalExp=0,TotalSav=0 ,curMonth=0,TotalInc=0;
    String curMonthName="", allmonthname="";
    ArrayList<BeanExpense> TotalExpense;
    BeanExpense totalExpense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnAddIncome=(Button)findViewById(R.id.homescreen_btn_addincome);
        AddExpense=(Button)findViewById(R.id.homescreen_btn_addexpense);
        btnHistory=(Button)findViewById(R.id.homescreen_btn_history);
//
        tvIncome=(TextView) findViewById(R.id.homescreen_tv_income_amount);
        tvExpense=(TextView) findViewById(R.id.homescreen_tv_expense_amount);
        tvSaving=(TextView) findViewById(R.id.homescreen_tv_saving_amount);

        bi=new BeanIncome();
        be=new BeanExpense();
        dbe=new DB_Expense(this);
        dbi=new DB_Income(this);
        dbm=new DB_Month(this);
        totalExpense=new BeanExpense();


//        totalExpense=dbe.gettotalExpense();
//        tvExpense.setText(totalExpense.getExpTotalExpense());


        TotalInc=dbi.gettotalIncome();
        tvIncome.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(TotalInc)));

        TotalExp=dbe.gettotalExpense();
        tvExpense.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(TotalExp)));

        TotalSav=TotalInc-TotalExp;
        tvSaving.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(TotalSav)));


        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, AddIncomeActivity.class);
                startActivity(intent);
            }
        });

        AddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScreenActivity.this,AddExpenseActivity.class);
                startActivity(intent);
            }
        });

       btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScreenActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
