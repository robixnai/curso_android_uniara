package br.com.rmoreira.app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getExtras().getSerializable(MOVIE);
        setTitle(movie.getTitle());
    }

}
