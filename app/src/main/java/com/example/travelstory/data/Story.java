package com.example.travelstory.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Story implements Parcelable{
    private int id;
    private String Title;
    private String originLabel;
    private String date;
    private String textStory;
    private String language;
    private String authorId;
    private String authorGender;
    private String location;

    private String favStatus;

    public Story(int id, String title, String originLabel, String date, String textStory,
                 String language, String authorId, String authorGender, String location,
                 String favStatus) {
        this.id = id;
        Title = title;
        this.originLabel = originLabel;
        this.date = date;
        this.textStory = textStory;
        this.language = language;
        this.authorId = authorId;
        this.authorGender = authorGender;
        this.location = location;
        this.favStatus = favStatus;
    }

    public Story(Story story) {
        this.id = story.id;
        Title = story.Title;
        this.originLabel = story.originLabel;
        this.date = story.date;
        this.textStory = story.textStory;
        this.language = story.language;
        this.authorId = story.authorId;
        this.authorGender = story.authorGender;
        this.location = story.location;
        this.favStatus = story.favStatus;
    }

    protected Story(Parcel in) {
        id = in.readInt();
        Title = in.readString();
        originLabel = in.readString();
        date = in.readString();
        textStory = in.readString();
        language = in.readString();
        authorId = in.readString();
        authorGender = in.readString();
        location = in.readString();
        favStatus = in.readString();
    }


    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOriginLabel() {
        return originLabel;
    }

    public void setOriginLabel(String originLabel) {
        this.originLabel = originLabel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTextStory() {
        return textStory;
    }

    public void setTextStory(String textStory) {
        this.textStory = textStory;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(String authorGender) {
        this.authorGender = authorGender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(Title);
        parcel.writeString(originLabel);
        parcel.writeString(date);
        parcel.writeString(textStory);
        parcel.writeString(language);
        parcel.writeString(authorId);
        parcel.writeString(authorGender);
        parcel.writeString(location);
        parcel.writeString(favStatus);
    }
}
