package com.example.vaideeswaran.counteggs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et;
    EditText et1;
    EditText et2;
    EditText et3;
    Button bt;
    Button bt1;
    Button bt2;
    String cal;
    String date;
    String str1;
    String str2;
    String str3;
    String database = "counteggs";
    String bundle2;
    SQLiteDatabase db;
    int calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3= (EditText) findViewById(R.id.editText3);
        Button bt = (Button) findViewById(R.id.button);
        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        mm++;
        String date1 = yy + "";
        String date2 = mm + "";
        String date3 = dd + "";
        date = date3 + "-" + date2 + "-" + date1;

    }

    public void calc(View v) {

        cal=et3.getText().toString();
        String bud=et1.getText().toString();
        if(!cal.isEmpty()&&!bud.isEmpty()) {
            calc = Integer.parseInt(cal);
            String bundle = et1.getText().toString();
            int neggs = Integer.parseInt(bundle);
            int total1 = neggs * 20;
            int total = total1 + calc;
            String atai = total + "";
            et2.setText(atai);
        }
        else
            Toast.makeText(getApplicationContext(),"Enter both no. of bundle and extra atai",Toast.LENGTH_LONG).show();
    }

    public void save(View v) {
        String wname = et.getText().toString();
        String bundle1 = et1.getText().toString();
        if (calc == 0) {
            bundle2 = bundle1;
        } else {
            bundle2 = bundle1 + "+" + cal + "(atai)";
        }

        String eggs1 = et2.getText().toString();
        String cal = et3.getText().toString();
        if (wname.matches("")) {

            et.setError("enter wing name");
            Toast.makeText(MainActivity.this, "Please fill required field", Toast.LENGTH_SHORT).show();

        } else if (bundle1.matches("")) {

            et1.setError("enter no. of bundle");
            Toast.makeText(MainActivity.this, "Please fill required field", Toast.LENGTH_SHORT).show();

        } else if (cal.matches("")) {

            et3.setError("enter extra atai");
            Toast.makeText(MainActivity.this, "Please fill required field", Toast.LENGTH_SHORT).show();

        } else if (eggs1.matches("")) {

            et2.setError("calculate no. of atai");
            Toast.makeText(MainActivity.this, "Please fill required field", Toast.LENGTH_SHORT).show();

        } else {


            //Toast.makeText(getApplicationContext(),date,Toast.LENGTH_LONG).show();
            db = openOrCreateDatabase(database, MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS '" + date + "' (wingname VARCHAR,bundle VARCHAR,eggs VARCHAR)");
            //db.execSQL("delete * from place1");
            db.execSQL("INSERT INTO '" + date + "' values ('" + wname + "','" + bundle2 + "','" + eggs1 + "')");
            et.setText("");
            et1.setText("");
            et2.setText("");
            et3.setText("");
            Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();

        }
    }

    public void vsave(View v) {
        db = openOrCreateDatabase(database, MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS '" + date + "' (wingname VARCHAR,bundle VARCHAR,eggs VARCHAR)");
        Cursor c = db.rawQuery("select * from '" + date + "'", null);


        if (c != null) {
            // Toast.makeText(getApplicationContext(),"Table is empty",Toast.LENGTH_LONG).show();
            if (c.moveToFirst()) {
                do {
                    str1 = c.getString(c.getColumnIndex("wingname"));
                    str2 = c.getString(c.getColumnIndex("bundle"));
                    str3 = c.getString(c.getColumnIndex("eggs"));


                } while (c.moveToNext());
                Intent intent = new Intent(getApplicationContext(), TableView.class);
                intent.putExtra("wname", str1);
                intent.putExtra("bundle", str2);
                intent.putExtra("extra", cal);
                intent.putExtra("table", date);
                startActivity(intent);


            } else {
                Toast.makeText(getApplicationContext(), "Table is empty", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Table is empty", Toast.LENGTH_LONG).show();
        }
    }

}
