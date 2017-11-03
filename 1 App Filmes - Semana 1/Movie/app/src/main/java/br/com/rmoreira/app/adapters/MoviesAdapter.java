package br.com.rmoreira.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public class MoviesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Movie> mMovies;
    private OnItemClickListener mListener;

    public MoviesAdapter(Context context, List<Movie> movieList, OnItemClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mMovies = movieList;
        mListener = listener;
    }

    public View getView(int position, View view, ViewGroup parent) {
        MoviesViewHolder moviesViewHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.movies_itens, null);
            moviesViewHolder = new MoviesViewHolder(view, mListener);

            view.setTag(moviesViewHolder);
        } else {
            moviesViewHolder = (MoviesViewHolder) view.getTag();
        }

        Movie movie = mMovies.get(position);
        moviesViewHolder.onBindViewHolder(movie);

        return view;
    }

    public int getCount() {
        return mMovies.size();
    }

    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

}
