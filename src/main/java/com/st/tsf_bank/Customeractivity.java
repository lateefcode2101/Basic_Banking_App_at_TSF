package com.st.tsf_bank;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Customeractivity extends AppCompatActivity {
    public int value;
    dbhandler viewdb = new dbhandler(Customeractivity.this);
    Button b;
    TextView cid, cname, bal;
    dbhandler dh = new dbhandler(Customeractivity.this);
    gvariable g1 = new gvariable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customeractivity);

        int id = g1.pint;

        cid = findViewById(R.id.cid_id);
        cname = findViewById(R.id.cname_id);
        bal = findViewById(R.id.bal_id);

        b = findViewById(R.id.buttontransfer);

        System.out.println("\n\nValue of id=" + id + "\n\n");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("key");
            Toast.makeText(Customeractivity.this, "recieved : " + value, Toast.LENGTH_SHORT).show();
            //The key argument here must match that used in the other activity
        }
        Cursor cursor = viewdb.getdata(value);

        cursor.moveToPosition(value);
        cid.setText(cursor.getString(0));
        cname.setText(cursor.getString(1));
        bal.setText(cursor.getString(3));

        b.setOnClickListener(v -> openactivity());
    }

    public void openactivity() {
        Intent intent = new Intent(Customeractivity.this, transferactivity.class);

        g1.cid = this.cid.getText().toString();
        g1.cname = this.cname.getText().toString();
        g1.balance = Integer.parseInt(this.bal.getText().toString());
        startActivity(intent);
    }

}