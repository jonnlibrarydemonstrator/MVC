package com.master.killercode.mcv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.master.killercode.mcv.R;
import com.quanticheart.lib.dao.model.BestMovieModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("unused")
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.DataHolder> {

    /**
     * create array empty
     */
    private final ArrayList<BestMovieModel> database = new ArrayList<>();

    /**
     * Recycler view adapter default methods
     */

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_list, parent, false);
        ButterKnife.bind(this, v);
        return new DataHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, final int position) {
        holder.DataBind(database.get(position));
        holder.delete.setOnClickListener(view -> {
            if (delete != null)
                delete.onClick(view, database.get(position));
        });
        holder.edit.setOnClickListener(view -> {
            if (edit != null)
                edit.onClick(view, database.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return database.size();
    }

    /**
     * Adapter Set
     */
    public void addDataBase(ArrayList<BestMovieModel> list) {
            database.clear();
            database.addAll(list);
            notifyDataSetChanged();
    }

    /**
     * Holder for RecyclerView
     */
    class DataHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.desc)
        TextView desc;

        @BindView(R.id.ratingBar)
        RatingBar rating;

        @BindView(R.id.editButton)
        ImageButton edit;

        @BindView(R.id.deleteButton)
        ImageButton delete;

        DataHolder(@NonNull View itemView) {
            super(itemView);
        }

        void DataBind(BestMovieModel model) {
            title.setText(model.getTitleMovie());
            desc.setText(model.getLitleDescMovie());
            rating.setRating(model.getRattingMovie());
        }
    }

    /**
     * Interface Delete
     */

    private OnDeleteListener delete;

    public interface OnDeleteListener {
        void onClick(View view, BestMovieModel bestMovieModel);
    }

    public void setDeleteOnClickListener(OnDeleteListener delete) {
        this.delete = delete;
    }

    /**
     * Interface Edit
     */

    private OnEditListener edit;

    @SuppressWarnings("EmptyMethod")
    public interface OnEditListener {
        void onClick(View view, BestMovieModel bestMovieModel);
    }

    public void setEditOnClickListener(OnEditListener edit) {
        this.edit = edit;
    }
}