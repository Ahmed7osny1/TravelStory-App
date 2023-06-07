package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentAddPostBinding;
import com.example.travelstory.db.FavDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class AddPostFragment extends Fragment {
    FragmentAddPostBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    int id = 12345678;
    String Title;
    String originLabel;
    String date;
    String textStory;
    String language;
    String authorId = "12345678";
    String authorGender;
    String location;
    FavDB favDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddPostBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calenderShow();
            }
        });

        binding.backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_addPostFragment_to_personFragment);
            }
        });

        binding.addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Add Post Successfully",
                        Toast.LENGTH_LONG).show();
                insertPost();
            }
        });
    }

    private void calenderShow(){

       Calendar calendar = Calendar.getInstance();
       int year = calendar.get(Calendar.YEAR);
       int month = calendar.get(Calendar.MONTH);
       int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                binding.date.setText(day + "-" + (month + 1) + "-" + year);
            }
        }, year, month, day);
        //currentTimeMillis
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();

    }

    private void insertPost() {

        favDB = new FavDB(getContext());

        Title = binding.title.getText().toString();
        textStory = Objects.requireNonNull(binding.storyTextBtn.getEditText()).getText().toString();
        language = Objects.requireNonNull(binding.language.getEditText()).getText().toString();
        location = Objects.requireNonNull(binding.location.getEditText()).getText().toString();
        date = binding.date.getText().toString();

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.labelOne:
                        originLabel = "Own Experience";
                        break;
                    case R.id.labelTwo:
                        originLabel = "Hearsay";
                        break;
                }
            }
        });

        binding.radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.labelMale:
                        authorGender = "Male";
                        break;
                    case R.id.labelFemale:
                        originLabel = "Female";
                        break;
                }
            }
        });

        // Storing login action
        id = prefs.getInt("id", 0) + 1;

        prefsEditor.putInt("id", id);
        prefsEditor.commit();


        favDB.insertIntoTheDatabase(
                id,
                Title,
                originLabel,
                date,
                textStory,
                language,
                authorId,
                authorGender,
                location,
                "0"
        );


    }
}