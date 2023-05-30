package com.example.travelstory.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelstory.R;
import com.example.travelstory.adapter.StoryAdapter;
import com.example.travelstory.data.Story;
import com.example.travelstory.data.StoryData;
import com.example.travelstory.databinding.FragmentStoryBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class StoryFragment extends Fragment {

    FragmentStoryBinding binding;

    String jsonText;
    ArrayList<Story> story;

    StoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStoryBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jsonText = new StoryData().readJSON(getContext());
        story = new ArrayList<>();

        story = new StoryData().parseJSON(jsonText);

        adapter = new StoryAdapter(getContext(), story);

        binding.rvStories.setAdapter(adapter);

        binding.rvStories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = story.get(i).getDate();
                Toast.makeText(getActivity(), name, Toast.LENGTH_LONG).show();

            }
        });


    }





}