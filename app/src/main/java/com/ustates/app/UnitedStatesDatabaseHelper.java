package com.ustates.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prudhvi on 5/22/2014.
 */
public class UnitedStatesDatabaseHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "unitedstates.db";
    private static final String TABLE_STATES = "states";
    private static final String TABLE_WEBLINKS = "weblinks";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ABBREVIATION = "abbreviation";
    public static final String COLUMN_NICKNAME = "nickname";
    public static final String COLUMN_DEMONYM = "demonym";
    public static final String COLUMN_CAPITAL = "capital";
    public static final String COLUMN_LARGEST_CITY = "largest_city";
    public static final String COLUMN_AREA = "area";
    public static final String COLUMN_AREA_RANK = "area_rank";
    public static final String COLUMN_POPULATION = "population";
    public static final String COLUMN_POPULATION_RANK = "population_rank";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_TIMEZONE = "timezone";
    public static final String COLUMN_WEBSITE = "website";
    public static final String COLUMN_TOURISM = "tourism";

    public static final String COLUMN_ID1 = "_id";
    public static final String COLUMN_STATE_WIKI = "state_wiki";
    public static final String COLUMN_CAPITAL_WIKI = "capital_wiki";
    public static final String COLUMN_LARGEST_CITY_WIKI = "largest_city_wiki";
    public static final String COLUMN_STATE_WEB = "state_web";
    public static final String COLUMN_TOURISM_WEB = "tourism_web";
    public static final String COLUMN_MAP_LOCATION = "map_location";


    private UnitedStatesOpenHelper openHelper;
    private SQLiteDatabase database;

    public UnitedStatesDatabaseHelper(Context context)
    {
        openHelper = new UnitedStatesOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    /* Method to insert data into "states" table by getting the record from "StateIndex" object*/
    public void addStateRecord(StateIndex stateIndex)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, stateIndex.getId());
        contentValues.put(COLUMN_NAME, stateIndex.getName());
        contentValues.put(COLUMN_ABBREVIATION, stateIndex.getAbbreviation());
        contentValues.put(COLUMN_NICKNAME, stateIndex.getNickname());
        contentValues.put(COLUMN_DEMONYM, stateIndex.getDemonym());
        contentValues.put(COLUMN_CAPITAL, stateIndex.getCapital());
        contentValues.put(COLUMN_LARGEST_CITY, stateIndex.getLargestCity());
        contentValues.put(COLUMN_AREA, stateIndex.getArea());
        contentValues.put(COLUMN_AREA_RANK, stateIndex.getAreaRank());
        contentValues.put(COLUMN_POPULATION, stateIndex.getPopulation());
        contentValues.put(COLUMN_POPULATION_RANK, stateIndex.getPopulationRank());
        contentValues.put(COLUMN_YEAR, stateIndex.getYear());
        contentValues.put(COLUMN_TIMEZONE, stateIndex.getTimezone());
        contentValues.put(COLUMN_WEBSITE, stateIndex.getWebsite());
        contentValues.put(COLUMN_TOURISM, stateIndex.getTourism());
        database.replace(TABLE_STATES, null, contentValues);
    }

    /* Method to insert data into "weblinks" table by getting the record from "StateWbLinks" object*/
    public void addWebRecord(StateWebLinks stateWebLinks)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID1, stateWebLinks.getId());
        contentValues.put(COLUMN_STATE_WIKI, stateWebLinks.getStateWiki());
        contentValues.put(COLUMN_CAPITAL_WIKI, stateWebLinks.getCapitalWiki());
        contentValues.put(COLUMN_LARGEST_CITY_WIKI, stateWebLinks.getLargestCityWiki());
        contentValues.put(COLUMN_STATE_WEB, stateWebLinks.getStateWeb());
        contentValues.put(COLUMN_TOURISM_WEB, stateWebLinks.getTourismWeb());
        contentValues.put(COLUMN_MAP_LOCATION, stateWebLinks.getMapLocation());
        database.replace(TABLE_WEBLINKS, null, contentValues);
    }

    /* Method to retrieve data record from the table "states" and storing in object "StateIndex"*/
    public StateIndex getStateInfo(int id)
    {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.query(TABLE_STATES, null, COLUMN_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        StateIndex stateIndex = new StateIndex(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14));
        return stateIndex;
    }

    /* Method to retrieve data record from the table "weblinks" and storing in object "StateWebLinks"*/
    public StateWebLinks getWebLinks(int id)
    {
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.query(TABLE_WEBLINKS, null, COLUMN_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        StateWebLinks stateWebLinks = new StateWebLinks(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6));
        return stateWebLinks;
    }

    public int getStatesCount()
    {
        String countQuery = "SELECT * FROM " + TABLE_STATES;
        database = openHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }



    class UnitedStatesOpenHelper extends SQLiteOpenHelper {
        public UnitedStatesOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /* Method to create a new table in the DB*/
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_STATES+
                    " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_NAME + " VARCHAR, "
                    + COLUMN_ABBREVIATION + " VARCHAR, "
                    + COLUMN_NICKNAME + " VARCHAR, "
                    + COLUMN_DEMONYM + " VARCHAR, "
                    + COLUMN_CAPITAL + " VARCHAR, "
                    + COLUMN_LARGEST_CITY + " VARCHAR, "
                    + COLUMN_AREA + " VARCHAR, "
                    + COLUMN_AREA_RANK + " VARCHAR, "
                    + COLUMN_POPULATION + " VARCHAR, "
                    + COLUMN_POPULATION_RANK + " VARCHAR, "
                    + COLUMN_YEAR + " VARCHAR, "
                    + COLUMN_TIMEZONE + " VARCHAR, "
                    + COLUMN_WEBSITE + " VARCHAR, "
                    + COLUMN_TOURISM + " VARCHAR);");

            sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_WEBLINKS+
                    " ( " + COLUMN_ID1 + " INTEGER PRIMARY KEY, "
                    + COLUMN_STATE_WIKI + " VARCHAR, "
                    + COLUMN_CAPITAL_WIKI + " VARCHAR, "
                    + COLUMN_LARGEST_CITY_WIKI + " VARCHAR, "
                    + COLUMN_STATE_WEB + " VARCHAR, "
                    + COLUMN_TOURISM_WEB + " VARCHAR, "
                    + COLUMN_MAP_LOCATION + " VARCHAR);");
        }

        /* Method to drop existing table and create again.
        * This method executes only when the DATABASE_VERSION > 1*/
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_STATES);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_WEBLINKS);
            onCreate(sqLiteDatabase);
        }
    }
}
