package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        // Storing login action
        prefsEditor.putString("condition", "logined");
        prefsEditor.commit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bottomNavigationView.getMenu().findItem(R.id.logout)
                        .setOnMenuItemClickListener(menuItem -> {

                            // remove token from shared prefs
                            prefsEditor.remove("condition");
                            prefsEditor.apply();

                            Navigation.findNavController(view).navigate(
                                    R.id.action_homeFragment_to_splashFragment);

                            return true;
                        });

    }

}