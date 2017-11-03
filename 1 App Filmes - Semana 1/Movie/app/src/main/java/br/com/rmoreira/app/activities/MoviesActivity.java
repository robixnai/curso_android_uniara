package br.com.rmoreira.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.adapters.MoviesAdapter;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.models.MovieRepository;

public class MoviesActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    @Override
    protected void onResume() {
        super.onResume();

        bindAdapter();
    }

    public void bindAdapter() {
        MoviesAdapter adapter = new MoviesAdapter(this, getNewsList(), this);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public List<Movie> getNewsList() {
        return MovieRepository.getMovieList();
    }

    @Override
    public void onItemClick(View view, Movie movie) {
        Intent intent = new Intent(MoviesActivity.this, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.MOVIE, movie);
        startActivity(intent);
    }

}
