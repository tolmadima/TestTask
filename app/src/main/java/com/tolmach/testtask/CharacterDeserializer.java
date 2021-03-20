package com.tolmach.testtask;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CharacterDeserializer implements JsonDeserializer<List<Character>> {

    private final String PARS_PARAM = "object";
    private final String CHAR_PRARAM = "results";

    @Override
    public List<Character> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println("deserializing");
        System.out.println(json);
        JsonObject jsonObject = json.getAsJsonObject();
        List<Character> parsedCharacters = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray parsing = jsonObject.getAsJsonArray("results");
            JSONArray charJson = new JSONArray(gson.toJson(parsing));
            for (int i = 0; i < parsing.size(); i++){
                Character characterData = gson.fromJson(parsing.get(i), Character.class);
                parsedCharacters.add(i, characterData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsedCharacters;
    }
}
