package com.example.android3lesson2.ui.film;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.databinding.ItemFilmBinding;
import com.example.android3lesson2.model.FilmModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<FilmModel> list = new ArrayList<>();
    private OnClickFilmAdapter listener;

    public FilmAdapter(OnClickFilmAdapter listener) {
        this.listener = listener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemFilmBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(List<FilmModel> list) {
        if (list != null) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmBinding binding;

        public ViewHolder(@NonNull @NotNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FilmModel model) {
            binding.textTitleItemFilm.setText(model.getTitle());
            binding.getRoot().setOnClickListener(v -> {
                listener.onClick(model.getId());
            });
        }
    }

    interface OnClickFilmAdapter {
        void onClick(String id);
    }
}
