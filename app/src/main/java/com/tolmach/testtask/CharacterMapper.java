package com.tolmach.testtask;

import com.tolmach.testtask.CharacterDataClasses.DTO.Example;
import com.tolmach.testtask.CharacterDataClasses.DTO.Location;

import java.util.List;

public class CharacterMapper {

    public CharacterInfo map(Example example){
        CharacterInfo choosenCharacter = new CharacterInfo();
        choosenCharacter.setName(example.getName());
        Location location = example.getLocation();
        choosenCharacter.setLocation(location.getName());
        choosenCharacter.setCreated(example.getCreated());
        choosenCharacter.setGender(example.getGender());
        List<String> episodes = example.getEpisode();
        choosenCharacter.setEpisode(episodes.get(1));
        choosenCharacter.setStatus(example.getStatus());
        choosenCharacter.setImage(example.getImage());
        return choosenCharacter;
    }
}
