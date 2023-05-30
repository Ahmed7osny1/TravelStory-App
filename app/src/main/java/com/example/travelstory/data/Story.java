package com.example.travelstory.data;

import kotlinx.parcelize.Parcelize;

@Parcelize
public class Story {
    private int id;
    private String Title;
    private String originLabel;
    private String date;
    private String textStory;
    private String language;
    private String authorId;
    private String authorGender;
    private String location;

    public Story(int id, String title, String originLabel, String date, String textStory,
                 String language, String authorId, String authorGender, String location) {
        this.id = id;
        Title = title;
        this.originLabel = originLabel;
        this.date = date;
        this.textStory = textStory;
        this.language = language;
        this.authorId = authorId;
        this.authorGender = authorGender;
        this.location = location;
    }

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
}
