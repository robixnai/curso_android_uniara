package br.com.rmoreira.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.rmoreira.app.R;
import br.com.rmoreira.app.adapters.holders.GenericViewHolder;
import br.com.rmoreira.app.adapters.holders.LoadingViewHolder;
import br.com.rmoreira.app.adapters.holders.MoviesViewHolder;
import br.com.rmoreira.app.contracts.OnItemClickListener;
import br.com.rmoreira.app.models.Movie;

/**
 * Created by robsonmoreira on 10/10/17.
 */

public class GenericAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List<Object> mItens;
    private OnItemClickListener mListener;

    public GenericAdapter(List<Object> item, OnItemClickListener listener) {
        mItens = item;
        mListener = listener;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_movies_itens, parent, false);
        if (viewType == GenericType.MOVIES.ordinal()) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_movies_itens, parent, false);
            return new MoviesViewHolder(view, mListener);
        } else if (viewType == GenericType.LOADING.ordinal()) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_loading, parent, false);
            return new LoadingViewHolder(view);
        }

        return new MoviesViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        Object object = mItens.get(position);
        holder.onBindViewHolder(object);
    }

    @Override
    public int getItemViewType(int position) {
        Object item = mItens.get(position);
        if (item instanceof Movie)
            return GenericType.MOVIES.ordinal();
        else if (item.toString().equals(GenericType.LOADING.getAbbreviation()))
            return GenericType.LOADING.ordinal();
        else return -1;
    }

    @Override
    public int getItemCount() {
        return mItens != null ? mItens.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void updateList(List<Object> itens) {
        mItens = itens;
        if (mItens.size() > 0) {
            mItens.add(GenericType.LOADING.getAbbreviation());
        }
        notifyDataSetChanged();
    }

}
