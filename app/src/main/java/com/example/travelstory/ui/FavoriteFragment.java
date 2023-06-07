package com.example.travelstory.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.travelstory.R;
import com.example.travelstory.adapter.FavouriteAdapter;
import com.example.travelstory.adapter.StoryAdapter;
import com.example.travelstory.data.Story;
import com.example.travelstory.databinding.FragmentFavoriteBinding;
import com.example.travelstory.db.FavDB;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;
    private FavDB favDB;
    FavouriteAdapter adapter;
    private ArrayList<Story> favItemList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);

        favDB = new FavDB(getActivity());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();

        binding.rvFavourite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                favDB.remove_fav(Integer.toString(favItemList.get(i).getId()));

                Toast.makeText(getContext(), "Item Removed Successfully",
                        Toast.LENGTH_LONG).show();

                adapter.notifyDataSetChanged();
            }
        });

        binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.pullToRefresh.setRefreshing(false);

                loadData();

                binding.rvFavourite.setAdapter(adapter);
            }
        });


    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.select_all_favorite_list();
        try {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndexOrThrow(FavDB.KEY_ID));
                String title = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.STORY_TITLE));
                String originLabel = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.ORIGIN_LABEL));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(FavDB.STORY_DATE));
                String textStory = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.STORY_TEXT));
                String language = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.STORY_LANGUAGE));
                String authorID = cursor.getString(cursor.getColumnIndexOrThrow(
                        FavDB.AUTHOR_ID));
                String gender = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.AUTHOR_GENDER));
                String location = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.STORY_LOCATION));
                String favStatus = cursor.getString(
                        cursor.getColumnIndexOrThrow(FavDB.FAVORITE_STATUS));

                Story favItem = new Story(
                        Integer.parseInt(id),
                        title,
                        originLabel,
                        date,
                        textStory,
                        language,
                        authorID,
                        gender,
                        location,
                        favStatus
                );
                favItemList.add(favItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        Log.d("FavDB Status", favItemList.toString());
        adapter = new FavouriteAdapter(getContext(), favItemList);

        binding.rvFavourite.setAdapter(adapter);

    }

}