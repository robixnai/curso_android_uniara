package br.com.rmoreira.app.contracts;

import android.view.View;

import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17
 */

public interface OnItemClickListener {

    void onItemClick(View view, Movie movie);

}