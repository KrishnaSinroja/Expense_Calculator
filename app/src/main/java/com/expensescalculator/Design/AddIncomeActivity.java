package com.expensescalculator.Design;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.expensescalculator.Adapter.AdapterExpCategory;
import com.expensescalculator.Adapter.AdapterIncCategory;
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_IncomeCategory;
import com.expensescalculator.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddIncomeActivity extends ActionBarActivity {

    EditText edDate;
    EditText edIncome;
    Spinner spCategory;
    EditText edPayer;
    EditText edDiscription;
    Button  btnAdd;
    Button btnCancel;

    private DatePickerDialog birthDatePickerDialog;
    private SimpleDateFormat dateFormatter;

     DB_Income dbi;
    DB_Expense dbe;

    DB_IncomeCategory dbic;
    ArrayList<BeanIncomeCategory> arrayIncCategory;
    BeanIncome binc;
    BeanExpense be;
//    String catName;
//    int strIncCat=1;

    String Syear;
    String Smonth;
    String Sday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

          dbi=new DB_Income(this);
        dbic=new DB_IncomeCategory(this);
        binc=new BeanIncome();
        be=new BeanExpense();
        dbe=new DB_Expense(this);


        edDate=(EditText)findViewById(R.id.addincome_ed_Date);
        edIncome=(EditText)findViewById(R.id.addincome_ed_Income);
        edDiscription=(EditText)findViewById(R.id.addincome_ed_Discription);
        spCategory=(Spinner)findViewById(R.id.addincome_sp_Category);
        edPayer=(EditText)findViewById(R.id.addincome_ed_payer);
        btnAdd=(Button)findViewById(R.id.addincome_btn_add);
        btnCancel=(Button)findViewById(R.id.addincome_btn_Cancel);

        arrayIncCategory=dbic.selectAllIncCat();
        spCategory.setAdapter(new AdapterIncCategory(this, arrayIncCategory));


        setDateTimeField();

        edDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                birthDatePickerDialog.show();
                //setDateTimeField();
                return false;
            }
        });

        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BeanIncome bi=new BeanIncome();
                int flag=0;

                if(edDate.getText().length()>0)
                {
                    bi.setIncDate(edDate.getText().toString());
                    bi.setIncDay(Sday);
                    bi.setIncYear(Syear);
                    String MonthName=dbi.getMonthName(Smonth);
                    bi.setIncMonth(MonthName);
                }
                else
                {
                    flag=1;
                    edDate.setError("Select Date");
                }

                if(edIncome.getText().length()>0)
                {
                    bi.setIncIncome(edIncome.getText().toString());
                }
                else
                {
                    flag=1;
                    edIncome.setError("Enter Income");
                }

                bi.setIncCatID(spCategory.getSelectedItemPosition() + 1);

                if(edPayer.getText().length()>0)
                {
                    bi.setIncPayer(edPayer.getText().toString());
                }

                if(edDiscription.getText().length()>0)
                {
                    bi.setIncDiscription(edDiscription.getText().toString());
                }


                if(flag==0)
                {
                    dbi.insertIncome(bi);
                    Toast.makeText(getApplicationContext(),"Record Inserted Successfully",Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(),"Data"+bi.getIncCategory()+bi.getIncDate()+bi.getIncIncome()+bi.getIncDiscription()+bi.getIncPayer(),Toast.LENGTH_LONG).show();
                    clearData();
                    Intent intent=new Intent(AddIncomeActivity.this,HomeScreenActivity.class);
                    startActivity(intent);

                    //Toast.makeText(getApplicationContext(),bi.getIncDate()+"==="+bi.getIncIncome(),Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
                Intent intent=new Intent(AddIncomeActivity.this,HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    void clearData() {
        edDate.setText("");
        edIncome.setText("");
        edDiscription.setText("");
        spCategory.setSelection(0);
        edPayer.setText("");

    }


    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        birthDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                Syear = String.valueOf(year);
                Smonth = String.valueOf(monthOfYear+1);
                Sday = String.valueOf(dayOfMonth);
                edDate.setText(dateFormatter.format(newDate.getTime()));


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_income, menu);
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
