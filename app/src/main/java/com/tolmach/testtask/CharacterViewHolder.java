package com.tolmach.testtask;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CharacterViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private ImageView ivImage;
    private CharacterAdapter.OnCharacterListener mOnCharacterListener;

    public CharacterViewHolder(View itemView, CharacterAdapter.OnCharacterListener onCharacterListener) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        ivImage = itemView.findViewById(R.id.iv_image);
        mOnCharacterListener = onCharacterListener;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCharacterListener.onCharacterClick(getAdapterPosition());
            }
        });
    }
    public void bind(Character character){
        tvName.setText(character.getName());
        String imageUrl = character.getImage();
        Picasso.get().load(imageUrl).into(ivImage);
        ivImage.setVisibility(imageUrl != null ? View.VISIBLE : View.GONE);
    }
}
