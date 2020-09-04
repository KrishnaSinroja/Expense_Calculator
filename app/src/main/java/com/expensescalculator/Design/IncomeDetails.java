package com.expensescalculator.Design;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.Bean.BeanIncome;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.DBhelper.DB_Income;
import com.expensescalculator.DBhelper.DB_IncomeCategory;
import com.expensescalculator.R;

import java.text.NumberFormat;
import java.util.Locale;

public class IncomeDetails extends ActionBarActivity {

    TextView tvDate;
    TextView tvExpense;
    TextView tvCategory;
    TextView tvPayee;
    TextView tvDescription;


    DB_Income dbi;
    BeanIncome bi;
    DB_IncomeCategory dbic;
double inAmount;

    String incid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_details);


        tvDate=(TextView)findViewById(R.id.incdetail_tv_date);
        tvExpense=(TextView)findViewById(R.id.incdetail_tv_expense);
        tvCategory=(TextView)findViewById(R.id.incdetail_tv_category);
        tvPayee=(TextView)findViewById(R.id.incdetail_tv_payee);
        tvDescription=(TextView)findViewById(R.id.incdetail_tv_discription);



        incid=getIntent().getStringExtra("IncomeID");
        dbi=new DB_Income(this);
        bi=dbi.selectByID(Integer.parseInt(incid));
        dbic=new DB_IncomeCategory(this);


        tvDate.setText(bi.getIncDate());
        inAmount = Double.parseDouble(bi.getIncIncome());
        tvExpense.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(inAmount)));
        tvPayee.setText(bi.getIncPayer());
        tvDescription.setText(bi.getIncDiscription());
        //tvCategory.setText(dbec.selectById(be.getExpID()));
        tvCategory.setText(dbic.selectById(bi.getIncCatID()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_income_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (item.getItemId())
        {
            case R.id.action_edit:
                Intent in =new Intent(IncomeDetails.this,EditIncomeActivity.class);
                in.putExtra("IncomeID",incid);
                startActivity(in);
                return true;
            case R.id.action_delete:
                new AlertDialog.Builder(this)
                        .setTitle("Delete Record ")
                        .setMessage("Are you sure you want to delete this record?")

                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation

                                dbi.deletByID(Integer.parseInt(incid));
                                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                                Intent in =new Intent(IncomeDetails.this,HistoryActivity.class);
                                startActivity(in);

//                                  arrayExp=dbe.getAllRecords();
//                                 expListView.setAdapter(new AdapterExpandableExp(this, ex_deptList, listDataHeader));


                            }
                        })

                                // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("No", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
