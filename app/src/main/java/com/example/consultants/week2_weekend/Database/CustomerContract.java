package com.example.consultants.week2_weekend.Database;

import android.provider.BaseColumns;

public class CustomerContract {
    public static final String Name = "Customer.db";
    public static final int VERSION = 1;

    //TODO create table and columns
    public static final String CREATE_TABLE = "CREATE TABLE " +
            FeedEntry.TABLE_NAME + "(" +
            FeedEntry.COL_NAM + " Text," +
            FeedEntry.COL_AGE + " Text," +
            FeedEntry.COL_PHONE + " Text)";

    public static final String GET_ALL = "SELECT * FROM " + FeedEntry.TABLE_NAME;


    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "customer";
        public static final String COL_NAM = "name";
        public static final String COL_AGE = "age";
        public static final String COL_PHONE = "Phone Number";
    }

}
