package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentSplashBinding;
import com.example.travelstory.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    FragmentStartBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Storing login action
                prefsEditor.putString("condition", "onboard");
                prefsEditor.commit();
                Navigation.findNavController(view).navigate(
                        R.id.action_startFragment_to_loginFragment);
            }
        });
    }
}