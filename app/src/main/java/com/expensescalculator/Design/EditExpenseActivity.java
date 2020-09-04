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
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanExpenseCategory;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class EditExpenseActivity extends ActionBarActivity {

    EditText edDate;
    EditText edExpense;
    Spinner spExpCategory;
    EditText edPayee;
    EditText edDiscription;
    Button btnAdd;
    Button btnCancel;

    private DatePickerDialog birthDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    DB_Expense dbe;
    DB_ExpenseCategory dbec;
    ArrayList<BeanExpenseCategory> arrayExpCategory ;
    BeanExpenseCategory bec;
    BeanExpense bexp;
    int strExpCat=1;

    String Syear;
    String Smonth;
    String Sday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expense);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        dbe=new DB_Expense(this);
        dbec=new DB_ExpenseCategory(this);
        bec=new BeanExpenseCategory();
//        be=new BeanExpense();
        bexp=new BeanExpense();


        edDate=(EditText)findViewById(R.id.editexpense_ed_date);
        edExpense=(EditText)findViewById(R.id.editexpense_ed_expense);
        edDiscription=(EditText)findViewById(R.id.editexpense_ed_discription);
        spExpCategory=(Spinner)findViewById(R.id.editexpense_sp_Category);
        edPayee=(EditText)findViewById(R.id.editexpense_ed_payee);
        btnAdd=(Button)findViewById(R.id.editexpense_btn_add);
        btnCancel=(Button)findViewById(R.id.editexpense_btn_cancel);

        setDateTimeField();

        arrayExpCategory=dbec.selectAllExpCat();
        spExpCategory.setAdapter(new AdapterExpCategory(this, arrayExpCategory));



            String strExpID = getIntent().getStringExtra("ExpenseID");



            bexp = dbe.selectByID(Integer.parseInt(strExpID));
            edDate.setText(bexp.getExpDate());
            edExpense.setText(bexp.getExpExpense());
            spExpCategory.setSelection(bexp.getExpCatID()-1);
            edPayee.setText(bexp.getExpPayee());
            edDiscription.setText(bexp.getExpDiscription());
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


                BeanExpense be = new BeanExpense();
                int flag = 0;

                be.setExpCatID(spExpCategory.getSelectedItemPosition() + 1);


                if (edDate.getText().length() > 0) {
                    be.setExpDate(edDate.getText().toString());
                    be.setExpDay(Sday);
                    be.setExpYear(Syear);
                    String MonthName = dbe.getMonthName(Smonth);
                    be.setExpMonth(MonthName);

                } else {
                    flag = 1;
                    edDate.setError("Select Date");
                }

                if (edExpense.getText().length() > 0) {
                    be.setExpExpense(edExpense.getText().toString());
                } else {
                    flag = 1;
                    edExpense.setError("Enter Expense");
                }

                be.setExpCategory(spExpCategory.getSelectedItem().toString());

                if (edPayee.getText().length() > 0) {
                    be.setExpPayee(edPayee.getText().toString());
                } else {
                    flag = 1;
                    edPayee.setError("Enter Payee Details");
                }

                if (edDiscription.getText().length() > 0) {
                    be.setExpDiscription(edDiscription.getText().toString());
                }


                if (flag == 0) {


                        be.setExpID(bexp.getExpID());
                        dbe.updateData(be);
                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                        Intent in =new Intent(EditExpenseActivity.this,HistoryActivity.class);
                        startActivity(in);
                        finish();

                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
                Intent intent=new Intent(EditExpenseActivity.this,HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }


    void clearData() {
        edDate.setText("");
        edExpense.setText("");
        edDiscription.setText("");
        spExpCategory.setSelection(0);
        edPayee.setText("");

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
