package br.com.rmoreira.app.adapters.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.storages.dao.MovieRepository;
import br.com.rmoreira.app.utils.MovieUtils;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public final class MoviesViewHolder extends GenericViewHolder<Movie> {

    private View mView;
    private boolean mIsFavorite;
    private ImageView mImageViewMovie, mImageViewSave, mImageViewShare;
    private TextView mTextViewTitle, mTextViewAverage, mTextViewYear, mTextViewCategory, mTextViewSummary;

    public MoviesViewHolder(View view, boolean isFavorite, OnItemClickListener listener) {
        super(view, listener);

        mView = view;
        mIsFavorite = isFavorite;

        mImageViewMovie = (ImageView) view.findViewById(R.id.imageViewMovie);
        mImageViewSave = (ImageView) view.findViewById(R.id.imageViewSave);
        mImageViewShare = (ImageView) view.findViewById(R.id.imageViewShare);

        mTextViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        mTextViewAverage = (TextView) view.findViewById(R.id.textViewAverage);
        mTextViewYear = (TextView) view.findViewById(R.id.textViewYear);
        mTextViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
        mTextViewSummary = (TextView) view.findViewById(R.id.textViewSummary);
    }

    @Override
    public void onBindViewHolder(Movie movie) {
        super.onBindViewHolder(movie);

        if (mIsFavorite) {
            mImageViewSave.setImageResource(R.drawable.ic_delete);
        } else {
            if (MovieRepository.getInstance().isMovie(movie.movieMap())) {
                mImageViewSave.setImageResource(R.drawable.ic_saved);
            } else {
                mImageViewSave.setImageResource(R.drawable.ic_save);
            }
        }

        Glide.with(mView.getContext()).load(movie.getImagePath()).into(mImageViewMovie);
        mTextViewTitle.setText(movie.getTitle());
        mTextViewAverage.setText(movie.getAverage().toString());
        mTextViewYear.setText(movie.getYear());
        mTextViewCategory.setText(MovieUtils.getCategory(movie.getGenres()));
        mTextViewSummary.setText(movie.getSummary());

        mImageViewSave.setOnClickListener(this);
        mImageViewShare.setOnClickListener(this);
    }

}
