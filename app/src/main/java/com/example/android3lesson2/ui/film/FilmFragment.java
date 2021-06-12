package com.example.android3lesson2.ui.film;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentFilmBinding;
import com.example.android3lesson2.model.FilmModel;
import com.example.android3lesson2.network.FilmRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FilmFragment extends Fragment implements FilmAdapter.OnClickFilmAdapter {

    public static final String ID = "id";
    protected FragmentFilmBinding binding;
    protected FilmAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        getFilm();
    }

    private void init() {
        adapter = new FilmAdapter(this);
        binding.recyclerView.setAdapter(adapter);
    }

    private void getFilm() {
        FilmRepository.getFilm(new FilmRepository.FilmCallback() {
            @Override
            public void onSuccess(List<FilmModel> list) {
                adapter.addList(list);
            }

            @Override
            public void onFailure(String message) {
            }
        });
    }

    @Override
    public void onClick(String id) {
        NavController navController = ((NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        Bundle bundle = new Bundle();
        bundle.putString(ID, id);
        setArguments(bundle);
        navController.navigate(R.id.descriptionFragment, bundle);
    }
}