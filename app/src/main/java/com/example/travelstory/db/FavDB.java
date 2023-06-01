package com.example.travelstory.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FavDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "StoryDB";
    private static String TABLE_NAME = "favoriteTable";

    public static String KEY_ID = "id";

    public static String STORY_TITLE = "storyTitle";
    public static String ORIGIN_LABEL = "originLabel";
    public static String STORY_DATE = "date";
    public static String STORY_LANGUAGE = "language";
    public static String STORY_TEXT = "textStory";
    public static String AUTHOR_ID = "authorId";
    public static String AUTHOR_GENDER = "authorGender";
    public static String STORY_LOCATION = "location";
    public static String FAVORITE_STATUS  = "fStatus";
    // dont forget write this spaces
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + STORY_TITLE+ " TEXT,"
            + ORIGIN_LABEL + " TEXT," + STORY_DATE+" TEXT,"
            + STORY_LANGUAGE + " TEXT," + STORY_TEXT+ " TEXT,"
            + AUTHOR_ID + " TEXT," + AUTHOR_GENDER+" TEXT,"
            + STORY_LOCATION + " TEXT," + FAVORITE_STATUS+" TEXT)";

    public FavDB(Context context) { super(context,DATABASE_NAME,null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // insert data into database
    public void insertIntoTheDatabase(int id, String title, String originLabel, String date,
                                      String textStory, String language, String authorId,
                                      String authorGender, String location,
                                      String fav_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_ID, id);
        cv.put(STORY_TITLE, title);
        cv.put(ORIGIN_LABEL, originLabel);
        cv.put(STORY_DATE, date);
        cv.put(STORY_TEXT, textStory);
        cv.put(STORY_LANGUAGE, language);
        cv.put(AUTHOR_GENDER, authorGender);
        cv.put(AUTHOR_ID, authorId);
        cv.put(STORY_LOCATION, location);
        cv.put(FAVORITE_STATUS, fav_status);
        db.insert(TABLE_NAME,null, cv);

        Log.d("FavDB Status", STORY_TITLE + ", favstatus - "+fav_status+" - . " + cv);
    }

    // remove line from database
    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ FAVORITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());

    }

    public void add_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ FAVORITE_STATUS+" ='1' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());

    }

    // select all favorite list
    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ='1'";
        Log.d("FavDB StatusAll", sql);
        return db.rawQuery(sql,null,null);
    }

    public Cursor select_all_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ='0'";
        Log.d("FavDB StatusAll", sql);
        return db.rawQuery(sql,null,null);
    }

    // select all favorite list label
    public Cursor select_all_label(String label) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+ORIGIN_LABEL+" ="+label+"";
        return db.rawQuery(sql,null,null);
    }

    // select all favorite list country
    public Cursor select_all_country(String country) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ="+country+"";
        return db.rawQuery(sql,null,null);
    }

}