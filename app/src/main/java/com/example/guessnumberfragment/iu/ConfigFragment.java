package com.example.guessnumberfragment.iu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.Information;
import com.example.guessnumberfragment.databinding.FragmentConfigBinding;

public class ConfigFragment extends Fragment {

    private final String TAG = "ConfigFragment";
    private FragmentConfigBinding binding;

    public ConfigFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "ConfigFragment -> onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ConfigFragment -> onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "ConfigFragment -> onCreateView()");
        binding= FragmentConfigBinding.inflate(inflater);
        binding.setInformation(new Information());


        binding.btnComenzar.setOnClickListener(view -> config());

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "ConfigFragment -> onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "ConfigFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ConfigFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "ConfigFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "ConfigFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "ConfigFragment -> onDestroyView()");
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ConfigFragment -> onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "ConfigFragment -> onDetach()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState!=null)
            if (binding!=null)
                binding.setInformation(savedInstanceState.getParcelable(Information.KEY));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (binding!=null)
            outState.putParcelable(Information.KEY, binding.getInformation());
    }

    public void config()
    {
        if (VerificarCamposLlenos())
        {
            navegar();
        }
    }

    public boolean VerificarCamposLlenos(){

        if (TextUtils.isEmpty(binding.etNombre.getText().toString()) || TextUtils.isEmpty(binding.etNumeroIntentos.getText().toString()))
        {
            Toast.makeText(getActivity(), getResources().getString(R.string.errorEditTextVacio), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void navegar()
    {
        ConfigFragmentDirections.ActionConfigFragmentToPlayFragment action = ConfigFragmentDirections.actionConfigFragmentToPlayFragment(binding.getInformation());
        NavHostFragment.findNavController(this).navigate(action);
    }
}