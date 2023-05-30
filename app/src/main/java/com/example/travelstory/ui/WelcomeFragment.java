package com.example.travelstory.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentWelcomeBinding;

import java.util.ArrayList;

public class WelcomeFragment extends Fragment {

    FragmentWelcomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);

        imageSliderSetup();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ownExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToLabelFilterFragment action = WelcomeFragmentDirections
                        .actionWelcomeFragmentToLabelFilterFragment("Own Experience");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.hearSay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToLabelFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToLabelFilterFragment("Hearsay");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment("German");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.finland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment("Finland");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.poland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment("Poland");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.italy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment("Italy");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.unitedkingdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "United Kingdom");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.argentina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "Argentina");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.brazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "Brazil");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.switzerland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "Switzerland");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.seychelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "Seychelles");

                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.unitedstates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.travelstory.ui.WelcomeFragmentDirections
                        .ActionWelcomeFragmentToCountryFilterFragment action =
                        WelcomeFragmentDirections
                                .actionWelcomeFragmentToCountryFilterFragment(
                                        "United States");

                Navigation.findNavController(view).navigate(action);
            }
        });

    }

    private void imageSliderSetup() {
        ArrayList<SlideModel> imageList = new ArrayList<SlideModel>();

        imageList.add(
                new SlideModel(
                        R.drawable.verbal,
                        "The Verbal Story",
                        ScaleTypes.FIT
                )
        );
        imageList.add(
                new SlideModel(
                        R.drawable.paraverbal,
                        "The paraverbal Story",
                        ScaleTypes.FIT
                )
        );
        imageList.add(
                new SlideModel(
                        R.drawable.nonverbal,
                        "The nonVerbal Story",
                        ScaleTypes.FIT
                )
        );
        imageList.add(
                new SlideModel(
                        R.drawable.proxemic,
                        "The proxemic Story",
                        ScaleTypes.FIT
                )
        );

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(imageList);
    }


}