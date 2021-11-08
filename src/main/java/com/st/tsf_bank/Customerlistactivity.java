package com.st.tsf_bank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Customerlistactivity extends AppCompatActivity {
    dbhandler mydb = new dbhandler(Customerlistactivity.this);
    ListView listView;
    gvariable g = new gvariable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerlistactivity);
        listView = findViewById(R.id.list_view);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1)   Mr. John ");
        arrayList.add("2)   Mr. Alex");
        arrayList.add("3)   Mr. Steve");

        arrayList.add("4)   Ms. Crystine");
        arrayList.add("5)   Mr. philip");
        arrayList.add("6)   Mr. Mark");

        arrayList.add("7)   Mr. Max");
        arrayList.add("8)   Mr. Sid");
        arrayList.add("9)   Mr. James");

        arrayList.add("10)  Mr. William");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Customerlistactivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            g.pint = position;
            System.out.println("\n\ng.pint value is ; " + g.pint + "\n\n");
            // Toast.makeText(Customerlistactivity.this, "item clicked = "+position, Toast.LENGTH_SHORT).show();
            mydb.insertpointer(position);
            //Toast.makeText(Customerlistactivity.this,"Pointer inserted of value ="+position,Toast.LENGTH_SHORT).show();
//          intent1.putExtra(" sd",position);

            openacustctivity();
        });


    }

    public void openacustctivity() {
        Intent intent1 = new Intent(Customerlistactivity.this, Customeractivity.class);
        int value = g.pint;
        intent1.putExtra("key", value);

        startActivity(intent1);
    }
}