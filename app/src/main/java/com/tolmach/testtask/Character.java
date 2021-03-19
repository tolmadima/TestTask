package com.tolmach.testtask;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {

    private String name;
    private String imageUrl;
    private String species;
    private String type;
    private String gender;
    private String status;
    private String episode;
    private String created;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setName(String charactername){
        name = charactername;
    }

    public void setImageUrl(String characterImageUrl){
        imageUrl = characterImageUrl;
    }

    public Character(String name, String imageUrl, String species, String type, String gender, String status, String episode, String created){
        this.name = name;
        this.imageUrl = imageUrl;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.status = status;
        this.episode = episode;
        this.created = created;
    }

    protected Character(Parcel in){
        name = in.readString();
        imageUrl = in.readString();
        species = in.readString();
        type = in.readString();
        gender = in.readString();
        status = in.readString();
        episode = in.readString();
        created = in.readString();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeString(type);
        dest.writeString(species);
        dest.writeString(status);
        dest.writeString(episode);
        dest.writeString(gender);
        dest.writeString(created);
    }
}
