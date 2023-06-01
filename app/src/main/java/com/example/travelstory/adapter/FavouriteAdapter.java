package com.example.travelstory.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelstory.R;
import com.example.travelstory.data.Story;
import com.example.travelstory.db.FavDB;

import java.util.ArrayList;
import java.util.Objects;

public class FavouriteAdapter extends BaseAdapter {

    Context context;
    ArrayList<Story> story;

    private FavDB favDB;

    public FavouriteAdapter(Context context, ArrayList<Story> story) {
        this.context = context;
        this.story = story;
    }


    @Override
    public int getCount() {
        return story.size();
    }

    @Override
    public Object getItem(int i) {
        return story.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        favDB = new FavDB(context);
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.story_item,
                    null, false);
        }

        TextView storyDate = v.findViewById(R.id.storyDate);
        TextView storyTitle = v.findViewById(R.id.storyTitle);
        TextView storyReflection = v.findViewById(R.id.storyText);
        TextView storyLocation = v.findViewById(R.id.storyLocation);
        TextView storyLanguage = v.findViewById(R.id.storyLanguage);
        ImageView favBtn = v.findViewById(R.id.favBtn);

        storyDate.setText(story.get(position).getDate());
        storyTitle.setText(story.get(position).getTitle());
        storyReflection.setText(story.get(position).getTextStory());
        storyLocation.setText(story.get(position).getLocation());
        storyLanguage.setText(story.get(position).getLanguage());

        if(Objects.equals(story.get(position).getFavStatus(), "1")){
            favBtn.setBackgroundResource(R.drawable.ic_fav_red);
        }

        return v;
    }
}