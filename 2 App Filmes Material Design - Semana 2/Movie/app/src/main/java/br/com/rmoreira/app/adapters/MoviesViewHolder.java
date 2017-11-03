package br.com.rmoreira.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public final class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private View mView;
    private Movie mMovie;
    private OnItemClickListener mListener;

    private ImageView mImageViewMovie, mImageViewSave, mImageViewShare;
    private TextView mTextViewTitle, mTextViewAverage, mTextViewYear, mTextViewCategory, mTextViewSummary;

    public MoviesViewHolder(View view, OnItemClickListener listener) {
        super(view);

        mView = view;
        mListener = listener;

        mImageViewMovie = (ImageView) view.findViewById(R.id.imageViewMovie);
        mImageViewSave = (ImageView) view.findViewById(R.id.imageViewSave);
        mImageViewShare = (ImageView) view.findViewById(R.id.imageViewShare);

        mTextViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        mTextViewAverage = (TextView) view.findViewById(R.id.textViewAverage);
        mTextViewYear = (TextView) view.findViewById(R.id.textViewYear);
        mTextViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
        mTextViewSummary = (TextView) view.findViewById(R.id.textViewSummary);
    }

    public void onBindViewHolder(Movie movie) {
        mMovie = movie;

        mImageViewMovie.setImageResource(movie.getImageResources());
        mTextViewTitle.setText(movie.getTitle());
        mTextViewAverage.setText(movie.getAverage().toString());
        mTextViewYear.setText(String.valueOf(movie.getYear()));
        mTextViewCategory.setText(movie.getCategory());
        mTextViewSummary.setText(movie.getSummary());

        mView.setOnClickListener(this);
        mImageViewSave.setOnClickListener(this);
        mImageViewShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onItemClick(view, mMovie);
        }
    }

}
