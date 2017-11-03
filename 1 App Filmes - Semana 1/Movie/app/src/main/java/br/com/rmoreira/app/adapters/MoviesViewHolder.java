package br.com.rmoreira.app.adapters;

import android.view.View;
import android.widget.TextView;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public final class MoviesViewHolder implements View.OnClickListener {

    private View mView;
    private Movie mMovie;
    private OnItemClickListener mListener;

    private TextView mTextViewTitle, mTextViewAverage, mTextViewYear, mTextViewCategory;

    public MoviesViewHolder(View view, OnItemClickListener listener) {
        mView = view;
        mListener = listener;

        mTextViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        mTextViewAverage = (TextView) view.findViewById(R.id.textViewAverage);
        mTextViewYear = (TextView) view.findViewById(R.id.textViewYear);
        mTextViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
    }

    public void onBindViewHolder(Movie movie) {
        mMovie = movie;

        mTextViewTitle.setText(movie.getTitle());
        mTextViewAverage.setText(movie.getAverage().toString());
        mTextViewYear.setText(String.valueOf(movie.getYear()));
        mTextViewCategory.setText(movie.getCategory());

        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onItemClick(view, mMovie);
        }
    }

}
