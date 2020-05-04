package com.example.vaideeswaran.counteggs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by VAIDEESWARAN on 5/12/2016.
 */
public class TableView extends AppCompatActivity {
    String database = "counteggs";
    SQLiteDatabase db;
    String date;
    String str1;
    String str2;
    String str3;
    int num = 0;
    int total;
    int te = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tableview);


        Bundle extras = getIntent().getExtras();
        String wname = extras.getString("wname");
        String bundle = extras.getString("bundle");
        String cal = extras.getString("extra");
        date = extras.getString("table");
        db = openOrCreateDatabase(database, MODE_PRIVATE, null);
        Cursor c = db.rawQuery("select * from '" + date + "'", null);

        TableLayout table1 = (TableLayout) findViewById(R.id.the_table);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        TableRow row1 = new TableRow(this);
        TableRow.LayoutParams tb1 = new TableRow.LayoutParams();
        tb1.setMargins(1, 1, 1, 1);
        tb1.width = 10;
        TextView tv6 = new TextView(this);
        // TextView tv1 = new TextView(this);
        tv6.setText("WING NAME");
        tv6.setTextColor(Color.BLUE);
        tv6.setPadding(30, 3, 30, 3);
        tv6.setTextSize(18);

        TextView tv7 = new TextView(this);
        // TextView tv1 = new TextView(this);
        tv7.setText("BUNDLE");
        tv7.setPadding(20, 3, 20, 3);
        tv7.setTextColor(Color.BLUE);
        tv7.setTextSize(18);
        TextView tv8 = new TextView(this);
        // TextView tv1 = new TextView(this);
        tv8.setText("ATAI");
        tv8.setPadding(20, 3, 20, 3);
        tv8.setTextColor(Color.BLUE);
        tv8.setTextSize(18);
        TextView tv9 = new TextView(this);
        tv9.setText("EGGS");
        tv9.setPadding(20, 3, 20, 3);
        tv9.setTextColor(Color.BLUE);
        tv9.setTextSize(18);


        row1.addView(tv6, 0);
        row1.addView(tv7, 1);
        row1.addView(tv8, 2);
        row1.addView(tv9, 3);
        //  row.addView(tv1, 1);
        row1.setMinimumWidth(10);
        row1.setMinimumHeight(10);

        //row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 10));
        table1.addView(row1);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    str1 = c.getString(c.getColumnIndex("wingname"));
                    str2 = c.getString(c.getColumnIndex("bundle"));
                    str3 = c.getString(c.getColumnIndex("eggs"));
                    //  Toast.makeText(getApplicationContext(),str2,Toast.LENGTH_LONG).show();

                    //Toast.makeText(getApplicationContext(),str3,Toast.LENGTH_LONG).show();
                    num = Integer.parseInt(str3);
                    total = total + num;


                    TableLayout table = (TableLayout) findViewById(R.id.the_table);
                    TableRow row = new TableRow(this);
                    TableRow.LayoutParams tb = new TableRow.LayoutParams();
                    tb.setMargins(3, 1, 1, 1);
                    tb.width = 10;
                    TextView tv = new TextView(this);
                    TextView tv1 = new TextView(this);
                    TextView tv2 = new TextView(this);
                    TextView tv4 = new TextView(this);
                    tv3.setText(date);
                    tv.setText(str1);
                    tv.setPadding(30, 3, 30, 3);
                    tv.setTextSize(18);
                    //tv.getTextColors(Color.BLUE);
                    //tv.setBackgroundResource(R.drawable.row_border);
                    tv1.setText(str2);
                    tv1.setPadding(20, 3, 20, 3);
                    tv1.setTextSize(18);

                    tv2.setText(str3);
                    tv2.setPadding(20, 3, 20, 3);
                    tv2.setTextSize(18);

                    int egg = Integer.parseInt(str3);
                    int cegg = egg * 30;
                    te = te + cegg;
                    String tegg = cegg + "";
                    tv4.setText(tegg);
                    tv4.setPadding(20, 3, 20, 3);
                    tv4.setTextSize(18);


                    // tv1.setBackgroundResource(R.drawable.row_border);
                    tv.setGravity(Gravity.LEFT);
                    row.addView(tv, 0);
                    row.addView(tv1, 1);
                    row.addView(tv2, 2);
                    row.addView(tv4, 3);
                    row.setMinimumWidth(10);
                    row.setMinimumHeight(10);

                    //row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 10));
                    table.addView(row);


                } while (c.moveToNext());


            }
        }
        TableLayout table = (TableLayout) findViewById(R.id.the_table);
        TableRow row = new TableRow(this);
        TableRow.LayoutParams tb = new TableRow.LayoutParams();
        tb.setMargins(1, 1, 1, 1);
        tb.width = 10;
        TextView tv = new TextView(this);
        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        TextView tv4 = new TextView(this);
        tv3.setText(date);
        tv.setText("");
        tv.setPadding(20, 3, 20, 3);
        tv.setTextSize(18);
        //tv.getTextColors(Color.BLUE);
        //tv.setBackgroundResource(R.drawable.row_border);
        tv1.setText("TOTAL");
        tv1.setTextColor(Color.RED);
        tv1.setPadding(20, 3, 20, 3);
        tv1.setTextSize(18);
        String tot = total + "";
        tv2.setText(tot);
        tv2.setPadding(20, 3, 20, 3);
        tv2.setTextSize(18);
        String te1 = te + "";
        tv4.setText(te1);
        tv4.setPadding(20, 3, 20, 3);

        tv4.setTextSize(18);
        // tv1.setBackgroundResource(R.drawable.row_border);
        tv.setGravity(Gravity.LEFT);
        row.addView(tv, 0);
        row.addView(tv1, 1);
        row.addView(tv2, 2);
        row.addView(tv4, 3);
        row.setMinimumWidth(10);
        row.setMinimumHeight(10);

        //row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 10));
        table.addView(row);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    TableView.this);
            alertDialog.setTitle("Alert");
            //alertDialog.setIcon(R.mipmap.ic_launcher);
            alertDialog.setMessage("Are you sure want to clear this Table");
            alertDialog.setNegativeButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            db = openOrCreateDatabase(database, MODE_PRIVATE, null);
                            //db.execSQL("delete from '"+date+"'");
                            deleteDatabase("counteggs");
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            Toast.makeText(getApplicationContext(), "Table cleared successfully", Toast.LENGTH_LONG).show();
                            startActivity(intent);


                        }
                    });
            alertDialog.setPositiveButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            alertDialog.show();




     /*   db = openOrCreateDatabase(database, MODE_PRIVATE, null);
            //db.execSQL("delete from '"+date+"'");
            deleteDatabase("counteggs");
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            Toast.makeText(getApplicationContext(),"Table cleared successfully",Toast.LENGTH_LONG).show();
            startActivity(intent);

            return true;
        }*/
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}