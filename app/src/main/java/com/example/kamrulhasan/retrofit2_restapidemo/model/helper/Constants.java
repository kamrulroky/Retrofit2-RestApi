package com.example.kamrulhasan.retrofit2_restapidemo.model.helper;

/**
 * Created by kamrul hasan on 2/7/2017.
 */

public class Constants {

    public static final class HTTP{

        public static final String BASE_URL = "http://services.hanselandpetal.com/";
    }

    public static final class DATABASE{
        public static final String DB_NAME = "flowers";
        public static final int DB_VERSION = 1;
        public static final String TABLE_NAME ="flower";

        public static final String DROP_QUERY ="DROP IF TABLE EXIST" + TABLE_NAME;
        public static final String GET_FLOWERS_QUERY ="SELECT *FROM" + TABLE_NAME;

        public static final String PRODUCT_ID ="productID";
        public static final String CATEGORY ="category";
        public static final String PRICE ="price";
        public static final String INSTRUCTION ="instruction";
        public static final String NAME ="name";
        public static final String PHOTO_URL ="photo_url";
        public static final String PHOTO ="photo";


        public static final String CREATE_TABLE_QUERY ="CREATE TABLE" + TABLE_NAME +"" +
                "(" + PRODUCT_ID + " INTEGER PRIMARY KEY not null," +
                CATEGORY + " TEXT not null," +
                PRICE + " TEXT not null," +
                INSTRUCTION + " TEXT not null," +
                NAME + " TEXT not null," +
                PHOTO_URL + " TEXT not null," +
                PHOTO + " blob not null)" ;

    }
    public static final class REFERENCE{
        public static final String FLOWER = Config.PACKAGE_NAME + "flower";

    }
    public static final class Config{
        public static final String PACKAGE_NAME = "com.example.kamrulhasan.retrofit2_restapidemo";

    }
}
