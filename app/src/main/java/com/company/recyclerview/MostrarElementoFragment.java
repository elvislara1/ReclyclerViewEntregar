package com.company.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.company.recyclerview.databinding.FragmentMostrarElementoBinding;


public class MostrarElementoFragment extends Fragment {
    private FragmentMostrarElementoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarElementoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MundialViewModel mundiaViewModel = new ViewModelProvider(requireActivity()).get(MundialViewModel.class);

        mundiaViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Mundial>() {
            @Override
            public void onChanged(Mundial elemento) {
                binding.nombre.setText(elemento.nombre);
                binding.descripcion.setText(elemento.descripcion);
                binding.valoracion.setRating(elemento.valoracion);

                binding.valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        if(fromUser){
                            mundiaViewModel.actualizar(elemento, rating);
                        }
                    }
                });
            }
        });
    }
}
