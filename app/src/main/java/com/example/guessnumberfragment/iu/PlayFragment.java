package com.example.guessnumberfragment.iu;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.Information;
import com.example.guessnumberfragment.databinding.FragmentPlayBinding;

import java.util.Random;

public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;
    private static final String TAG = "PlayFragment";
    private Integer numeroIntentos;
    Random random = new Random();
    private Integer numeroAAdivinar = random.nextInt((100 - 0) + 1);
    private Integer numeroIntroducido = 0;

    public PlayFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "PlayFragment -> onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "PlayFragment -> onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "PlayFragment -> onCreateView()");
        binding=FragmentPlayBinding.inflate(inflater);
        binding.setInformation(PlayFragmentArgs.fromBundle(getArguments()).getInformation());
        binding.getInformation().setNumero(String.valueOf(numeroAAdivinar));

        numeroIntentos = Integer.parseInt(binding.getInformation().getIntentos());
        binding.btnProbarNumero.setOnClickListener(view -> adivinarNumero());
        binding.btnVolverAIntentar.setOnClickListener(view -> volverAIntentar());

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "PlayFragment -> onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "PlayFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "PlayFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "PlayFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "PlayFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "PlayFragment -> onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PlayFragment -> onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "PlayFragment -> onDetach()");
    }

    private void adivinarNumero() {
        if (verificarCamposLlenos() == true)
        {
            numeroIntentos--;
            compararNumero(numeroAAdivinar, numeroIntroducido);
            binding.btnProbarNumero.setEnabled(false);
        }
        if (numeroIntentos == 0)
            ultimaActivity();
    }

    private boolean verificarCamposLlenos() {
        if (TextUtils.isEmpty(binding.etPosibleNumero.getText().toString()))
        {
            Toast.makeText(getActivity(), getResources().getString(R.string.errorEditTextVacio), Toast.LENGTH_SHORT).show();
            return false;
        }

        numeroIntroducido = Integer.parseInt(binding.etPosibleNumero.getText().toString());
        return true;
    }

    private void compararNumero(Integer numeroAAdivinar, Integer numeroIntroducido) {
        if(numeroAAdivinar<numeroIntroducido)
            numeroAAdivinarMenor();

        if(numeroAAdivinar==numeroIntroducido)
        {
            binding.getInformation().setAcertado("1");
            ultimaActivity();
        }

        if(numeroAAdivinar>numeroIntroducido)
            numeroAAdivinarMayor();
    }

    public void volverAIntentar(){
        if (numeroIntentos > 0)
        {
            binding.tvPrueba.setText("");
            binding.etPosibleNumero.setText("");
            binding.btnProbarNumero.setEnabled(true);
        }
        else
            Toast.makeText(getActivity(),getResources().getString(R.string.intentosAgotados),Toast.LENGTH_SHORT).show();
    }

    private void numeroAAdivinarMenor() {
        binding.tvPrueba.setText(getResources().getString(R.string.numeroMenor) + " " + numeroIntentos);
    }

    private void numeroAAdivinarMayor() {
        binding.tvPrueba.setText(getResources().getString(R.string.numeroMayor) + " " + numeroIntentos);
    }

    private void ultimaActivity() {
        binding.getInformation().setIntentos(String.valueOf((Integer.parseInt(binding.getInformation().getIntentos())-numeroIntentos)));

        PlayFragmentDirections.ActionPlayFragmentToEndPlayFragment2 action = PlayFragmentDirections.actionPlayFragmentToEndPlayFragment2(binding.getInformation());
        NavHostFragment.findNavController(this).navigate(action);
    }
}