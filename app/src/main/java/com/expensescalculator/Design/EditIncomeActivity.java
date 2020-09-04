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
import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.Bean.BeanIncomeCategory;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_IncomeCategory;
import com.expensescalculator.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class EditIncomeActivity extends ActionBarActivity {


    EditText edDate;
    EditText edIncome;
    Spinner spIncCategory;
    EditText edPayer;
    EditText edDiscription;
    Button btnAdd;
    Button btnCancel;

    private DatePickerDialog birthDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    DB_Income dbi;
    DB_IncomeCategory dbic;
    ArrayList<BeanIncomeCategory> arrayIncCategory ;
    BeanIncomeCategory bic;
    BeanIncome binc;
    int strIncCat=1;

    String Syear;
    String Smonth;
    String Sday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_income);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        dbi=new DB_Income(this);
        dbic=new DB_IncomeCategory(this);
        bic=new BeanIncomeCategory();
//        be=new BeanExpense();
        binc=new BeanIncome();


        edDate=(EditText)findViewById(R.id.editincome_ed_date);
        edIncome=(EditText)findViewById(R.id.editincome_ed_income);
        edDiscription=(EditText)findViewById(R.id.editincome_ed_discription);
        spIncCategory=(Spinner)findViewById(R.id.editincome_sp_Category);
        edPayer=(EditText)findViewById(R.id.editincome_ed_payer);
        btnAdd=(Button)findViewById(R.id.editincome_btn_add);
        btnCancel=(Button)findViewById(R.id.editincome_btn_cancel);

        setDateTimeField();

        arrayIncCategory=dbic.selectAllIncCat();
        spIncCategory.setAdapter(new AdapterIncCategory(this, arrayIncCategory));



        String strIncID = getIntent().getStringExtra("IncomeID");



        binc = dbi.selectByID(Integer.parseInt(strIncID));
        edDate.setText(binc.getIncDate());
        edIncome.setText(binc.getIncIncome());
        spIncCategory.setSelection(binc.getIncCatID()-1);
        edPayer.setText(binc.getIncPayer());
        edDiscription.setText(binc.getIncDiscription());
        btnAdd.setText("Update");


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


                BeanIncome bi = new BeanIncome();
                int flag = 0;

                bi.setIncCatID(spIncCategory.getSelectedItemPosition() + 1);


                if (edDate.getText().length() > 0) {
                    bi.setIncDate(edDate.getText().toString());
                    bi.setIncDay(Sday);
                    bi.setIncYear(Syear);
                    String MonthName = dbi.getMonthName(Smonth);
                    bi.setIncMonth(MonthName);

                } else {
                    flag = 1;
                    edDate.setError("Select Date");
                }

                if (edIncome.getText().length() > 0) {
                    bi.setIncIncome(edIncome.getText().toString());
                } else {
                    flag = 1;
                    edIncome.setError("Enter Income");
                }

                bi.setIncCategory(spIncCategory.getSelectedItem().toString());

                if (edPayer.getText().length() > 0) {
                    bi.setIncPayer(edPayer.getText().toString());
                } else {
                    flag = 1;
                    edPayer.setError("Enter Payee Details");
                }

                if (edDiscription.getText().length() > 0) {
                    bi.setIncDiscription(edDiscription.getText().toString());
                }


                if (flag == 0) {


                    bi.setIncID(binc.getIncID());
                    dbi.updateData(bi);
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    Intent in =new Intent(EditIncomeActivity.this,HistoryActivity.class);
                    startActivity(in);
                    finish();

                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
                Intent intent=new Intent(EditIncomeActivity.this,HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }


    void clearData() {
        edDate.setText("");
        edIncome.setText("");
        edDiscription.setText("");
        spIncCategory.setSelection(0);
        edPayer.setText("");

    }


    private void setDateTimeField() {

        final String month;
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







}
