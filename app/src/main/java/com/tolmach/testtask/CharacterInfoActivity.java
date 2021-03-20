package com.tolmach.testtask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.tolmach.testtask.CharacterDataClasses.DTO.Location;
import com.tolmach.testtask.CharacterDataClasses.DTO.Origin;

import org.w3c.dom.CharacterData;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CharacterInfoActivity extends AppCompatActivity {
    Context context;
    private TextView tvName;
    private TextView tvStatus;
    private TextView tvSpecies;
    private TextView tvType;
    private TextView tvGender;
    private TextView tvEpisode;
    private TextView tvCreated;
    private ImageView ivImage;


    private CharacterInfo characterInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_info_activity);
//        tvName = findViewById(R.layout.);
//        tvStatus = findViewById(R.layout.);
//        tvSpecies = findViewById(R.layout.);
//        tvType = findViewById(R.layout.);
//        tvGender = findViewById(R.layout.);
//        tvEpisode = findViewById(R.layout.);
//        tvCreated = findViewById(R.layout.);
        ivImage = findViewById(R.id.char_info_iv);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        RickAndMortyClient client = ServiceGenerator.getInstance().getRickAndMortyClient();
        client.getCharacterInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CharacterInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(CharacterInfo value) {
                        showInfo(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(CharacterInfoActivity.this, "Request Error", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void showInfo(CharacterInfo value){
        String characterName = value.getName();
        String characterGender = value.getGender();
        String characterImage = value.getImage();
        String characterType = value.getType();
        String characterSpecies = value.getSpecies();
        String characterStatus = value.getStatus();
        String characterCreated = value.getCreated();
        String characterEpisode = value.getEpisode();
        System.out.println("test");
        System.out.println(characterCreated);
//        tvName.setText(characterName);
//        tvCreated.setText(characterCreated);
//        tvEpisode.setText(characterEpisode);
//        tvGender.setText(characterGender);
//        tvStatus.setText(characterStatus);
//        tvSpecies.setText(characterSpecies);
//        tvType.setText(characterType);
        Picasso.get().load(characterImage).into(ivImage);
        ivImage.setVisibility(characterImage != null ? View.VISIBLE : View.GONE);
    }

}
