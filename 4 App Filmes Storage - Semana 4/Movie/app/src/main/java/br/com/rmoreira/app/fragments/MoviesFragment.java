package br.com.rmoreira.app.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.activities.MovieDetailActivity;
import br.com.rmoreira.app.adapters.EndlessRecyclerOnScrollListener;
import br.com.rmoreira.app.adapters.GenericAdapter;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.services.MovieService;
import br.com.rmoreira.app.storages.preferences.GenresSharedPreferences;
import br.com.rmoreira.app.storages.dao.MovieRepository;

public class MoviesFragment extends Fragment implements OnItemClickListener {

    private View mView;
    private GenericAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private LinearLayoutManager mLayoutManager;

    private List<Object> mMovieList = new ArrayList<>();
    private int page = 1;

    public MoviesFragment() {
    }

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_movies, container, false);
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();

        bindAdapter();
        getMovieList();
    }

    @Override
    public void onItemClick(View view, Object object) {
        Movie movie = (Movie) object;
        switch (view.getId()) {
            case R.id.imageViewSave:
                MovieRepository.getInstance().save(movie.movieMap());
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.imageViewShare:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, movie.getTitle());
                startActivity(Intent.createChooser(share, "Selecione uma da opções"));
                break;
            default:
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE, movie);
                startActivity(intent);
                break;
        }
    }

    private void bindAdapter() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        refreshScrollListener(mRecyclerView);

        mAdapter = new GenericAdapter(mMovieList, false, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @SuppressLint("StaticFieldLeak")
    private void getMovieList() {
        new AsyncTask<Void, Void, List<Movie>>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                if (page == 1)
                    mView.findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
            }

            @Override
            protected List<Movie> doInBackground(Void... voids) {
                List<Movie> movieList = new ArrayList<>();
                try {
                    movieList = MovieService.getPopularMovies(page).getMovies();
                    GenresSharedPreferences.putGenres(getContext(), MovieService.getGenreList().getGenres());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return movieList;
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                super.onPostExecute(movies);

                mView.findViewById(R.id.progress_bar).setVisibility(View.GONE);
                updateList(movies);
            }

        }.execute();
    }

    private void updateList(List<Movie> movies) {
        if (mMovieList != null && mMovieList.size() > 0)
            mMovieList.remove(mMovieList.size() - 1);

        if (movies != null && mMovieList != null)
            mMovieList.addAll(movies);

        mAdapter.updateList(mMovieList, true);
    }

    private void refreshScrollListener(RecyclerView recyclerView) {
        if (mOnScrollListener != null) {
            recyclerView.removeOnScrollListener(mOnScrollListener);
        }
        mOnScrollListener = new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                page = current_page;
                getMovieList();
            }
        };
        recyclerView.addOnScrollListener(mOnScrollListener);
    }

}
