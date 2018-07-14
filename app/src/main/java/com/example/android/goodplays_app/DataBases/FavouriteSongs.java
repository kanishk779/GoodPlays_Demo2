package com.example.android.goodplays_app.DataBases;

import android.content.ContentValues;
import android.database.Cursor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;
import com.example.android.goodplays_app.ModelClasses.Track1;

import java.util.ArrayList;

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
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " (" + TITLE + " varchar(20) ," + ARTIST + " varchar(20)," +
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
        super(cmp, DATABASE_NAME, null, VERSION);//A comment is added
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

    public long insert(Track1 track) {
        long i;
        //String trackName = track.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, track.getTrackName());
        cv.put(ARTIST, track.getArtistName());
        //cv.put(GENRE, trackName);
        cv.put(ALBUM, track.getAlbumName());
        cv.put(YEAR, track.getFirstReleaseDate());
        cv.put(STARS, track.getStars());
        i=sdW.insert(TABLE_NAME, null, cv);
        return i;
    }

    public long delete(String nameOfSong) {
        long i=0;
        i = sdW.delete(TABLE_NAME, "" + TITLE + "=?", new String[]{nameOfSong});
        return i;
    }

    public void update(Track1 track) {
        //String trackName = track.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, track.getTrackName());
        cv.put(ARTIST, track.getArtistName());
        //cv.put(GENRE, trackName);
        cv.put(ALBUM, track.getAlbumName());
        cv.put(YEAR, track.getFirstReleaseDate());
        cv.put(STARS, track.getStars());
        sdW.insert(TABLE_NAME, null, cv);
    }

    public Track1 read(String songName) {
        sdR = getReadableDatabase();
        Track1 t = new Track1();
        Cursor c = sdR.query(TABLE_NAME, null, "" + TITLE + "=? ", new String[]{songName}, null, null, null);
        if (c != null) {
            c.moveToNext();
            t.setTrackName(c.getString(0));
            t.setArtistName(c.getString(1));
            //t.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().setMusicGenreName(c.getString(2));
            t.setAlbumName(c.getString(2));
            t.setFirstReleaseDate(c.getString(3));
            t.setStars(c.getFloat(4));
        }
        return t;
    }
    public ArrayList<Track1> readAll() {
        sdR = getReadableDatabase();
        ArrayList<Track1> list = new ArrayList<>();
        Cursor c = sdR.query(TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()) {
            Track1 t = new Track1();
            t.setTrackName(c.getString(0));
            t.setArtistName(c.getString(1));
            //t.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().setMusicGenreName(c.getString(2));
            t.setAlbumName(c.getString(2));
            t.setFirstReleaseDate(c.getString(3));
            t.setStars(c.getFloat(4));
            list.add(t);
            c.moveToNext();
        }
        return list;
    }
}

