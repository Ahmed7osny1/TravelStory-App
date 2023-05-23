package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    FragmentSplashBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(prefs.getString("condition", "").equals("logined")){
                    Navigation.findNavController(view).navigate(
                            R.id.action_splashFragment_to_homeFragment);
                }else {
                    if(prefs.getString("condition","").equals("onboard")) {
                        Navigation.findNavController(view).navigate(
                                R.id.action_splashFragment_to_loginFragment);
                    }else {
                        Navigation.findNavController(view).navigate(
                                R.id.action_splashFragment_to_startFragment);
                    }
                }

            }
        },3000);

    }
}