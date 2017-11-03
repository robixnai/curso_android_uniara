package br.com.rmoreira.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.activities.MovieDetailActivity;
import br.com.rmoreira.app.adapters.GenericAdapter;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.storages.dao.MovieDao;
import br.com.rmoreira.app.storages.dao.MovieRepository;

public class FavoritesFragment extends Fragment implements OnItemClickListener {

    private View mView;
    private GenericAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private List<Object> mMovieList = new ArrayList<>();

    public FavoritesFragment() {
    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_favorites, container, false);
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();

        bindAdapter();
        getMovieListDao();
    }

    @Override
    public void onItemClick(View view, Object object) {
        Movie movie = (Movie) object;
        switch (view.getId()) {
            case R.id.imageViewSave:
                MovieRepository.getInstance().delete(movie.movieMap());
                mAdapter.removeItemList(object);
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));

        mAdapter = new GenericAdapter(new ArrayList<>(), true, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getMovieListDao() {
        List<MovieDao> movieList = MovieRepository.getInstance().getAll();
        if (movieList != null && !movieList.isEmpty()) {
            List<Movie> movies = new ArrayList<>();
            for (MovieDao movieDao : movieList) {
                movies.add(movieDao.movieMap());
            }
            updateList(movies);
        } else {
            mAdapter.showNotData();
        }
    }

    private void updateList(List<Movie> movies) {
        if (mMovieList != null && mMovieList.size() > 0)
            mMovieList.remove(mMovieList.size() - 1);

        if (movies != null && mMovieList != null)
            mMovieList.addAll(movies);

        mAdapter.updateList(mMovieList, false);
    }

}
