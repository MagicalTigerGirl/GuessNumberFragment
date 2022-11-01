package com.example.guessnumberfragment.iu;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.databinding.FragmentEndPlayBinding;

import java.util.Objects;

/**
 * Es la Activity final, donde muestra todos los resultados y si el jugador ha adivinado el número o no*/
public class EndPlayFragment extends Fragment {

    private FragmentEndPlayBinding binding;
    private static final String TAG = "EndPlayFragment";

    public EndPlayFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "EndPlayFragment -> onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "EndPlayFragment -> onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "EndPlayFragment -> onCreateView()");
        binding=FragmentEndPlayBinding.inflate(inflater);
        binding.setInformation(EndPlayFragmentArgs.fromBundle(getArguments()).getInformation());

        if(Objects.equals(binding.getInformation().getAcertado(), "1"))
        {
            binding.tvResultado.setText(getResources().getString(R.string.hasGanado));
            binding.tvDescripcionResultado.setText(" " + binding.getInformation().getUsuario() + getResources().getString(R.string.elNumeroEra) + " " + binding.getInformation().getNumero() + " " + getResources().getString(R.string.hasConsumido) + " " + binding.getInformation().getIntentos() + " " + getResources().getString(R.string.intentos));
        }
        else
        {
            binding.tvResultado.setText(getResources().getString(R.string.hasPerdido));
            binding.tvDescripcionResultado.setText(" " + binding.getInformation().getUsuario() + getResources().getString(R.string.elNumeroEra) + " " + binding.getInformation().getNumero());
        }

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "EndPlayFragment -> onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "EndPlayFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "EndPlayFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "EndPlayFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "EndPlayFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "EndPlayFragment -> onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "EndPlayFragment -> onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "EndPlayFragment -> onDetach()");
    }
}