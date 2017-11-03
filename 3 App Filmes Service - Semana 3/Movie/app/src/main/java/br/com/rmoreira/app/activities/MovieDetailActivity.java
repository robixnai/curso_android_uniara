package br.com.rmoreira.app.activities;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.models.Trailer;
import br.com.rmoreira.app.services.MovieService;

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE = "movie";

    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMovie = (Movie) getIntent().getExtras().getSerializable(MOVIE);

        bindToolBar();
        bindElmentes();
    }

    private void bindToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(mMovie.getTitle());
        Glide.with(this).load(mMovie.getImagePath()).into(((ImageView) findViewById(R.id.backdrop)));
    }

    private void bindElmentes() {
        TextView textViewYear = (TextView) findViewById(R.id.textViewYear);
        textViewYear.setText(mMovie.getYear());

        TextView textViewAverage = (TextView) findViewById(R.id.textViewAverage);
        textViewAverage.setText(getAverage());

        ImageView imageViewSave = (ImageView) findViewById(R.id.imageViewSave);
        imageViewSave.setOnClickListener(this);

        ImageView imageViewPlayYoutube = (ImageView) findViewById(R.id.imageViewPlayYoutube);
        imageViewPlayYoutube.setOnClickListener(this);

        TextView textViewSummary = (TextView) findViewById(R.id.textViewSummary);
        textViewSummary.setText(mMovie.getSummary());
    }

    private String getAverage() {
        Double average = mMovie.getAverage() * 10;
        return String.valueOf(average.intValue()).concat("%");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewSave:
                break;
            case R.id.imageViewPlayYoutube:
                getTrailers();
                break;
        }
    }

    private void getTrailers() {
        new AsyncTask<Void, Void, List<Trailer>>() {

            private ProgressDialog mProgressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                mProgressDialog = new ProgressDialog(MovieDetailActivity.this);
                mProgressDialog.setMessage("Aguarde...");
                mProgressDialog.show();
                mProgressDialog.setCancelable(false);
            }

            @Override
            protected List<Trailer> doInBackground(Void... voids) {
                List<Trailer> trailerList = new ArrayList<>();
                try {
                    trailerList = MovieService.getMovieTrailers(mMovie.getId()).getData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return trailerList;
            }

            @Override
            protected void onPostExecute(List<Trailer> trailers) {
                super.onPostExecute(trailers);

                if (!trailers.isEmpty()) {
                    Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:".concat(trailers.get(0).getKey())));
                    appIntent.putExtra("force_fullscreen", true);
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=".concat(trailers.get(0).getKey())));
                    webIntent.putExtra("force_fullscreen", true);
                    try {
                        startActivity(appIntent);
                    } catch (ActivityNotFoundException ex) {
                        startActivity(webIntent);
                    }
                }
            }

        }.execute();
    }

}
