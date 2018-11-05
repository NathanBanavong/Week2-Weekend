package com.example.consultants.week2_weekend.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.consultants.week2_weekend.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase extends SQLiteOpenHelper {

    private static final String TAG = CustomerDatabase.class.getSimpleName() + "_TAG";

    public CustomerDatabase(Context context) {
        super(context, CustomerContract.Name, null, CustomerContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CustomerContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saveCustomerInfo(Customer customer) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CustomerContract.FeedEntry.COL_NAM, customer.getName());
        contentValues.put(CustomerContract.FeedEntry.COL_AGE, customer.getAge());
        contentValues.put(CustomerContract.FeedEntry.COL_PHONE, customer.getPhone());

        long rowID = db.insert(CustomerContract.FeedEntry.TABLE_NAME, null, contentValues);

        return rowID;
    }

    //    TODO need to pass to allow display all information
    public List<Customer> getCustomer() {
        SQLiteDatabase db = getWritableDatabase();

        List<Customer> customerList = new ArrayList<>();

        Cursor cursor = db.rawQuery(CustomerContract.GET_ALL, null);

        if (cursor.moveToFirst()) {
            do {

                Customer customer = new Customer(cursor.getString(cursor.getColumnIndex(CustomerContract.FeedEntry.COL_NAM)),
                        cursor.getString(cursor.getColumnIndex(CustomerContract.FeedEntry.COL_PHONE)),
                        cursor.getString(cursor.getColumnIndex(CustomerContract.FeedEntry.COL_AGE)));
                customerList.add(customer); //save the entirety of all customer
                Log.d(TAG, "getCustomer: " + customer);
            } while (cursor.moveToNext());
        }
        db.execSQL(CustomerContract.GET_ALL);

        return customerList;

    }

}
