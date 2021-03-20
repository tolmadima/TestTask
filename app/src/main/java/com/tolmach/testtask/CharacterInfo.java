package com.tolmach.testtask;

import android.os.Parcel;
import android.os.Parcelable;

public class CharacterInfo implements Parcelable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String location;
    private String image;
    private String episode;
    private String created;

    public CharacterInfo(){
    }

    public CharacterInfo(String name, String status,String species, String type, String gender,
                         String location, String image, String episode, String created){
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.created = created;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.status);
        dest.writeString(this.species);
        dest.writeString(this.type);
        dest.writeString(this.gender);
        dest.writeString(this.location);
        dest.writeString(this.image);
        dest.writeString(this.episode);
        dest.writeString(this.created);
    }

    protected CharacterInfo(Parcel in){
        this.name = in.readString();
        this.status = in.readString();
        this.species = in.readString();
        this.type = in.readString();
        this.gender = in.readString();
        this.location = in.readString();
        this.image = in.readString();
        this.episode = in.readString();
        this.created = in.readString();
    }

    public static final Parcelable.Creator<CharacterInfo> CREATOR = new Parcelable.Creator<CharacterInfo>(){

        @Override
        public CharacterInfo createFromParcel(Parcel source) {
            return new CharacterInfo(source);
        }

        @Override
        public CharacterInfo[] newArray(int size) {
            return new CharacterInfo[size];
        }
    };
}
