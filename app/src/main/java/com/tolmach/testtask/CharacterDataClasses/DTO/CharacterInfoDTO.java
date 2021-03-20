package com.tolmach.testtask.CharacterDataClasses.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tolmach.testtask.CharacterDataClasses.DTO.CharacterDataDto;

public class CharacterInfoDTO {

    @SerializedName("character")
    @Expose
    private CharacterDataDto character;

    public CharacterDataDto getCharacter(){
        return character;
    }

    public void setCharacter(CharacterDataDto character){
        this.character = character;
    }
}
