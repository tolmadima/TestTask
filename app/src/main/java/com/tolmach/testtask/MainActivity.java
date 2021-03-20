package com.tolmach.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    List<Character> requestedCharacters = new ArrayList<>();
    CharacterAdapter characterAdapter = new CharacterAdapter(this::onCharacterClick);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitRequest();
        initRecyclerView();
    }

    private void retrofitRequest(){
        System.out.println("Starting Request");
        RickAndMortyClient client = ServiceGenerator.getInstance().getRickAndMortyClient();
        client.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Character>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Character> value) {
                        requestedCharacters = value;
                        showCharacters(requestedCharacters);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        String requestErrorText = "RequestError";
                        Toast.makeText(MainActivity.this, requestErrorText, Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void showCharacters(List<Character> requestedCharacters){
        characterAdapter.addItems(requestedCharacters);
    }

    private void initRecyclerView() {
        RecyclerView characterRecyclerView = findViewById(R.id.characterlist);
        characterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        characterAdapter = new CharacterAdapter(new CharacterAdapter.OnCharacterListener() {
            @Override
            public void onCharacterClick(int position) {
                MainActivity.this.onCharacterClick(position);
            }
        });
        characterRecyclerView.setAdapter(characterAdapter);
    }
    private void onCharacterClick(int position){
        Intent intent = new Intent(MainActivity.this, CharacterInfoActivity.class);
        intent.putExtra("id", requestedCharacters.get(position).getId());
        startActivity(intent);
    }

}
