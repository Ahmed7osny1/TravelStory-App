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
import com.example.travelstory.databinding.FragmentPersonBinding;

public class PersonFragment extends Fragment {

    FragmentPersonBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPersonBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.yourName.setText(prefs.getString("name",""));
        binding.yourEmail.setText(prefs.getString("email",""));
        binding.yourPassword.setText(prefs.getString("password",""));
        binding.yourPhone.setText(prefs.getString("phone",""));

        binding.addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_personFragment_to_addPostFragment);
            }
        });

    }
}