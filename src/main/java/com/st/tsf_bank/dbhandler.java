package com.st.tsf_bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhandler extends SQLiteOpenHelper {
    public static final String Database_name = "CustomerData.db";
    public static final String Table1_name = "Users_TABLE";
    public static final String Table2_name = "Transfers_TABLE";
    public static final String COL1 = "C_id";
    public static final String COL2 = "Customer_name";
    public static final String COL3 = "Customer_email";
    public static final String COL4 = "Current_balance";
    public int point;
    public Context context;

    NoteModel noteModel1 = new NoteModel();

    public dbhandler(Context context) {
        super(context, Database_name, null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table1_name + " (C_id INTEGER PRIMARY KEY AUTOINCREMENT,Customer_name TEXT,Customer_email TEXT,Current_balance INTEGER );");
        db.execSQL("CREATE TABLE " + Table2_name + " (C_id INTEGER PRIMARY KEY AUTOINCREMENT,From_Customer_name TEXT,T0_Customer_name TEXT,Transferred INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table1_name);
        onCreate(db);
    }

    public boolean insertdata(String name, String email, int bal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        System.out.println("\n\nafter content values : " + name + " .\n\n");

        contentValues.put(COL2, name);
        contentValues.put(COL3, email);
        contentValues.put(COL4, bal);

        System.out.println("\n\nafter content \n\n");

        long result = db.insert(Table1_name, null, contentValues);
        return result != -1;
    }

    public boolean insertdata1(String name, String toname, int bal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        System.out.println("\n\nafter content values : " + name + " .\n\n");

        contentValues.put("From_Customer_name", name);
        contentValues.put("T0_Customer_name", toname);
        contentValues.put("Transferred", bal);

        System.out.println("\n\nafter content \n\n");

        long result = db.insert(Table2_name, null, contentValues);
        return result != -1;
    }

    public void insertpointer(int name) {
        point = name;
    }

    //    public Cursor get1data(String cid,String name){
//        SQLiteDatabase db=this.getWritableDatabase();
//        String query="Select * from Users_TABLE where C_id="+name+";";
//        return db.rawQuery(query,null);
//    }
    public Cursor getdata(int vallue) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String query="Select C_id,Customer_Name,Current_balance from Users_TABLE where C_id="+vallue+";";
        String query = "Select * from Users_TABLE;";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void updatebal(int money, String toname, int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + Table1_name + " SET " + COL4 + "=" + money + " WHERE " + COL2 + "=" + toname + ";";
        Cursor cursor1 = db.rawQuery("Select * from Users_TABLE;", null);
        cursor1.moveToPosition(value);
        db.execSQL(query);

    }
//    public ArrayList<NoteModel> getNotes(int value) {
//        ArrayList<NoteModel> arrayList = new ArrayList<>();
//
//        // select all query
//        String select_query= "SELECT * FROM " + Table1_name;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(select_query, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                noteModel1.setID(cursor.getString(1));
//                System.out.println("\n cursor.getstring(col 11)="+cursor.getString(1)+"\n");
//                noteModel1.setTitle(cursor.getString(2));
//                noteModel1.setDes(cursor.getString(3));
//                arrayList.add(noteModel1);
//            }while (cursor.moveToNext());
//
//        }
//        return arrayList;
//    }

//    public Cursor getvalues(int value){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String select_query="select C_id, Customer_name,Current_balance from Users_TABLE where C_id="+value;
//
//
//
//return}

}
