package com.tolmach.testtask;

import com.tolmach.testtask.CharacterDataClasses.DTO.CharacterDataDto;
import com.tolmach.testtask.CharacterDataClasses.DTO.CharacterInfoDTO;
import com.tolmach.testtask.CharacterDataClasses.DTO.Location;
import com.tolmach.testtask.CharacterDataClasses.DTO.Origin;

public class CharacterMapper {

    public CharacterInfo map(CharacterInfoDTO characterInfoDTO){
        CharacterInfo choosenCharacter = new CharacterInfo();
        CharacterDataDto character = characterInfoDTO.getCharacter();
        choosenCharacter.setName(character.getName());
        Location characterLocation = character.getLocation();
        choosenCharacter.setLocation(characterLocation.getName());
        choosenCharacter.setCreated(character.getCreated());
        choosenCharacter.setGender(character.getGender());
        choosenCharacter.setEpisode(String.valueOf(character.getEpisode()));
        choosenCharacter.setStatus(character.getStatus());
        choosenCharacter.setImage(character.getImage());
        return choosenCharacter;
    }
}
