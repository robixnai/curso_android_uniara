package br.com.rmoreira.app.fragments;

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
import br.com.rmoreira.app.adapters.MoviesAdapter;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

public class FavoritesFragment extends Fragment implements OnItemClickListener {

    private View mView;

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
        bindAdapter();
        return mView;
    }

    public void bindAdapter() {
        MoviesAdapter adapter = new MoviesAdapter(getNewsList(), this);

        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    public List<Movie> getNewsList() {
        return new ArrayList<>();
    }

    @Override
    public void onItemClick(View view, Movie movie) {

    }

}
