package com.tolmach.testtask;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RickAndMortyClient {

    @GET("character")
    Single<List<Character>> getCharacters();
    @GET("character/{id}")
    Single<CharacterInfo> getCharacterInfo(@Path("id") String id);
}
