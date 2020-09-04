package com.expensescalculator.Design;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.expensescalculator.Adapter.AdapterExpandableExp;
import com.expensescalculator.Bean.BeanExpense;
import com.expensescalculator.DBhelper.DB_Expense;
import com.expensescalculator.DBhelper.DB_ExpenseCategory;
import com.expensescalculator.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ExpenseDetails extends AppCompatActivity {

    TextView tvDate;
    TextView tvExpense;
    TextView tvCategory;
    TextView tvPayee;
    TextView tvDescription;


    DB_Expense dbe;
    BeanExpense be;
    DB_ExpenseCategory dbec;
    String expid;

    ArrayList<BeanExpense> arrayExp;

    double expAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);

        be=new BeanExpense();

        tvDate=(TextView)findViewById(R.id.expdetail_tv_date);
        tvExpense=(TextView)findViewById(R.id.expdetail_tv_expense);
        tvCategory=(TextView)findViewById(R.id.expdetail_tv_category);
        tvPayee=(TextView)findViewById(R.id.expdetail_tv_payee);
        tvDescription=(TextView)findViewById(R.id.expdetail_tv_discription);



        expid=getIntent().getStringExtra("ExpenseID");
        dbe=new DB_Expense(this);
        be=dbe.selectByID(Integer.parseInt(expid));
        dbec=new DB_ExpenseCategory(this);


        tvDate.setText(be.getExpDate());
        expAmount = Double.parseDouble(be.getExpExpense());
        tvExpense.setText("\u20B9"+String.valueOf(NumberFormat.getNumberInstance(Locale.US)
                .format(expAmount)));
        tvPayee.setText(be.getExpPayee());
        tvDescription.setText(be.getExpDiscription());
        //tvCategory.setText(dbec.selectById(be.getExpID()));
        tvCategory.setText(dbec.selectById(be.getExpCatID()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expense_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }
*/

        switch (item.getItemId())
        {
            case R.id.action_edit:
                Intent in =new Intent(ExpenseDetails.this,EditExpenseActivity.class);
                in.putExtra("ExpenseID",expid);
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

                                dbe.deletByID(Integer.parseInt(expid));
                                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                                Intent in =new Intent(ExpenseDetails.this,HistoryActivity.class);
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
