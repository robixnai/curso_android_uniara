package br.com.rmoreira.app.storages.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public class MovieContract {

    public static final String TABLE = "movie";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String AVERAGE = "average";
    public static final String SUMMARY = "summary";
    public static final String YEAR = "year";
    public static final String IMAGE_PATH = "imagePath";
    public static final String GENRES = "genres";

    public static final String[] COLUNS = {ID, TITLE, AVERAGE, SUMMARY, YEAR, IMAGE_PATH, GENRES};

    public static String createTable() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(ID + " INTEGER, ");
        sql.append(TITLE + " TEXT, ");
        sql.append(AVERAGE + " NUMBER, ");
        sql.append(SUMMARY + " TEXT, ");
        sql.append(YEAR + " INTEGER, ");
        sql.append(IMAGE_PATH + " TEXT, ");
        sql.append(GENRES + " TEXT ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static ContentValues getContentValues(MovieDao movie) {
        ContentValues content = new ContentValues();
        content.put(ID, movie.getId());
        content.put(TITLE, movie.getTitle());
        content.put(AVERAGE, movie.getAverage());
        content.put(SUMMARY, movie.getSummary());
        content.put(YEAR, movie.getYear());
        content.put(IMAGE_PATH, movie.getImagePath());
        content.put(GENRES, movie.getGenres());
        return content;
    }

    public static MovieDao bind(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            MovieDao movie = new MovieDao();
            movie.setId((cursor.getInt(cursor.getColumnIndex(ID))));
            movie.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
            movie.setAverage(cursor.getDouble(cursor.getColumnIndex(AVERAGE)));
            movie.setSummary(cursor.getString(cursor.getColumnIndex(SUMMARY)));
            movie.setYear(cursor.getInt(cursor.getColumnIndex(YEAR)));
            movie.setImagePath(cursor.getString(cursor.getColumnIndex(IMAGE_PATH)));
            movie.setGenres(cursor.getString(cursor.getColumnIndex(GENRES)));
            return movie;
        }
        return null;
    }

    public static List<MovieDao> bindList(Cursor cursor) {
        final List<MovieDao> movieList = new ArrayList<>();
        while (cursor.moveToNext()) {
            movieList.add(bind(cursor));
        }
        return movieList;
    }

}
