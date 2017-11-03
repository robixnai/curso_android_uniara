package br.com.rmoreira.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private List<Movie> mMovies;
    private OnItemClickListener mListener;

    public MoviesAdapter(List<Movie> movieList, OnItemClickListener listener) {
        mMovies = movieList;
        mListener = listener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_movies_itens, parent, false);
        return new MoviesViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.onBindViewHolder(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

}
