package com.example.android.goodplays_app.DataBases;

import android.content.ContentValues;
import android.database.Cursor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 11-06-2018.
 */

public class FavouriteSongs extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "database_favourite";
    private static final String TABLE_NAME = "bestsongs";
    private static final String TITLE = "title";
    private static final String ARTIST = "artist";
    private static final String GENRE = "genre";
    private static final String ALBUM = "album";
    private static final String YEAR = "year";
    private static final String STARS = "stars";
    private final static int VERSION = 1;
    SQLiteDatabase sdW, sdR;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " (" + TITLE + " varchar(20) ," + ARTIST + " varchar(20)," + GENRE + " varchar(20)," +
            "" + ALBUM + " varchar(20) ," + YEAR + " varchar(20)," + STARS + " int);";

    public void openWrite() {
        sdW = getWritableDatabase();
    }

    public void closeWrite() {
        sdW.close();
    }

    public void openRead() {
        sdR = getWritableDatabase();
    }

    public void closeRead() {
        sdR.close();
    }

    public FavouriteSongs(Context cmp) {
        super(cmp, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME + "");
        this.onCreate(sqLiteDatabase);
    }

    /*public void insert(Team1 tm) {
        ContentValues cv = new ContentValues();
        cv.put(TITLE, tm.getTeam_id1());
        cv.put(ARTIST, tm.getTeam_name1());
        cv.put(GENRE, tm.getImage_url1());
        cv.put(ALBUM, tm.getTeam_id2());
        cv.put(YEAR, tm.getTeam_name2());
        cv.put(STARS, tm.getImage_url2());
        sdW.insert(TABLE_NAME, null, cv);
    }

    *//*public void delete(int id1, int id2) {
        sdW.delete(TABLE_NAME, "" + TEAM_ID1 + "=? and " + TEAM_ID2 + "=?", new String[]{String.valueOf(id1), String.valueOf(id2)});
    }*//*

    public void update(int id1, int id2, Team1 tm) {
        ContentValues cv = new ContentValues();
        cv.put(TITLE, tm.getTeam_id1());
        cv.put(ARTIST, tm.getTeam_name1());
        cv.put(GENRE, tm.getImage_url1());
        cv.put(ALBUM, tm.getTeam_id2());
        cv.put(YEAR, tm.getTeam_name2());
        cv.put(STARS, tm.getImage_url2());
        sdW.insert(TABLE_NAME, null, cv);
    }

    public Team1 read(String songName) {
        sdR = getReadableDatabase();
        //Team1 t = new Team1();
        Cursor c = sdR.query(TABLE_NAME, null, "" + TITLE + "=? ", new String[]{songName}, null, null, null);
        if (c != null) {
            c.moveToNext();
            t.setTeam_id1(c.getInt(0));
            t.setTeam_name1(c.getString(1));
            t.setImage_url1(c.getBlob(2));
            t.setTeam_id2(c.getInt(3));
            t.setTeam_name2(c.getString(4));
            t.setImage_url2(c.getBlob(5));
            t.setVenue(c.getString(6));
            t.setTime(c.getString(7));
        }
        return t;
    }*/
}

