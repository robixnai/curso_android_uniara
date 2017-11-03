package br.com.rmoreira.app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getExtras().getSerializable(MOVIE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(movie.getTitle());
        ((ImageView) findViewById(R.id.backdrop)).setImageResource(movie.getImageResources());
    }

}
