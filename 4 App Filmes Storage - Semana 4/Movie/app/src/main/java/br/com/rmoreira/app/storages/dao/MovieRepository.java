package br.com.rmoreira.app.storages.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.rmoreira.app.MovieApplication;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public class MovieRepository {

    private static MovieRepository instance;
    private static Context context = MovieApplication.getContext();

    private MovieRepository() {
        super();
    }

    public synchronized static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return new MovieRepository();
    }

    public void save(MovieDao movie) {
        DaoHelper helper = new DaoHelper(MovieRepository.context);
        SQLiteDatabase db = helper.getWritableDatabase();
        String where = MovieContract.ID + " = ?";
        String[] args = {movie.getId().toString()};
        int update = db.update(MovieContract.TABLE, MovieContract.getContentValues(movie), where, args);
        if (update == 0) {
            db.insert(MovieContract.TABLE, null, MovieContract.getContentValues(movie));
        }
        db.close();
        helper.close();
    }

    public void delete(MovieDao movie) {
        DaoHelper helper = new DaoHelper(MovieRepository.context);
        SQLiteDatabase db = helper.getWritableDatabase();
        String where = MovieContract.ID + " = ?";
        String[] args = {movie.getId().toString()};
        db.delete(MovieContract.TABLE, where, args);
        db.close();
        helper.close();
    }

    public MovieDao getById(MovieDao movie) {
        DaoHelper helper = new DaoHelper(MovieRepository.context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where = MovieContract.ID + " = ?";
        String[] args = {movie.getId().toString()};
        Cursor cursor = db.query(MovieContract.TABLE, MovieContract.COLUNS, where, args, null, null, null);
        MovieDao movieDao = MovieContract.bind(cursor);
        db.close();
        helper.close();
        return movieDao;
    }

    public List<MovieDao> getAll() {
        DaoHelper helper = new DaoHelper(MovieRepository.context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(MovieContract.TABLE, MovieContract.COLUNS, null, null, null, null, null);
        List<MovieDao> movieDaoList = MovieContract.bindList(cursor);
        db.close();
        helper.close();
        return movieDaoList;
    }

    public boolean isMovie(MovieDao movie) {
        return getById(movie) != null;
    }

}
