package com.example.travelstory.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelstory.R;
import com.example.travelstory.data.Story;
import com.example.travelstory.databinding.FragmentDetailsBinding;


public class DetailsFragment extends Fragment {

    FragmentDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Story story = bundle.getParcelable("myCustomObject");
            binding.Title.setText(story.getTitle());
            binding.date.setText(story.getDate());
            binding.originLabel.setText(story.getOriginLabel());
            binding.storyid.setText("# " + story.getId());
            binding.textStory.setText(story.getTextStory());
            binding.authorId.setText(story.getAuthorId());
            binding.gender.setText(story.getAuthorGender());
            binding.storyLanguage.setText(story.getLanguage());
            binding.storyLocation.setText(story.getLocation());
        }
    }
}