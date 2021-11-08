package com.st.tsf_bank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class transferactivity extends AppCompatActivity {
    dbhandler db = new dbhandler(transferactivity.this);
    TextView t;
    EditText et1, et2;
    gvariable g = new gvariable();
    Button b;
    String et11;
    String et22;
    int value = g.pint;
    int x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferactivity);
        t = findViewById(R.id.textView2);

        et1 = findViewById(R.id.amountid);
        et2 = findViewById(R.id.recid);


//        g.balance=Integer.parseInt(et11);

        b = findViewById(R.id.button3);

        b.setOnClickListener(v -> {
            Toast.makeText(transferactivity.this, "Transfer Complete!", Toast.LENGTH_SHORT).show();
            et11 = et1.getText().toString();
            et22 = et2.getText().toString();
            try {
                Toast.makeText(transferactivity.this, "Transfer Complete! 11", Toast.LENGTH_SHORT).show();

                x = Integer.parseInt(et11);
            } catch (NumberFormatException n) {
                n.printStackTrace();
            }

            Toast.makeText(transferactivity.this, "Transfer Complete! 2", Toast.LENGTH_SHORT).show();

            transfer(x, et22, value);
            Toast.makeText(transferactivity.this, "Transfer Complete! 3", Toast.LENGTH_SHORT).show();

            openactivity();
        });

    }

    public void openactivity() {
        Intent intent = new Intent(transferactivity.this, Customerlistactivity.class);
        startActivity(intent);
    }

    public void transfer(int money, String toname, int value) {

        db.updatebal(money, toname, value);
        Toast.makeText(transferactivity.this, "done transfer", Toast.LENGTH_SHORT).show();

//        if (r!=null)
//            Toast.makeText(transferactivity.this, "Cursor recieved", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(transferactivity.this, "Cursor not recieved", Toast.LENGTH_SHORT).show();
    }
}