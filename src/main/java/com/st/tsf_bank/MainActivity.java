package com.st.tsf_bank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    dbhandler mydb;

    Button button;
    boolean isinserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new dbhandler(MainActivity.this);

        button = findViewById(R.id.button);
        //  Toast.makeText(MainActivity.this,"Till button",Toast.LENGTH_SHORT).show();

        mydb.insertdata("Mr. John", "john111@gmail.com", 20000);
        mydb.insertdata("Mr. Alex", "Alex@gmail.com", 25000);
        mydb.insertdata("Mr. Steve", "steve@gmail.com", 20000);
        mydb.insertdata("Ms. Crystine", "Crystine@gmail.com", 20000);
        mydb.insertdata("Mr. philip", "philip@gmail.com", 20000);
        mydb.insertdata("Mr. Mark", "Mark@gmail.com", 20000);
        mydb.insertdata("Mr. Max", "Max@gmail.com", 20000);
        mydb.insertdata("Mr. Sid", "Sid@gmail.com", 20000);
        mydb.insertdata("Mr. James", "James@gmail.com", 20000);
        isinserted = mydb.insertdata("Mr. William", "William@gmail.com", 20000);
        mydb.insertdata1("Mr. John", "Mr. Alex", 5000);

//        if(isinserted)
//        Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_SHORT).show();


        button.setOnClickListener(v -> openact());

    }

    public void openact() {
        Intent intent = new Intent(MainActivity.this, Customerlistactivity.class);
        if (isinserted)
            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
        startActivity(intent);


    }
}