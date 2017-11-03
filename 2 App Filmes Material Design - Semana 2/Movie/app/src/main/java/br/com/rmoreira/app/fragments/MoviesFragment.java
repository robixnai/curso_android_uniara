package br.com.rmoreira.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.activities.MovieDetailActivity;
import br.com.rmoreira.app.adapters.MoviesAdapter;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.models.MovieRepository;

public class MoviesFragment extends Fragment implements OnItemClickListener {

    private View mView;

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
        mView = inflater.inflate(R.layout.fragment_home, container, false);
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
        return MovieRepository.getMovieList();
    }

    @Override
    public void onItemClick(View view, Movie movie) {
        switch (view.getId()) {
            case R.id.imageViewSave:
                Toast.makeText(getContext(), "Salvar nos favoritos", Toast.LENGTH_SHORT).show();
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

}
