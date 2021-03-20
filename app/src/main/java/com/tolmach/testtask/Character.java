package com.tolmach.testtask;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {

    private String name;
    private String image;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getImage(){
        return image;
    }

    public void setName(String charactername){
        name = charactername;
    }

    public void setImage(String characterImageUrl){
        image = characterImageUrl;
    }

    public Character(String id, String name, String image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    protected Character(Parcel in){
        id = in.readString();
        name = in.readString();
        image = in.readString();
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
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
    }
}
