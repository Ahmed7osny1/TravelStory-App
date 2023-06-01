package com.example.travelstory.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.travelstory.R;
import com.example.travelstory.adapter.StoryAdapter;
import com.example.travelstory.data.Story;
import com.example.travelstory.data.StoryData;
import com.example.travelstory.databinding.FragmentCountryFilterBinding;

import java.util.ArrayList;

public class CountryFilterFragment extends Fragment {

    FragmentCountryFilterBinding binding;
    String jsonText, location;
    ArrayList<Story> story, country;
    StoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCountryFilterBinding.inflate(inflater, container, false);

        location = getArguments().getString("location");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        StoryData storyData = new StoryData();

        jsonText =storyData.readJSON(getContext());
        story = new ArrayList<>();

        story = storyData.parseJSON(jsonText,getContext());

        country = storyData.getCountry(location, story);

        adapter = new StoryAdapter(getContext(), country);


        binding.rvStoriesCountry.setAdapter(adapter);

        binding.rvStoriesCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Story myCustomObject = new Story(country.get(i));
                Bundle bundle = new Bundle();
                bundle.putParcelable("myCustomObject", myCustomObject);

                Navigation.findNavController(view).navigate(
                        R.id.action_countryFilterFragment_to_detailsFragment, bundle);

            }
        });


    }
}