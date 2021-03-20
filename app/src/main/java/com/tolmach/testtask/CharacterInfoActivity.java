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
        tvName = findViewById(R.id.tv_info_name);
        tvStatus = findViewById(R.id.tv_info_status);
        tvSpecies = findViewById(R.id.tv_info_species);
        tvType = findViewById(R.id.tv_info_type);
        tvGender = findViewById(R.id.tv_info_gender);
        tvEpisode = findViewById(R.id.tv_info_episode);
        tvCreated = findViewById(R.id.tv_info_created);
        ivImage = findViewById(R.id.iv_info_image);
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
                    public void onSuccess(CharacterInfo info) {
                        showInfo(info);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getStackTrace();
                        Toast.makeText(CharacterInfoActivity.this, "Request Error", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void showInfo(CharacterInfo info){
        String characterName = info.getName();
        String characterGender = info.getGender();
        String characterImage = info.getImage();
        String characterType = info.getType();
        String characterSpecies = info.getSpecies();
        String characterStatus = info.getStatus();
        String characterCreated = info.getCreated();
        String characterEpisode = info.getEpisode();
        System.out.println("test");
        System.out.println(characterCreated);
        tvName.setText(characterName);
        tvCreated.setText(characterCreated);
        tvEpisode.setText(characterEpisode);
        tvGender.setText(characterGender);
        tvStatus.setText(characterStatus);
        tvSpecies.setText(characterSpecies);
        tvType.setText(characterType);
        Picasso.get().load(characterImage).into(ivImage);
        ivImage.setVisibility(characterImage != null ? View.VISIBLE : View.GONE);
    }

}
